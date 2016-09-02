package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
public class CustomerActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    Button addC;
    Button updateC;
    Button deleteC;
    Button viewC;
    TextView textView;
    Button CancelC;
    public CustomerActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        dataBaseHelper = new DataBaseHelper(this);
        addC = (Button) findViewById(R.id.addCust);
        updateC = (Button) findViewById(R.id.UpdateCust);
        deleteC = (Button) findViewById(R.id.DeleteCust);
        CancelC = (Button) findViewById(R.id.CancelCust);
        viewC = (Button) findViewById(R.id.show_customer);
        textView = (TextView) findViewById(R.id.textView27);
        viewCustomers();
        assert addC != null;
        addC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddCustomer.class);
                startActivity(i);
            }
        });
        assert updateC != null;
        updateC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteCustomer.class);
                startActivity(i);
            }
        });
        assert deleteC != null;
        deleteC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteCustomer.class);
                startActivity(i);
            }
        });
        assert CancelC != null;
        CancelC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void viewCustomers() {
        viewC.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dataBaseHelper.viewCustomers(textView);
                    }
                }
        );
    }
}

