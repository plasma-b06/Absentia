package com.absentia.app.repository;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AbsentiaDatabase_Impl extends AbsentiaDatabase {
  private volatile UserDao _userDao;

  private volatile ClassDao _classDao;

  private volatile AttendanceDao _attendanceDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `firstName` TEXT NOT NULL, `lastName` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `role` TEXT NOT NULL, `branch` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `prnNumber` TEXT NOT NULL, `gender` TEXT NOT NULL, `division` TEXT NOT NULL, `year` TEXT NOT NULL, `rollNo` TEXT NOT NULL, `profileImagePath` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `classes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `division` TEXT NOT NULL, `teacherId` INTEGER NOT NULL, `teacherName` TEXT NOT NULL, `joinCode` TEXT NOT NULL, `branch` TEXT NOT NULL, `year` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `class_enrollments` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `studentId` INTEGER NOT NULL, `classId` INTEGER NOT NULL, `enrolledAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `attendance_sessions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `classId` INTEGER NOT NULL, `className` TEXT NOT NULL, `teacherId` INTEGER NOT NULL, `date` TEXT NOT NULL, `timeSlot` TEXT NOT NULL, `subject` TEXT NOT NULL, `qrToken` TEXT NOT NULL, `isActive` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `attendance_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` INTEGER NOT NULL, `studentId` INTEGER NOT NULL, `studentName` TEXT NOT NULL, `classId` INTEGER NOT NULL, `subject` TEXT NOT NULL, `date` TEXT NOT NULL, `timeSlot` TEXT NOT NULL, `markedAt` INTEGER NOT NULL, `status` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7c545550eef7f7f1ac8041f63cee53cd')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `classes`");
        db.execSQL("DROP TABLE IF EXISTS `class_enrollments`");
        db.execSQL("DROP TABLE IF EXISTS `attendance_sessions`");
        db.execSQL("DROP TABLE IF EXISTS `attendance_records`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(14);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("firstName", new TableInfo.Column("firstName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("lastName", new TableInfo.Column("lastName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("branch", new TableInfo.Column("branch", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("prnNumber", new TableInfo.Column("prnNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("division", new TableInfo.Column("division", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("year", new TableInfo.Column("year", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("rollNo", new TableInfo.Column("rollNo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("profileImagePath", new TableInfo.Column("profileImagePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.absentia.app.models.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsClasses = new HashMap<String, TableInfo.Column>(8);
        _columnsClasses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("division", new TableInfo.Column("division", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherId", new TableInfo.Column("teacherId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherName", new TableInfo.Column("teacherName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("joinCode", new TableInfo.Column("joinCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("branch", new TableInfo.Column("branch", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("year", new TableInfo.Column("year", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClasses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClasses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClasses = new TableInfo("classes", _columnsClasses, _foreignKeysClasses, _indicesClasses);
        final TableInfo _existingClasses = TableInfo.read(db, "classes");
        if (!_infoClasses.equals(_existingClasses)) {
          return new RoomOpenHelper.ValidationResult(false, "classes(com.absentia.app.models.ClassRoom).\n"
                  + " Expected:\n" + _infoClasses + "\n"
                  + " Found:\n" + _existingClasses);
        }
        final HashMap<String, TableInfo.Column> _columnsClassEnrollments = new HashMap<String, TableInfo.Column>(4);
        _columnsClassEnrollments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClassEnrollments.put("studentId", new TableInfo.Column("studentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClassEnrollments.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClassEnrollments.put("enrolledAt", new TableInfo.Column("enrolledAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClassEnrollments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClassEnrollments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClassEnrollments = new TableInfo("class_enrollments", _columnsClassEnrollments, _foreignKeysClassEnrollments, _indicesClassEnrollments);
        final TableInfo _existingClassEnrollments = TableInfo.read(db, "class_enrollments");
        if (!_infoClassEnrollments.equals(_existingClassEnrollments)) {
          return new RoomOpenHelper.ValidationResult(false, "class_enrollments(com.absentia.app.models.ClassEnrollment).\n"
                  + " Expected:\n" + _infoClassEnrollments + "\n"
                  + " Found:\n" + _existingClassEnrollments);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendanceSessions = new HashMap<String, TableInfo.Column>(10);
        _columnsAttendanceSessions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("className", new TableInfo.Column("className", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("teacherId", new TableInfo.Column("teacherId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("timeSlot", new TableInfo.Column("timeSlot", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("subject", new TableInfo.Column("subject", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("qrToken", new TableInfo.Column("qrToken", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceSessions.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendanceSessions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendanceSessions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendanceSessions = new TableInfo("attendance_sessions", _columnsAttendanceSessions, _foreignKeysAttendanceSessions, _indicesAttendanceSessions);
        final TableInfo _existingAttendanceSessions = TableInfo.read(db, "attendance_sessions");
        if (!_infoAttendanceSessions.equals(_existingAttendanceSessions)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance_sessions(com.absentia.app.models.AttendanceSession).\n"
                  + " Expected:\n" + _infoAttendanceSessions + "\n"
                  + " Found:\n" + _existingAttendanceSessions);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendanceRecords = new HashMap<String, TableInfo.Column>(10);
        _columnsAttendanceRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("sessionId", new TableInfo.Column("sessionId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("studentId", new TableInfo.Column("studentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("studentName", new TableInfo.Column("studentName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("subject", new TableInfo.Column("subject", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("timeSlot", new TableInfo.Column("timeSlot", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("markedAt", new TableInfo.Column("markedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendanceRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendanceRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendanceRecords = new TableInfo("attendance_records", _columnsAttendanceRecords, _foreignKeysAttendanceRecords, _indicesAttendanceRecords);
        final TableInfo _existingAttendanceRecords = TableInfo.read(db, "attendance_records");
        if (!_infoAttendanceRecords.equals(_existingAttendanceRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance_records(com.absentia.app.models.AttendanceRecord).\n"
                  + " Expected:\n" + _infoAttendanceRecords + "\n"
                  + " Found:\n" + _existingAttendanceRecords);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7c545550eef7f7f1ac8041f63cee53cd", "066ba5ad9ba752aef1cfba89092dcfbb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","classes","class_enrollments","attendance_sessions","attendance_records");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `classes`");
      _db.execSQL("DELETE FROM `class_enrollments`");
      _db.execSQL("DELETE FROM `attendance_sessions`");
      _db.execSQL("DELETE FROM `attendance_records`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ClassDao.class, ClassDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AttendanceDao.class, AttendanceDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ClassDao classDao() {
    if (_classDao != null) {
      return _classDao;
    } else {
      synchronized(this) {
        if(_classDao == null) {
          _classDao = new ClassDao_Impl(this);
        }
        return _classDao;
      }
    }
  }

  @Override
  public AttendanceDao attendanceDao() {
    if (_attendanceDao != null) {
      return _attendanceDao;
    } else {
      synchronized(this) {
        if(_attendanceDao == null) {
          _attendanceDao = new AttendanceDao_Impl(this);
        }
        return _attendanceDao;
      }
    }
  }
}
