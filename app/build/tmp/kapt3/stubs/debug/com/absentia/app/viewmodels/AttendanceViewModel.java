package com.absentia.app.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u00102\u0006\u0010\u001d\u001a\u00020\u0016J\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u00102\u0006\u0010 \u001a\u00020\u0016J\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060#0\u00102\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\'\u001a\u00020\u0014J\u0016\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006,"}, d2 = {"Lcom/absentia/app/viewmodels/AttendanceViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_activeSession", "Lcom/absentia/app/models/AttendanceSession;", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/absentia/app/viewmodels/AttendanceState;", "activeSession", "getActiveSession", "()Lcom/absentia/app/models/AttendanceSession;", "repo", "Lcom/absentia/app/repository/AbsentiaRepository;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "createSession", "", "classId", "", "className", "", "teacherId", "timeSlot", "subject", "endSession", "sessionId", "getAttendancePercentage", "", "studentId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionAttendance", "", "Lcom/absentia/app/models/AttendanceRecord;", "getStudentAttendance", "getTeacherSessions", "resetState", "scanAndMarkAttendance", "qrContent", "student", "Lcom/absentia/app/models/User;", "app_debug"})
public final class AttendanceViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.absentia.app.repository.AbsentiaRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.absentia.app.viewmodels.AttendanceState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.absentia.app.viewmodels.AttendanceState> state = null;
    @org.jetbrains.annotations.Nullable()
    private com.absentia.app.models.AttendanceSession _activeSession;
    
    public AttendanceViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.absentia.app.viewmodels.AttendanceState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.absentia.app.models.AttendanceSession getActiveSession() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.absentia.app.models.AttendanceSession>> getTeacherSessions(int teacherId) {
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
    
    public final void createSession(int classId, @org.jetbrains.annotations.NotNull()
    java.lang.String className, int teacherId, @org.jetbrains.annotations.NotNull()
    java.lang.String timeSlot, @org.jetbrains.annotations.NotNull()
    java.lang.String subject) {
    }
    
    public final void endSession(int sessionId) {
    }
    
    public final void scanAndMarkAttendance(@org.jetbrains.annotations.NotNull()
    java.lang.String qrContent, @org.jetbrains.annotations.NotNull()
    com.absentia.app.models.User student) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAttendancePercentage(int studentId, int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Float> $completion) {
        return null;
    }
    
    public final void resetState() {
    }
}