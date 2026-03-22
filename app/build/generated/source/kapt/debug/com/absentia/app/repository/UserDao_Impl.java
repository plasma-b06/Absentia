package com.absentia.app.repository;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.absentia.app.models.User;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePassword;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`id`,`firstName`,`lastName`,`email`,`password`,`role`,`branch`,`phoneNumber`,`prnNumber`,`gender`,`division`,`year`,`rollNo`,`profileImagePath`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getFirstName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFirstName());
        }
        if (entity.getLastName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLastName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEmail());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPassword());
        }
        if (entity.getRole() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getRole());
        }
        if (entity.getBranch() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBranch());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPhoneNumber());
        }
        if (entity.getPrnNumber() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPrnNumber());
        }
        if (entity.getGender() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getGender());
        }
        if (entity.getDivision() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDivision());
        }
        if (entity.getYear() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getYear());
        }
        if (entity.getRollNo() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getRollNo());
        }
        if (entity.getProfileImagePath() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getProfileImagePath());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `users` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`firstName` = ?,`lastName` = ?,`email` = ?,`password` = ?,`role` = ?,`branch` = ?,`phoneNumber` = ?,`prnNumber` = ?,`gender` = ?,`division` = ?,`year` = ?,`rollNo` = ?,`profileImagePath` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getFirstName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFirstName());
        }
        if (entity.getLastName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLastName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEmail());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPassword());
        }
        if (entity.getRole() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getRole());
        }
        if (entity.getBranch() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBranch());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPhoneNumber());
        }
        if (entity.getPrnNumber() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPrnNumber());
        }
        if (entity.getGender() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getGender());
        }
        if (entity.getDivision() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDivision());
        }
        if (entity.getYear() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getYear());
        }
        if (entity.getRollNo() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getRollNo());
        }
        if (entity.getProfileImagePath() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getProfileImagePath());
        }
        statement.bindLong(15, entity.getId());
      }
    };
    this.__preparedStmtOfUpdatePassword = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET password = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final User user, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfUser.insertAndReturnId(user);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePassword(final int userId, final String newPassword,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePassword.acquire();
        int _argIndex = 1;
        if (newPassword == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, newPassword);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, userId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdatePassword.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object login(final String email, final String password,
      final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE email = ? AND password = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPrnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "prnNumber");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRollNo = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNo");
          final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
          final User _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPrnNumber;
            if (_cursor.isNull(_cursorIndexOfPrnNumber)) {
              _tmpPrnNumber = null;
            } else {
              _tmpPrnNumber = _cursor.getString(_cursorIndexOfPrnNumber);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRollNo;
            if (_cursor.isNull(_cursorIndexOfRollNo)) {
              _tmpRollNo = null;
            } else {
              _tmpRollNo = _cursor.getString(_cursorIndexOfRollNo);
            }
            final String _tmpProfileImagePath;
            if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
              _tmpProfileImagePath = null;
            } else {
              _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
            }
            _result = new User(_tmpId,_tmpFirstName,_tmpLastName,_tmpEmail,_tmpPassword,_tmpRole,_tmpBranch,_tmpPhoneNumber,_tmpPrnNumber,_tmpGender,_tmpDivision,_tmpYear,_tmpRollNo,_tmpProfileImagePath);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserByEmail(final String email, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE email = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPrnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "prnNumber");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRollNo = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNo");
          final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
          final User _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPrnNumber;
            if (_cursor.isNull(_cursorIndexOfPrnNumber)) {
              _tmpPrnNumber = null;
            } else {
              _tmpPrnNumber = _cursor.getString(_cursorIndexOfPrnNumber);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRollNo;
            if (_cursor.isNull(_cursorIndexOfRollNo)) {
              _tmpRollNo = null;
            } else {
              _tmpRollNo = _cursor.getString(_cursorIndexOfRollNo);
            }
            final String _tmpProfileImagePath;
            if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
              _tmpProfileImagePath = null;
            } else {
              _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
            }
            _result = new User(_tmpId,_tmpFirstName,_tmpLastName,_tmpEmail,_tmpPassword,_tmpRole,_tmpBranch,_tmpPhoneNumber,_tmpPrnNumber,_tmpGender,_tmpDivision,_tmpYear,_tmpRollNo,_tmpProfileImagePath);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserById(final int id, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPrnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "prnNumber");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRollNo = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNo");
          final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
          final User _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPrnNumber;
            if (_cursor.isNull(_cursorIndexOfPrnNumber)) {
              _tmpPrnNumber = null;
            } else {
              _tmpPrnNumber = _cursor.getString(_cursorIndexOfPrnNumber);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRollNo;
            if (_cursor.isNull(_cursorIndexOfRollNo)) {
              _tmpRollNo = null;
            } else {
              _tmpRollNo = _cursor.getString(_cursorIndexOfRollNo);
            }
            final String _tmpProfileImagePath;
            if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
              _tmpProfileImagePath = null;
            } else {
              _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
            }
            _result = new User(_tmpId,_tmpFirstName,_tmpLastName,_tmpEmail,_tmpPassword,_tmpRole,_tmpBranch,_tmpPhoneNumber,_tmpPrnNumber,_tmpGender,_tmpDivision,_tmpYear,_tmpRollNo,_tmpProfileImagePath);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<User>> getAllStudents() {
    final String _sql = "SELECT * FROM users WHERE role = 'STUDENT'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"users"}, false, new Callable<List<User>>() {
      @Override
      @Nullable
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPrnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "prnNumber");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRollNo = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNo");
          final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPrnNumber;
            if (_cursor.isNull(_cursorIndexOfPrnNumber)) {
              _tmpPrnNumber = null;
            } else {
              _tmpPrnNumber = _cursor.getString(_cursorIndexOfPrnNumber);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRollNo;
            if (_cursor.isNull(_cursorIndexOfRollNo)) {
              _tmpRollNo = null;
            } else {
              _tmpRollNo = _cursor.getString(_cursorIndexOfRollNo);
            }
            final String _tmpProfileImagePath;
            if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
              _tmpProfileImagePath = null;
            } else {
              _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
            }
            _item = new User(_tmpId,_tmpFirstName,_tmpLastName,_tmpEmail,_tmpPassword,_tmpRole,_tmpBranch,_tmpPhoneNumber,_tmpPrnNumber,_tmpGender,_tmpDivision,_tmpYear,_tmpRollNo,_tmpProfileImagePath);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<User>> getAllTeachers() {
    final String _sql = "SELECT * FROM users WHERE role = 'TEACHER'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"users"}, false, new Callable<List<User>>() {
      @Override
      @Nullable
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPrnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "prnNumber");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRollNo = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNo");
          final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpRole;
            if (_cursor.isNull(_cursorIndexOfRole)) {
              _tmpRole = null;
            } else {
              _tmpRole = _cursor.getString(_cursorIndexOfRole);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPrnNumber;
            if (_cursor.isNull(_cursorIndexOfPrnNumber)) {
              _tmpPrnNumber = null;
            } else {
              _tmpPrnNumber = _cursor.getString(_cursorIndexOfPrnNumber);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRollNo;
            if (_cursor.isNull(_cursorIndexOfRollNo)) {
              _tmpRollNo = null;
            } else {
              _tmpRollNo = _cursor.getString(_cursorIndexOfRollNo);
            }
            final String _tmpProfileImagePath;
            if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
              _tmpProfileImagePath = null;
            } else {
              _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
            }
            _item = new User(_tmpId,_tmpFirstName,_tmpLastName,_tmpEmail,_tmpPassword,_tmpRole,_tmpBranch,_tmpPhoneNumber,_tmpPrnNumber,_tmpGender,_tmpDivision,_tmpYear,_tmpRollNo,_tmpProfileImagePath);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object emailExists(final String email, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM users WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
