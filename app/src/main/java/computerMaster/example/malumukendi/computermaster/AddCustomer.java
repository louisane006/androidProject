package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
public class AddCustomer extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText number;
    EditText name;
    EditText surname;
    Button custadd;
    Button custUpdate;
    Button viewC;
    Button custback;
    EditText cId;
    String tempName;
    String tempNumber;
    String tempSurname;
    public AddCustomer() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcust);
        dataBaseHelper = new DataBaseHelper(this);
        custadd = (Button) findViewById(R.id.addCustomer);
        custback = (Button) findViewById(R.id.backCustomer);
        number = (EditText) findViewById(R.id.cNumber);
        name = (EditText) findViewById(R.id.cName);
        surname = (EditText) findViewById(R.id.cSurname);
        AddCustData();
        assert custback != null;
        custback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void AddCustData() {
        custadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tempName = name.getText().toString();
                        tempNumber = number.getText().toString();
                        tempSurname = surname.getText().toString();
                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean isCustInserted = dataBaseHelper.insertCustomerData(
                                    number.getText().toString(),
                                    name.getText().toString(),
                                    surname.getText().toString());
                            if (isCustInserted == true) {
                                Toast.makeText(AddCustomer.this, "Customer Inserted Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                                startActivity(i);
                            } else
                                Toast.makeText(AddCustomer.this, "Customer Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}