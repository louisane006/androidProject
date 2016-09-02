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
public class AddEmployees extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText empNum;
    EditText surname;
    EditText name;
    EditText address;
    private Button empadd;
    private Button empback;
    String tempName;
    String tempNumber;
    String tempSurname;
    String tempAddress;
    public AddEmployees(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);
        dataBaseHelper = new DataBaseHelper(this);
        empNum = (EditText) findViewById(R.id.emp_Number);
        name = (EditText) findViewById(R.id.emp_Name);
        surname = (EditText) findViewById(R.id.emp_Surname);
        address = (EditText) findViewById(R.id.emp_Address);
        empadd = (Button) findViewById(R.id.addEmpl);
        empback = (Button) findViewById(R.id.backEmpl);
        AddEmployeeData();
        assert empback != null;
        empback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void AddEmployeeData()
    {
        empadd.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        tempName = name.getText().toString();
                        tempNumber = empNum.getText().toString();
                        tempSurname = surname.getText().toString();
                        tempAddress = address.getText().toString();
                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("")|| tempAddress.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        }
                        else {
                        boolean isItemInserted = dataBaseHelper.insertEmployeeData(
                                empNum.getText().toString(),
                                name.getText().toString(),
                                surname.getText().toString(),
                                address.getText().toString());
                        if(isItemInserted == true)
                        {
                            Toast.makeText(AddEmployees.this, "Employee Inserted Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), EmployeesActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(AddEmployees.this, "Employee Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
