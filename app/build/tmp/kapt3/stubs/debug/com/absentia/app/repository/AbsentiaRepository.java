package com.absentia.app.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\'\u001a\u0004\u0018\u00010\u00162\u0006\u0010(\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\u0018\u0010)\u001a\u0004\u0018\u00010\u00162\u0006\u0010*\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0-0,2\u0006\u0010&\u001a\u00020\u0010J\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0-0,2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u0018\u00101\u001a\u0004\u0018\u00010\u001a2\u0006\u00102\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\u001a\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0-0,2\u0006\u0010\u0011\u001a\u00020\u0010J\u001a\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160-0,2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u00105\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160-0,2\u0006\u00107\u001a\u00020\u0010J\u001a\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0-0,2\u0006\u00107\u001a\u00020\u0010J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010*\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u001e\u0010;\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020>H\u0086@\u00a2\u0006\u0002\u0010?J \u0010@\u001a\u0004\u0018\u00010:2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020/H\u0086@\u00a2\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020:H\u0086@\u00a2\u0006\u0002\u0010HJ\u001e\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020:H\u0086@\u00a2\u0006\u0002\u0010HR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/absentia/app/repository/AbsentiaRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attendanceDao", "Lcom/absentia/app/repository/AttendanceDao;", "classDao", "Lcom/absentia/app/repository/ClassDao;", "db", "Lcom/absentia/app/repository/AbsentiaDatabase;", "userDao", "Lcom/absentia/app/repository/UserDao;", "alreadyMarked", "", "sessionId", "", "studentId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createClass", "", "classRoom", "Lcom/absentia/app/models/ClassRoom;", "(Lcom/absentia/app/models/ClassRoom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "session", "Lcom/absentia/app/models/AttendanceSession;", "(Lcom/absentia/app/models/AttendanceSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteClass", "", "emailExists", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendancePercentage", "", "classId", "getClassByCode", "code", "getClassById", "id", "getClassSessions", "Landroidx/lifecycle/LiveData;", "", "getSessionAttendance", "Lcom/absentia/app/models/AttendanceRecord;", "getSessionById", "getSessionByToken", "token", "getStudentAttendance", "getStudentClasses", "getStudentCount", "getTeacherClasses", "teacherId", "getTeacherSessions", "getUserById", "Lcom/absentia/app/models/User;", "isEnrolled", "joinClass", "enrollment", "Lcom/absentia/app/models/ClassEnrollment;", "(Lcom/absentia/app/models/ClassEnrollment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAttendance", "record", "(Lcom/absentia/app/models/AttendanceRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "user", "(Lcom/absentia/app/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassword", "userId", "newPassword", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "app_debug"})
public final class AbsentiaRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.absentia.app.repository.AbsentiaDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.absentia.app.repository.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.absentia.app.repository.ClassDao classDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.absentia.app.repository.AttendanceDao attendanceDao = null;
    
    public AbsentiaRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object registerUser(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object emailExists(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePassword(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String newPassword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.ClassRoom>> getTeacherClasses(int teacherId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.ClassRoom>> getStudentClasses(int studentId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getClassByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.ClassRoom> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getClassById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.ClassRoom> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object joinClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassEnrollment enrollment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isEnrolled(int studentId, int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStudentCount(int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createSession(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.AttendanceSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object endSession(int sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionByToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.AttendanceSession> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.AttendanceSession> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceSession>> getTeacherSessions(int teacherId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceSession>> getClassSessions(int classId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAttendance(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.AttendanceRecord record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object alreadyMarked(int sessionId, int studentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceRecord>> getStudentAttendance(int studentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceRecord>> getSessionAttendance(int sessionId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAttendancePercentage(int studentId, int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Float> $completion) {
        return null;
    }
}