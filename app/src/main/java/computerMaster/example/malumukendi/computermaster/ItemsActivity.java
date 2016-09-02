package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
public class ItemsActivity extends AppCompatActivity {
    DataBaseHelper db;
    Button addI;
    Button updateI;
    Button deleteI;
    Button viewI;
    Button CancelI;
    TextView textView;
    EditText name;
    public ItemsActivity(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        db = new DataBaseHelper(this);
        addI = (Button) findViewById(R.id.addItems);
        updateI = (Button) findViewById(R.id.updateItems);
        deleteI = (Button) findViewById(R.id.deleteItems);
        viewI = (Button) findViewById(R.id.viewItems);
        CancelI = (Button) findViewById(R.id.cancelItems);
        textView = (TextView) findViewById(R.id.textView24);
        name = (EditText) findViewById(R.id.item_name);
        viewItems();
        assert addI != null;
        addI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddItems.class);
                startActivity(i);
            }
        });
       assert updateI != null;
        updateI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteItem.class);
                startActivity(i);
            }
        });
        assert deleteI != null;
        deleteI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteItem.class);
                startActivity(i);
            }
        });
        assert CancelI != null;
        CancelI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void viewItems ()
    {
        viewI.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.viewItems(textView);
                    }
                }
        );
    }
}
