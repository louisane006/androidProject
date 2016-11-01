package computerMaster.example.malumukendi.computermaster;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void viewItems(TextView textView)
    {
        Cursor cursor = this.getReadableDatabase().rawQuery("select *from Items", null);
        textView.setText("");
        while(cursor.moveToNext())
        {
            textView.append(cursor.getString(0) +" "+ cursor.getString(1)+ " "+ cursor.getString(2)+ " "+ cursor.getString(3)+"\n");
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


