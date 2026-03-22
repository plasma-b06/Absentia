package com.absentia.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/absentia/app/activities/GenerateQRActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activeSessionId", "", "binding", "Lcom/absentia/app/databinding/ActivityGenerateQrBinding;", "classRoom", "Lcom/absentia/app/models/ClassRoom;", "session", "Lcom/absentia/app/utils/SessionManager;", "viewModel", "Lcom/absentia/app/viewmodels/AttendanceViewModel;", "getViewModel", "()Lcom/absentia/app/viewmodels/AttendanceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "confirmEndSession", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupObserver", "setupSpinners", "setupToolbar", "showQR", "bitmap", "Landroid/graphics/Bitmap;", "app_debug"})
public final class GenerateQRActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.absentia.app.databinding.ActivityGenerateQrBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.absentia.app.utils.SessionManager session;
    private com.absentia.app.models.ClassRoom classRoom;
    private int activeSessionId = -1;
    
    public GenerateQRActivity() {
        super();
    }
    
    private final com.absentia.app.viewmodels.AttendanceViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupSpinners() {
    }
    
    private final void setupObserver() {
    }
    
    private final void showQR(android.graphics.Bitmap bitmap) {
    }
    
    private final void confirmEndSession() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}