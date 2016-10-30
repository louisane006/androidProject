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
public class AddDesigner extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText desNum;
    EditText surname;
    EditText name;
    EditText address;
    private Button desadd;
    private Button desback;
    String tempName;
    String tempNumber;
    String tempSurname;
    String tempAddress;
    public AddDesigner(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddesigner);
        dataBaseHelper = new DataBaseHelper(this);
        desNum = (EditText) findViewById(R.id.emp_Number);
        name = (EditText) findViewById(R.id.emp_Name);
        surname = (EditText) findViewById(R.id.emp_Surname);
        address = (EditText) findViewById(R.id.emp_Address);
        desadd = (Button) findViewById(R.id.addEmpl);
        desback = (Button) findViewById(R.id.backEmpl);
        AddEmployeeData();
        assert desback != null;
        desback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void AddEmployeeData()
    {
        desadd.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        tempName = name.getText().toString();
                        tempNumber = desNum.getText().toString();
                        tempSurname = surname.getText().toString();
                        tempAddress = address.getText().toString();
                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("")|| tempAddress.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        }
                        else {
                        boolean isItemInserted = dataBaseHelper.insertEmployeeData(
                                desNum.getText().toString(),
                                name.getText().toString(),
                                surname.getText().toString(),
                                address.getText().toString());
                        if(isItemInserted == true)
                        {
                            Toast.makeText(AddDesigner.this, "Designer Inserted Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), DesignerActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(AddDesigner.this, "Designer Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
