package computerMaster.example.malumukendi.computermaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by Malu.Mukendi on 2016-05-31.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ComputerMaster.db";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users ( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME, EMAIL, PASSWORD)");
        db.execSQL("CREATE TABLE customers ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NUMBER, NAME,SURNAME)");
        db.execSQL("CREATE TABLE employees ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NUMBER, NAME,SURNAME, ADDRESS)");
        db.execSQL("CREATE TABLE items ( ID INTEGER PRIMARY KEY AUTOINCREMENT, CODE, NAME,SECTION)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS customers");
        db.execSQL("DROP TABLE IF EXISTS employees");
        db.execSQL("DROP TABLE IF EXISTS items");
        onCreate(db);
    }
    public boolean  insertData(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long result = db.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean updateUser(String id, String username, String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.update("users", contentValues, "id = ?", new String[]{id});
        return true;
    }
    public int deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users", "ID = ?", new String[]{id});
    }
    public boolean insertCustomerData(String number, String name, String surname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", number);
        contentValues.put("name", name);
        contentValues.put("surname", surname);

        long result = db.insert("customers", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertEmployeeData(String number, String name, String surname, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", number);
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("address", address);

        long result = db.insert("employees", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertItemData(String code, String name, String section) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("code", code);
        contentValues.put("name", name);
        contentValues.put("section", section);

        long result = db.insert("items", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateItem(String id, String code, String name, String section)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("code", code);
        contentValues.put("section", section);
        db.update("items", contentValues, "id = ?", new String[]{id});
        return true;
    }
    public boolean updateCustomer(String id, String custnum, String name, String surname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", custnum);
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        db.update("customers", contentValues, "id = ?", new String[]{id});
        return true;
    }
    public boolean updateEmployee(String id, String num, String name, String surname, String address)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", num);
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("address", address);
        db.update("employees", contentValues, "id = ?", new String[]{id});
        return true;
    }

    public int deleteCustData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("customers", "ID = ?", new String[]{id});
    }
    public int deleteEmployeeData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("employees", "ID = ?", new String[]{id});
    }
    public int deleteItemData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("items", "ID = ?", new String[]{id});
    }
    public void viewItems(TextView textView)
    {
        Cursor cursor = this.getReadableDatabase().rawQuery("select *from items", null);
        textView.setText("");
        while(cursor.moveToNext())
        {
            textView.append(cursor.getString(0) +" "+ cursor.getString(1)+ " "+ cursor.getString(2)+ " "+ cursor.getString(3)+"\n");
        }
    }
    public void viewUsers(TextView textView)
    {
        Cursor cursor = this.getReadableDatabase().rawQuery("select *from users", null);
        textView.setText("");
        while(cursor.moveToNext())
        {
            textView.append(cursor.getString(0) +" "+ cursor.getString(1)+ " "+ cursor.getString(2)+ " "+ cursor.getString(3)+"\n");
        }
    }
    public void viewEmployees(TextView textView)
    {
        Cursor cursor = this.getReadableDatabase().rawQuery("select *from employees", null);
        textView.setText("");
        while(cursor.moveToNext())
        {
            textView.append(cursor.getString(0) +" "+ cursor.getString(1)+ " "+ cursor.getString(2)+ " "+ cursor.getString(3)+" " + cursor.getString(4)+"\n");
        }
    }
    public void viewCustomers(TextView textView)
    {
        Cursor cursor = this.getReadableDatabase().rawQuery("select *from Customers", null);
        textView.setText("");
        while(cursor.moveToNext())
        {
            textView.append(cursor.getString(0) +" "+ cursor.getString(1)+ " "+ cursor.getString(2)+ " "+ cursor.getString(3)+"\n");
        }
    }
}


