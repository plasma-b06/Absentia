package com.absentia.app.repository;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.absentia.app.models.AttendanceRecord;
import com.absentia.app.models.AttendanceSession;
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
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AttendanceSession> __insertionAdapterOfAttendanceSession;

  private final EntityInsertionAdapter<AttendanceRecord> __insertionAdapterOfAttendanceRecord;

  private final SharedSQLiteStatement __preparedStmtOfEndSession;

  public AttendanceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendanceSession = new EntityInsertionAdapter<AttendanceSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `attendance_sessions` (`id`,`classId`,`className`,`teacherId`,`date`,`timeSlot`,`subject`,`qrToken`,`isActive`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AttendanceSession entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getClassId());
        if (entity.getClassName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getClassName());
        }
        statement.bindLong(4, entity.getTeacherId());
        if (entity.getDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDate());
        }
        if (entity.getTimeSlot() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getTimeSlot());
        }
        if (entity.getSubject() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSubject());
        }
        if (entity.getQrToken() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getQrToken());
        }
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__insertionAdapterOfAttendanceRecord = new EntityInsertionAdapter<AttendanceRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `attendance_records` (`id`,`sessionId`,`studentId`,`studentName`,`classId`,`subject`,`date`,`timeSlot`,`markedAt`,`status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AttendanceRecord entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSessionId());
        statement.bindLong(3, entity.getStudentId());
        if (entity.getStudentName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStudentName());
        }
        statement.bindLong(5, entity.getClassId());
        if (entity.getSubject() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSubject());
        }
        if (entity.getDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDate());
        }
        if (entity.getTimeSlot() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTimeSlot());
        }
        statement.bindLong(9, entity.getMarkedAt());
        if (entity.getStatus() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getStatus());
        }
      }
    };
    this.__preparedStmtOfEndSession = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE attendance_sessions SET isActive = 0 WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertSession(final AttendanceSession session,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAttendanceSession.insertAndReturnId(session);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertRecord(final AttendanceRecord record,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAttendanceRecord.insertAndReturnId(record);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object endSession(final int sessionId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfEndSession.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, sessionId);
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
          __preparedStmtOfEndSession.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getSessionById(final int sessionId,
      final Continuation<? super AttendanceSession> $completion) {
    final String _sql = "SELECT * FROM attendance_sessions WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sessionId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AttendanceSession>() {
      @Override
      @Nullable
      public AttendanceSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfQrToken = CursorUtil.getColumnIndexOrThrow(_cursor, "qrToken");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final AttendanceSession _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpClassId;
            _tmpClassId = _cursor.getInt(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final String _tmpQrToken;
            if (_cursor.isNull(_cursorIndexOfQrToken)) {
              _tmpQrToken = null;
            } else {
              _tmpQrToken = _cursor.getString(_cursorIndexOfQrToken);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new AttendanceSession(_tmpId,_tmpClassId,_tmpClassName,_tmpTeacherId,_tmpDate,_tmpTimeSlot,_tmpSubject,_tmpQrToken,_tmpIsActive,_tmpCreatedAt);
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
  public Object getActiveSessionByToken(final String token,
      final Continuation<? super AttendanceSession> $completion) {
    final String _sql = "SELECT * FROM attendance_sessions WHERE qrToken = ? AND isActive = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (token == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, token);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AttendanceSession>() {
      @Override
      @Nullable
      public AttendanceSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfQrToken = CursorUtil.getColumnIndexOrThrow(_cursor, "qrToken");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final AttendanceSession _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpClassId;
            _tmpClassId = _cursor.getInt(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final String _tmpQrToken;
            if (_cursor.isNull(_cursorIndexOfQrToken)) {
              _tmpQrToken = null;
            } else {
              _tmpQrToken = _cursor.getString(_cursorIndexOfQrToken);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new AttendanceSession(_tmpId,_tmpClassId,_tmpClassName,_tmpTeacherId,_tmpDate,_tmpTimeSlot,_tmpSubject,_tmpQrToken,_tmpIsActive,_tmpCreatedAt);
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
  public LiveData<List<AttendanceSession>> getSessionsByTeacher(final int teacherId) {
    final String _sql = "SELECT * FROM attendance_sessions WHERE teacherId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, teacherId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"attendance_sessions"}, false, new Callable<List<AttendanceSession>>() {
      @Override
      @Nullable
      public List<AttendanceSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfQrToken = CursorUtil.getColumnIndexOrThrow(_cursor, "qrToken");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<AttendanceSession> _result = new ArrayList<AttendanceSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceSession _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpClassId;
            _tmpClassId = _cursor.getInt(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final String _tmpQrToken;
            if (_cursor.isNull(_cursorIndexOfQrToken)) {
              _tmpQrToken = null;
            } else {
              _tmpQrToken = _cursor.getString(_cursorIndexOfQrToken);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new AttendanceSession(_tmpId,_tmpClassId,_tmpClassName,_tmpTeacherId,_tmpDate,_tmpTimeSlot,_tmpSubject,_tmpQrToken,_tmpIsActive,_tmpCreatedAt);
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
  public LiveData<List<AttendanceSession>> getSessionsByClass(final int classId) {
    final String _sql = "SELECT * FROM attendance_sessions WHERE classId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"attendance_sessions"}, false, new Callable<List<AttendanceSession>>() {
      @Override
      @Nullable
      public List<AttendanceSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfQrToken = CursorUtil.getColumnIndexOrThrow(_cursor, "qrToken");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<AttendanceSession> _result = new ArrayList<AttendanceSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceSession _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpClassId;
            _tmpClassId = _cursor.getInt(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final String _tmpQrToken;
            if (_cursor.isNull(_cursorIndexOfQrToken)) {
              _tmpQrToken = null;
            } else {
              _tmpQrToken = _cursor.getString(_cursorIndexOfQrToken);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new AttendanceSession(_tmpId,_tmpClassId,_tmpClassName,_tmpTeacherId,_tmpDate,_tmpTimeSlot,_tmpSubject,_tmpQrToken,_tmpIsActive,_tmpCreatedAt);
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
  public Object alreadyMarked(final int sessionId, final int studentId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE sessionId = ? AND studentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sessionId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, studentId);
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
  public LiveData<List<AttendanceRecord>> getRecordsByStudent(final int studentId) {
    final String _sql = "SELECT * FROM attendance_records WHERE studentId = ? ORDER BY markedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, studentId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"attendance_records"}, false, new Callable<List<AttendanceRecord>>() {
      @Override
      @Nullable
      public List<AttendanceRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfMarkedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "markedAt");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<AttendanceRecord> _result = new ArrayList<AttendanceRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpSessionId;
            _tmpSessionId = _cursor.getInt(_cursorIndexOfSessionId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
            }
            final int _tmpClassId;
            _tmpClassId = _cursor.getInt(_cursorIndexOfClassId);
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final long _tmpMarkedAt;
            _tmpMarkedAt = _cursor.getLong(_cursorIndexOfMarkedAt);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new AttendanceRecord(_tmpId,_tmpSessionId,_tmpStudentId,_tmpStudentName,_tmpClassId,_tmpSubject,_tmpDate,_tmpTimeSlot,_tmpMarkedAt,_tmpStatus);
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
  public LiveData<List<AttendanceRecord>> getRecordsBySession(final int sessionId) {
    final String _sql = "SELECT * FROM attendance_records WHERE sessionId = ? ORDER BY studentName ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sessionId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"attendance_records"}, false, new Callable<List<AttendanceRecord>>() {
      @Override
      @Nullable
      public List<AttendanceRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfMarkedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "markedAt");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<AttendanceRecord> _result = new ArrayList<AttendanceRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpSessionId;
            _tmpSessionId = _cursor.getInt(_cursorIndexOfSessionId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
            }
            final int _tmpClassId;
            _tmpClassId = _cursor.getInt(_cursorIndexOfClassId);
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final long _tmpMarkedAt;
            _tmpMarkedAt = _cursor.getLong(_cursorIndexOfMarkedAt);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new AttendanceRecord(_tmpId,_tmpSessionId,_tmpStudentId,_tmpStudentName,_tmpClassId,_tmpSubject,_tmpDate,_tmpTimeSlot,_tmpMarkedAt,_tmpStatus);
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
  public Object getPresentCount(final int studentId, final int classId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE studentId = ? AND classId = ? AND status = 'PRESENT'";
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
  public Object getTotalSessions(final int classId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(DISTINCT sessionId) FROM attendance_records WHERE classId = ?";
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
