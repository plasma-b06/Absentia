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
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.absentia.app.models.ClassEnrollment;
import com.absentia.app.models.ClassRoom;
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
public final class ClassDao_Impl implements ClassDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ClassRoom> __insertionAdapterOfClassRoom;

  private final EntityInsertionAdapter<ClassEnrollment> __insertionAdapterOfClassEnrollment;

  private final EntityDeletionOrUpdateAdapter<ClassRoom> __deletionAdapterOfClassRoom;

  private final EntityDeletionOrUpdateAdapter<ClassRoom> __updateAdapterOfClassRoom;

  public ClassDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClassRoom = new EntityInsertionAdapter<ClassRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `classes` (`id`,`name`,`division`,`teacherId`,`teacherName`,`joinCode`,`branch`,`year`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassRoom entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDivision() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDivision());
        }
        statement.bindLong(4, entity.getTeacherId());
        if (entity.getTeacherName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTeacherName());
        }
        if (entity.getJoinCode() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getJoinCode());
        }
        if (entity.getBranch() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBranch());
        }
        if (entity.getYear() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getYear());
        }
      }
    };
    this.__insertionAdapterOfClassEnrollment = new EntityInsertionAdapter<ClassEnrollment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `class_enrollments` (`id`,`studentId`,`classId`,`enrolledAt`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassEnrollment entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getStudentId());
        statement.bindLong(3, entity.getClassId());
        statement.bindLong(4, entity.getEnrolledAt());
      }
    };
    this.__deletionAdapterOfClassRoom = new EntityDeletionOrUpdateAdapter<ClassRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `classes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassRoom entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfClassRoom = new EntityDeletionOrUpdateAdapter<ClassRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `classes` SET `id` = ?,`name` = ?,`division` = ?,`teacherId` = ?,`teacherName` = ?,`joinCode` = ?,`branch` = ?,`year` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassRoom entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDivision() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDivision());
        }
        statement.bindLong(4, entity.getTeacherId());
        if (entity.getTeacherName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTeacherName());
        }
        if (entity.getJoinCode() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getJoinCode());
        }
        if (entity.getBranch() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBranch());
        }
        if (entity.getYear() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getYear());
        }
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object insertClass(final ClassRoom classRoom,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfClassRoom.insertAndReturnId(classRoom);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object enrollStudent(final ClassEnrollment enrollment,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfClassEnrollment.insertAndReturnId(enrollment);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteClass(final ClassRoom classRoom,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfClassRoom.handle(classRoom);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateClass(final ClassRoom classRoom,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfClassRoom.handle(classRoom);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<ClassRoom>> getClassesByTeacher(final int teacherId) {
    final String _sql = "SELECT * FROM classes WHERE teacherId = ? ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, teacherId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"classes"}, false, new Callable<List<ClassRoom>>() {
      @Override
      @Nullable
      public List<ClassRoom> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfJoinCode = CursorUtil.getColumnIndexOrThrow(_cursor, "joinCode");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final List<ClassRoom> _result = new ArrayList<ClassRoom>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ClassRoom _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpJoinCode;
            if (_cursor.isNull(_cursorIndexOfJoinCode)) {
              _tmpJoinCode = null;
            } else {
              _tmpJoinCode = _cursor.getString(_cursorIndexOfJoinCode);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            _item = new ClassRoom(_tmpId,_tmpName,_tmpDivision,_tmpTeacherId,_tmpTeacherName,_tmpJoinCode,_tmpBranch,_tmpYear);
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
  public Object getClassById(final int classId, final Continuation<? super ClassRoom> $completion) {
    final String _sql = "SELECT * FROM classes WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ClassRoom>() {
      @Override
      @Nullable
      public ClassRoom call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfJoinCode = CursorUtil.getColumnIndexOrThrow(_cursor, "joinCode");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final ClassRoom _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpJoinCode;
            if (_cursor.isNull(_cursorIndexOfJoinCode)) {
              _tmpJoinCode = null;
            } else {
              _tmpJoinCode = _cursor.getString(_cursorIndexOfJoinCode);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            _result = new ClassRoom(_tmpId,_tmpName,_tmpDivision,_tmpTeacherId,_tmpTeacherName,_tmpJoinCode,_tmpBranch,_tmpYear);
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
  public Object getClassByJoinCode(final String code,
      final Continuation<? super ClassRoom> $completion) {
    final String _sql = "SELECT * FROM classes WHERE joinCode = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (code == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, code);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ClassRoom>() {
      @Override
      @Nullable
      public ClassRoom call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfJoinCode = CursorUtil.getColumnIndexOrThrow(_cursor, "joinCode");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final ClassRoom _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpJoinCode;
            if (_cursor.isNull(_cursorIndexOfJoinCode)) {
              _tmpJoinCode = null;
            } else {
              _tmpJoinCode = _cursor.getString(_cursorIndexOfJoinCode);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            _result = new ClassRoom(_tmpId,_tmpName,_tmpDivision,_tmpTeacherId,_tmpTeacherName,_tmpJoinCode,_tmpBranch,_tmpYear);
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
  public LiveData<List<ClassRoom>> getEnrolledClasses(final int studentId) {
    final String _sql = "\n"
            + "        SELECT c.* FROM classes c \n"
            + "        INNER JOIN class_enrollments e ON c.id = e.classId \n"
            + "        WHERE e.studentId = ?\n"
            + "        ORDER BY c.name ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, studentId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"classes",
        "class_enrollments"}, false, new Callable<List<ClassRoom>>() {
      @Override
      @Nullable
      public List<ClassRoom> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfJoinCode = CursorUtil.getColumnIndexOrThrow(_cursor, "joinCode");
          final int _cursorIndexOfBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "branch");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final List<ClassRoom> _result = new ArrayList<ClassRoom>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ClassRoom _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpJoinCode;
            if (_cursor.isNull(_cursorIndexOfJoinCode)) {
              _tmpJoinCode = null;
            } else {
              _tmpJoinCode = _cursor.getString(_cursorIndexOfJoinCode);
            }
            final String _tmpBranch;
            if (_cursor.isNull(_cursorIndexOfBranch)) {
              _tmpBranch = null;
            } else {
              _tmpBranch = _cursor.getString(_cursorIndexOfBranch);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            _item = new ClassRoom(_tmpId,_tmpName,_tmpDivision,_tmpTeacherId,_tmpTeacherName,_tmpJoinCode,_tmpBranch,_tmpYear);
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
  public Object isEnrolled(final int studentId, final int classId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM class_enrollments WHERE studentId = ? AND classId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, studentId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, classId);
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

  @Override
  public Object getStudentCount(final int classId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM class_enrollments WHERE classId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
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
