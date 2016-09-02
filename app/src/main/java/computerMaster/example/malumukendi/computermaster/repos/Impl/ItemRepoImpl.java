package computerMaster.example.malumukendi.computermaster.repos.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import computerMaster.example.malumukendi.computermaster.conf.databases.DBConstants;
import computerMaster.example.malumukendi.computermaster.domain.Items;
import computerMaster.example.malumukendi.computermaster.repos.ItemRepo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class ItemRepoImpl extends SQLiteOpenHelper implements ItemRepo {
    public static final String TABLE_NAME = "Items";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE="code";
    public static final String COLUMN_SECTION="section";

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }


    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_CODE + " TEXT NOT NULL , "
            + COLUMN_SECTION + " TEXT NOT NULL , "
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT);";

    public ItemRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public ItemRepoImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public Items findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SECTION,
                        COLUMN_CODE,
                        COLUMN_NAME
                        ,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Items items = new Items.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .code(cursor.getString(cursor.getColumnIndex(COLUMN_CODE)))
                    .section(cursor.getString(cursor.getColumnIndex(COLUMN_SECTION)))
                    .build();
            return items;
        } else {
            return null;
        }
    }
    @Override
    public Items save(Items entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_CODE, entity.getCode());
        values.put(COLUMN_SECTION, entity.getSection());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Items insertedEntity = new Items.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public Items update(Items entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_CODE, entity.getCode());
        values.put(COLUMN_SECTION, entity.getSection());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }
    @Override
    public Items delete(Items entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }
    @Override
    public Set<Items> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Items> item = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Items i = new Items.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .code(cursor.getString(cursor.getColumnIndex(COLUMN_CODE)))
                        .section(cursor.getString(cursor.getColumnIndex(COLUMN_SECTION)))
                        .build();
                item.add(i);
            } while (cursor.moveToNext());
        }
        return item;
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
