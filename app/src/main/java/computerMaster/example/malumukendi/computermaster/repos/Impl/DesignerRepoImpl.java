package computerMaster.example.malumukendi.computermaster.repos.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import computerMaster.example.malumukendi.computermaster.conf.databases.DBConstants;
import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.repos.DesignerRepo;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class DesignerRepoImpl extends SQLiteOpenHelper implements DesignerRepo {
    public static final String TABLE_NAME = "Employee";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME="surname";
    public static final String COLUMN_ADDRESS="address";

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_SURNAME + " TEXT NOT NULL , "
            + COLUMN_ADDRESS + " TEXT NOT NULL , "
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT);";

    public DesignerRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public DesignerRepoImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //@Override
    public Designer findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ADDRESS,
                        COLUMN_SURNAME,
                        COLUMN_NAME
                        ,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Designer employee = new Designer.Builder()
                    .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                    .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                    .build();
            return employee;
        } else {
            return null;
        }
    }
    @Override
    public Designer save(Designer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Designer insertedEntity = new Designer.Builder()
                .copy(entity)
                .identification(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public Designer update(Designer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())}
        );
        return entity;
    }
    @Override
    public Designer delete(Designer entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())});
        return entity;
    }
    @Override
    public Set<Designer> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Designer> emps = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Designer emp = new Designer.Builder()
                        .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .build();
                emps.add(emp);
            } while (cursor.moveToNext());
        }
        return emps;
    }
    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
