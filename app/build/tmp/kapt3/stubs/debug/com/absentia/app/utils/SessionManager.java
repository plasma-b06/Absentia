package com.absentia.app.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/absentia/app/utils/SessionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "getUserEmail", "", "getUserId", "", "getUserName", "getUserRole", "isLoggedIn", "", "logout", "", "saveSession", "userId", "role", "name", "email", "Companion", "app_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USER_ROLE = "user_role";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USER_EMAIL = "user_email";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_IS_LOGGED_IN = "is_logged_in";
    @org.jetbrains.annotations.NotNull()
    public static final com.absentia.app.utils.SessionManager.Companion Companion = null;
    
    public SessionManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void saveSession(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final int getUserId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserEmail() {
        return null;
    }
    
    public final void logout() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/absentia/app/utils/SessionManager$Companion;", "", "()V", "KEY_IS_LOGGED_IN", "", "KEY_USER_EMAIL", "KEY_USER_ID", "KEY_USER_NAME", "KEY_USER_ROLE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}