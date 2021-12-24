package nl.linsoft.klonkr.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lnl/linsoft/klonkr/data/UserViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "readAllData", "Landroidx/lifecycle/LiveData;", "", "Lnl/linsoft/klonkr/data/User;", "getReadAllData", "()Landroidx/lifecycle/LiveData;", "repository", "Lnl/linsoft/klonkr/data/UserRepository;", "addUser", "", "user", "deleteAllUsers", "deleteUser", "id", "", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<nl.linsoft.klonkr.data.User>> readAllData = null;
    private final nl.linsoft.klonkr.data.UserRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<nl.linsoft.klonkr.data.User>> getReadAllData() {
        return null;
    }
    
    public final void addUser(@org.jetbrains.annotations.NotNull()
    nl.linsoft.klonkr.data.User user) {
    }
    
    public final void deleteUser(int id) {
    }
    
    public final void deleteAllUsers() {
    }
    
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}