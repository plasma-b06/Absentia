package com.absentia.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/absentia/app/activities/ClassDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "attendanceViewModel", "Lcom/absentia/app/viewmodels/AttendanceViewModel;", "getAttendanceViewModel", "()Lcom/absentia/app/viewmodels/AttendanceViewModel;", "attendanceViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/absentia/app/databinding/ActivityClassDetailBinding;", "classRoom", "Lcom/absentia/app/models/ClassRoom;", "session", "Lcom/absentia/app/utils/SessionManager;", "sessionAdapter", "Lcom/absentia/app/adapters/SessionAdapter;", "loadSessions", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupInfo", "setupObserver", "setupRecyclerView", "setupToolbar", "app_debug"})
public final class ClassDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.absentia.app.databinding.ActivityClassDetailBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy attendanceViewModel$delegate = null;
    private com.absentia.app.utils.SessionManager session;
    private com.absentia.app.models.ClassRoom classRoom;
    private com.absentia.app.adapters.SessionAdapter sessionAdapter;
    
    public ClassDetailActivity() {
        super();
    }
    
    private final com.absentia.app.viewmodels.AttendanceViewModel getAttendanceViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupInfo() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void loadSessions() {
    }
    
    private final void setupObserver() {
    }
}