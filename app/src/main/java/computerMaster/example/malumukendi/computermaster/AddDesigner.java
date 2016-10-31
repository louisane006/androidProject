package computerMaster.example.malumukendi.computermaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.malumukendi.computermaster.*;
import java.util.HashMap;
import java.util.Map;

import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.factory.DesignerFactory;
import computerMaster.example.malumukendi.computermaster.repos.DesignerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.DesignerRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
public class AddDesigner extends Activity {

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
        desNum = (EditText) findViewById(R.id.emp_Number);
        name = (EditText) findViewById(R.id.emp_Name);
        surname = (EditText) findViewById(R.id.emp_Surname);
        address = (EditText) findViewById(R.id.emp_Address);
        desadd = (Button) findViewById(R.id.addEmpl);
        desback = (Button) findViewById(R.id.backEmpl);
        AddDesignerData();
        assert desback != null;
        desback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void AddDesignerData()
    {
        desadd.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        DesignerRepo repo = new DesignerRepoImpl(getApplicationContext());
                        tempName = name.getText().toString();
                        tempNumber = desNum.getText().toString();
                        tempSurname = surname.getText().toString();
                        tempAddress = address.getText().toString();

                        Map<String, String> values = new HashMap<>();
                        values.put("number", desNum.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("surname", surname.getText().toString());
                        values.put("address", address.getText().toString());

                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("")|| tempAddress.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        }
                        else {

                            Designer designer = DesignerFactory.createEmployee(values);
                            if (designer != null) {
                                repo.save(designer);
                                Toast.makeText(AddDesigner.this, "Designer Inserted Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
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
