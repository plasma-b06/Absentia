-- Database: absentia made by grok
CREATE DATABASE IF NOT EXISTS absentia
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE absentia;

-- 1. Users / Authentication (admin, teachers, possibly students)
CREATE TABLE users (
    id              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username        VARCHAR(50) UNIQUE NOT NULL,
    email           VARCHAR(100) UNIQUE NOT NULL,
    password_hash   VARCHAR(255) NOT NULL,
    full_name       VARCHAR(100) NOT NULL,
    role            ENUM('admin', 'teacher', 'student', 'parent') NOT NULL DEFAULT 'student',
    is_active       BOOLEAN DEFAULT TRUE,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 2. Departments / Classes / Branches
CREATE TABLE departments (
    id          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code        VARCHAR(10) UNIQUE NOT NULL,       -- CS, IT, MECH, etc.
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- 3. Courses / Subjects
CREATE TABLE courses (
    id              INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code            VARCHAR(20) UNIQUE NOT NULL,     -- CS101, MATH201
    name            VARCHAR(100) NOT NULL,
    department_id   INT UNSIGNED,
    credits         TINYINT UNSIGNED DEFAULT 4,
    semester        TINYINT UNSIGNED,                -- 1–8
    is_active       BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (department_id) REFERENCES departments(id)
        ON DELETE SET NULL
);

-- 4. Batches / Academic Years / Divisions
CREATE TABLE batches (
    id              INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(50) NOT NULL,            -- 2023-2027, FE-A, SY-B, etc.
    start_year      YEAR NOT NULL,
    end_year        YEAR,
    department_id   INT UNSIGNED,
    FOREIGN KEY (department_id) REFERENCES departments(id)
        ON DELETE SET NULL
);

-- 5. Students
CREATE TABLE students (
    id              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    prn             VARCHAR(20) UNIQUE NOT NULL,     -- Permanent Registration Number / Roll No
    user_id         BIGINT UNSIGNED UNIQUE,
    batch_id        INT UNSIGNED,
    department_id   INT UNSIGNED,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    email           VARCHAR(100) UNIQUE,
    phone           VARCHAR(15),
    gender          ENUM('M','F','O','U') DEFAULT 'U',
    date_of_birth   DATE,
    admission_year  YEAR,
    is_active       BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (user_id)     REFERENCES users(id)         ON DELETE SET NULL,
    FOREIGN KEY (batch_id)    REFERENCES batches(id)       ON DELETE SET NULL,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
);

-- 6. Teachers / Faculty
CREATE TABLE teachers (
    id              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT UNSIGNED UNIQUE,
    employee_id     VARCHAR(20) UNIQUE,
    department_id   INT UNSIGNED,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    email           VARCHAR(100) UNIQUE,
    phone           VARCHAR(15),
    is_class_teacher BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id)       REFERENCES users(id)         ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES departments(id)   ON DELETE SET NULL
);

-- 7. Course – Teacher assignment (many-to-many)
CREATE TABLE course_teachers (
    course_id   INT UNSIGNED,
    teacher_id  BIGINT UNSIGNED,
    batch_id    INT UNSIGNED NULL,               -- optional: specific batch/section
    academic_year VARCHAR(9) NOT NULL,           -- 2024-2025
    PRIMARY KEY (course_id),
    FOREIGN KEY (course_id)  REFERENCES courses(id)   ON DELETE CASCADE,
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)  ON DELETE CASCADE,
    FOREIGN KEY (batch_id)   REFERENCES batches(id)   ON DELETE SET NULL
);

-- 8. Attendance Sessions / Lectures
CREATE TABLE attendance_sessions (
    id              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    course_id       INT UNSIGNED NOT NULL,
    teacher_id      BIGINT UNSIGNED NOT NULL,
    batch_id        INT UNSIGNED NOT NULL,
    session_date    DATE NOT NULL,
    start_time      TIME,
    end_time        TIME,
    lecture_number  TINYINT UNSIGNED,             -- 1st, 2nd lecture of the day
    is_substitute   BOOLEAN DEFAULT FALSE,
    remarks         TEXT,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY unique_session (course_id, batch_id, session_date, start_time),
    FOREIGN KEY (course_id)  REFERENCES courses(id)   ON DELETE CASCADE,
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)  ON DELETE CASCADE,
    FOREIGN KEY (batch_id)   REFERENCES batches(id)   ON DELETE CASCADE
);

-- 9. Attendance Records (the most important table)
CREATE TABLE attendance (
    id              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    session_id      BIGINT UNSIGNED NOT NULL,
    student_id      BIGINT UNSIGNED NOT NULL,
    status          ENUM('present', 'absent', 'late', 'excused', 'holiday') NOT NULL DEFAULT 'absent',
    marked_by       BIGINT UNSIGNED,                    -- teacher who marked
    marked_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    justification   TEXT,                               -- reason if excused
    FOREIGN KEY (session_id) REFERENCES attendance_sessions(id) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES students(id)     ON DELETE CASCADE,
    FOREIGN KEY (marked_by)  REFERENCES teachers(id)     ON DELETE SET NULL,
    UNIQUE KEY unique_attendance (session_id, student_id)
);

-- 10. Holidays / Non-working days (optional but useful)
CREATE TABLE holidays (
    id          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    holiday_date DATE NOT NULL,
    name        VARCHAR(100),
    is_recurring BOOLEAN DEFAULT FALSE,          -- e.g. Diwali, Christmas
    academic_year VARCHAR(9),
    UNIQUE KEY unique_holiday (holiday_date)
);
