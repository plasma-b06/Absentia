package com.absentia.app.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/absentia/app/repository/AbsentiaDatabase;", "Landroidx/room/RoomDatabase;", "()V", "attendanceDao", "Lcom/absentia/app/repository/AttendanceDao;", "classDao", "Lcom/absentia/app/repository/ClassDao;", "userDao", "Lcom/absentia/app/repository/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.absentia.app.models.User.class, com.absentia.app.models.ClassRoom.class, com.absentia.app.models.ClassEnrollment.class, com.absentia.app.models.AttendanceSession.class, com.absentia.app.models.AttendanceRecord.class}, version = 1, exportSchema = false)
public abstract class AbsentiaDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.absentia.app.repository.AbsentiaDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.absentia.app.repository.AbsentiaDatabase.Companion Companion = null;
    
    public AbsentiaDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.absentia.app.repository.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.absentia.app.repository.ClassDao classDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.absentia.app.repository.AttendanceDao attendanceDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/absentia/app/repository/AbsentiaDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/absentia/app/repository/AbsentiaDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.absentia.app.repository.AbsentiaDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}