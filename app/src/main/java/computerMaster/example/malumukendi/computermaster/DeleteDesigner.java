package computerMaster.example.malumukendi.computermaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.malumukendi.computermaster.R;

import java.util.HashMap;
import java.util.Map;

import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.factory.DesignerFactory;
import computerMaster.example.malumukendi.computermaster.repos.DesignerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.DesignerRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-09-02.
 */
public class DeleteDesigner extends Activity {

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
        number = (EditText) findViewById(R.id.e_num);
        name = (EditText) findViewById(R.id.employee_name);
        surname = (EditText) findViewById(R.id.employee_surname);
        address = (EditText) findViewById(R.id.employee_address);
        Dback = (Button) findViewById(R.id.cancel_emp);
        EId = (EditText) findViewById(R.id.emp_id);
        desdelete = (Button) findViewById(R.id.del_emp);
        update = (Button) findViewById(R.id.e_update);
        updateDesigner();
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
                        DesignerRepo repo = new DesignerRepoImpl(getApplicationContext());
                        Map<String, String> values = new HashMap<>();
                        values.put("number", number.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("surname", surname.getText().toString());
                        values.put("address", address.getText().toString());

                        Designer designer = DesignerFactory.createEmployee(values);
                        if(designer != null)
                        {
                            repo.delete(designer);
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
    public void updateDesigner()
    {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DesignerRepo repo = new DesignerRepoImpl(getApplicationContext());
                        id = EId.getText().toString();
                        tempName = name.getText().toString();
                        tempNumber = number.getText().toString();
                        tempSurname = surname.getText().toString();
                        tempAddress = address.getText().toString();

                        Map<String, String> values = new HashMap<>();
                        values.put("number", number.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("surname", surname.getText().toString());
                        values.put("address", address.getText().toString());

                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("") || tempAddress.matches("") || id.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        } else {
                            Designer designer = DesignerFactory.createEmployee(values);
                            if (designer != null) {
                                repo.delete(designer);
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
