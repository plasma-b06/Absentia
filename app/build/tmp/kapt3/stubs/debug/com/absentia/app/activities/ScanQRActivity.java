package com.absentia.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/absentia/app/activities/ScanQRActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/absentia/app/databinding/ActivityScanQrBinding;", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "repo", "Lcom/absentia/app/repository/AbsentiaRepository;", "scanning", "", "session", "Lcom/absentia/app/utils/SessionManager;", "viewModel", "Lcom/absentia/app/viewmodels/AttendanceViewModel;", "getViewModel", "()Lcom/absentia/app/viewmodels/AttendanceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "markAttendance", "", "qrContent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "setupObserver", "startScanning", "app_debug"})
public final class ScanQRActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.absentia.app.databinding.ActivityScanQrBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.absentia.app.utils.SessionManager session;
    private boolean scanning = true;
    private com.absentia.app.repository.AbsentiaRepository repo;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> cameraPermissionLauncher = null;
    
    public ScanQRActivity() {
        super();
    }
    
    private final com.absentia.app.viewmodels.AttendanceViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void startScanning() {
    }
    
    private final void markAttendance(java.lang.String qrContent) {
    }
    
    private final void setupObserver() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
}