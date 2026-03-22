package com.absentia.app.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c0\t2\u0006\u0010\u001d\u001a\u00020\u0014J\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c0\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/absentia/app/viewmodels/ClassViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_classState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/absentia/app/viewmodels/ClassState;", "classState", "Landroidx/lifecycle/LiveData;", "getClassState", "()Landroidx/lifecycle/LiveData;", "repo", "Lcom/absentia/app/repository/AbsentiaRepository;", "createClass", "", "name", "", "division", "teacherId", "", "teacherName", "branch", "year", "deleteClass", "classRoom", "Lcom/absentia/app/models/ClassRoom;", "getStudentClasses", "", "studentId", "getTeacherClasses", "joinClass", "code", "resetState", "app_debug"})
public final class ClassViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.absentia.app.repository.AbsentiaRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.absentia.app.viewmodels.ClassState> _classState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.absentia.app.viewmodels.ClassState> classState = null;
    
    public ClassViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.absentia.app.viewmodels.ClassState> getClassState() {
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
    
    public final void createClass(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String division, int teacherId, @org.jetbrains.annotations.NotNull()
    java.lang.String teacherName, @org.jetbrains.annotations.NotNull()
    java.lang.String branch, @org.jetbrains.annotations.NotNull()
    java.lang.String year) {
    }
    
    public final void joinClass(@org.jetbrains.annotations.NotNull()
    java.lang.String code, int studentId) {
    }
    
    public final void deleteClass(@org.jetbrains.annotations.NotNull()
    com.absentia.app.models.ClassRoom classRoom) {
    }
    
    public final void resetState() {
    }
}