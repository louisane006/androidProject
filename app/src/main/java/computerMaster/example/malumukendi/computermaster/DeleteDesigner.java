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
 * Created by Malu.Mukendi on 2016-09-02.
 */
public class DeleteDesigner extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText number;
    EditText name;
    EditText surname;
    EditText address;
    Button desdelete;
    EditText EId;
    Button Dback;
    Button update;
    String id;
    String tempName;
    String tempNumber;
    String tempSurname;
    String tempAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletedesigner);
        dataBaseHelper = new DataBaseHelper(this);
        number = (EditText) findViewById(R.id.e_num);
        name = (EditText) findViewById(R.id.employee_name);
        surname = (EditText) findViewById(R.id.employee_surname);
        address = (EditText) findViewById(R.id.employee_address);
        Dback = (Button) findViewById(R.id.cancel_emp);
        EId = (EditText) findViewById(R.id.emp_id);
        desdelete = (Button) findViewById(R.id.del_emp);
        update = (Button) findViewById(R.id.e_update);
        updateEmployees();
        deleteEmpData();
        assert Dback != null;
        Dback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DesignerActivity.class);
                startActivity(i);
            }
        });
    }
    public void deleteEmpData()
    {
        desdelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedUser = dataBaseHelper.deleteEmployeeData(EId.getText().toString());
                        if(deletedUser > 0)
                        {
                            Toast.makeText(DeleteDesigner.this, "Designer deleted Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), DesignerActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(DeleteDesigner.this, "Designer Not deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void updateEmployees()
    {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        id = EId.getText().toString();
                        tempName = name.getText().toString();
                        tempNumber = number.getText().toString();
                        tempSurname = surname.getText().toString();
                        tempAddress = address.getText().toString();
                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("") || tempAddress.matches("") || id.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        } else {
                            boolean isUpdate = dataBaseHelper.updateEmployee(EId.getText().toString()
                                    , number.getText().toString()
                                    , name.getText().toString()
                                    , surname.getText().toString()
                                    , address.getText().toString());
                            if (isUpdate == true) {
                                Toast.makeText(DeleteDesigner.this, "Designer Updated Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), DesignerActivity.class);
                                startActivity(i);
                            } else
                                Toast.makeText(DeleteDesigner.this, "Designer Not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
