package com.absentia.app.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\u00122\u0006\u0010\u0010\u001a\u00020\u0003H\'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\u00122\u0006\u0010\u0019\u001a\u00020\u0003H\'J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010!\u00a8\u0006\""}, d2 = {"Lcom/absentia/app/repository/AttendanceDao;", "", "alreadyMarked", "", "sessionId", "studentId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSessionByToken", "Lcom/absentia/app/models/AttendanceSession;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPresentCount", "classId", "getRecordsBySession", "Landroidx/lifecycle/LiveData;", "", "Lcom/absentia/app/models/AttendanceRecord;", "getRecordsByStudent", "getSessionById", "getSessionsByClass", "getSessionsByTeacher", "teacherId", "getTotalSessions", "insertRecord", "", "record", "(Lcom/absentia/app/models/AttendanceRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSession", "session", "(Lcom/absentia/app/models/AttendanceSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AttendanceDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.AttendanceSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "UPDATE attendance_sessions SET isActive = 0 WHERE id = :sessionId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object endSession(int sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_sessions WHERE id = :sessionId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessionById(int sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.AttendanceSession> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_sessions WHERE qrToken = :token AND isActive = 1 LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActiveSessionByToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.AttendanceSession> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_sessions WHERE teacherId = :teacherId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceSession>> getSessionsByTeacher(int teacherId);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_sessions WHERE classId = :classId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceSession>> getSessionsByClass(int classId);
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertRecord(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.AttendanceRecord record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE sessionId = :sessionId AND studentId = :studentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object alreadyMarked(int sessionId, int studentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_records WHERE studentId = :studentId ORDER BY markedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceRecord>> getRecordsByStudent(int studentId);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_records WHERE sessionId = :sessionId ORDER BY studentName ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceRecord>> getRecordsBySession(int sessionId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE studentId = :studentId AND classId = :classId AND status = \'PRESENT\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPresentCount(int studentId, int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(DISTINCT sessionId) FROM attendance_records WHERE classId = :classId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalSessions(int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}