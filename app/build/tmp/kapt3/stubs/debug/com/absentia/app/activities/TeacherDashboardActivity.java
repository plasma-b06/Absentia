package com.absentia.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/absentia/app/activities/TeacherDashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/absentia/app/databinding/ActivityTeacherDashboardBinding;", "classAdapter", "Lcom/absentia/app/adapters/ClassAdapter;", "classViewModel", "Lcom/absentia/app/viewmodels/ClassViewModel;", "getClassViewModel", "()Lcom/absentia/app/viewmodels/ClassViewModel;", "classViewModel$delegate", "Lkotlin/Lazy;", "session", "Lcom/absentia/app/utils/SessionManager;", "confirmDeleteClass", "", "classRoom", "Lcom/absentia/app/models/ClassRoom;", "confirmLogout", "loadClasses", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupFab", "setupObserver", "setupRecyclerView", "setupToolbar", "showCreateClassDialog", "showMenu", "app_debug"})
public final class TeacherDashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.absentia.app.databinding.ActivityTeacherDashboardBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy classViewModel$delegate = null;
    private com.absentia.app.utils.SessionManager session;
    private com.absentia.app.adapters.ClassAdapter classAdapter;
    
    public TeacherDashboardActivity() {
        super();
    }
    
    private final com.absentia.app.viewmodels.ClassViewModel getClassViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void loadClasses() {
    }
    
    private final void setupFab() {
    }
    
    private final void showCreateClassDialog() {
    }
    
    private final void confirmDeleteClass(com.absentia.app.models.ClassRoom classRoom) {
    }
    
    private final void setupObserver() {
    }
    
    private final void showMenu() {
    }
    
    private final void confirmLogout() {
    }
}