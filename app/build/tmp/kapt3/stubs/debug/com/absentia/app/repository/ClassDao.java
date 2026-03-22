package com.absentia.app.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u000eH\'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u000eH\'J\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/absentia/app/repository/ClassDao;", "", "deleteClass", "", "classRoom", "Lcom/absentia/app/models/ClassRoom;", "(Lcom/absentia/app/models/ClassRoom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollStudent", "", "enrollment", "Lcom/absentia/app/models/ClassEnrollment;", "(Lcom/absentia/app/models/ClassEnrollment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassById", "classId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassByJoinCode", "code", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassesByTeacher", "Landroidx/lifecycle/LiveData;", "", "teacherId", "getEnrolledClasses", "studentId", "getStudentCount", "insertClass", "isEnrolled", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateClass", "app_debug"})
@androidx.room.Dao()
public abstract interface ClassDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM classes WHERE teacherId = :teacherId ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.ClassRoom>> getClassesByTeacher(int teacherId);
    
    @androidx.room.Query(value = "SELECT * FROM classes WHERE id = :classId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getClassById(int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.ClassRoom> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM classes WHERE joinCode = :code LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getClassByJoinCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.absentia.app.models.ClassRoom> $completion);
    
    @androidx.room.Query(value = "\n        SELECT c.* FROM classes c \n        INNER JOIN class_enrollments e ON c.id = e.classId \n        WHERE e.studentId = :studentId\n        ORDER BY c.name ASC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.ClassRoom>> getEnrolledClasses(int studentId);
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object enrollStudent(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassEnrollment enrollment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM class_enrollments WHERE studentId = :studentId AND classId = :classId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isEnrolled(int studentId, int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM class_enrollments WHERE classId = :classId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStudentCount(int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}