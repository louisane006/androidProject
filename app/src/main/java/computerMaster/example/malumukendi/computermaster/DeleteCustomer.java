package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.malumukendi.computermaster.R;

import java.util.HashMap;
import java.util.Map;

import computerMaster.example.malumukendi.computermaster.domain.Customer;
import computerMaster.example.malumukendi.computermaster.factory.CustomerFactory;
import computerMaster.example.malumukendi.computermaster.repos.CustomerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.CustomerRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-08-19.
 */
public class DeleteCustomer extends AppCompatActivity {
    EditText number;
    EditText name;
    EditText surname;
    Button update;
    Button cust_delete;
    EditText cust_ID;
    Button custback;
    String id;
    String tempName;
    String tempNumber;
    String tempSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delcust);
        custback = (Button) findViewById(R.id.cancel_Delete);
        number = (EditText) findViewById(R.id.c_number);
        name = (EditText) findViewById(R.id.c_name);
        surname = (EditText) findViewById(R.id.c_surname);
        cust_ID = (EditText) findViewById(R.id.cust_Id);
        cust_delete = (Button) findViewById(R.id.delete_Customer);
        update = (Button) findViewById(R.id.update_customer);
        deleteCustData();
        updateCustomer();
    assert custback != null;
        custback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(i);
            }
        });
    }
   public void deleteCustData()
    {
        cust_delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomerRepo repo = new CustomerRepoImpl(getApplicationContext());
                        Map<String, String> values = new HashMap<>();
                        values.put("number", number.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("surname", surname.getText().toString());
                        Customer customer = CustomerFactory.createCustomer(values);

                        if(customer != null)
                        {
                            repo.delete(customer);
                            Toast.makeText(DeleteCustomer.this, "Customer deleted Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(DeleteCustomer.this, "Customer Not deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void updateCustomer()
    {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomerRepo repo = new CustomerRepoImpl(getApplicationContext());
                        id = cust_ID.getText().toString();
                        tempName = name.getText().toString();
                        tempNumber = number.getText().toString();
                        tempSurname = surname.getText().toString();

                        Map<String, String> values = new HashMap<>();
                        values.put("number", number.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("surname", surname.getText().toString());

                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("") || id.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        } else {
                            Customer cust = CustomerFactory.createCustomer(values);
                            if (cust != null) {
                                repo.update(cust);
                                Toast.makeText(DeleteCustomer.this, "Customer Updated Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), DesignerActivity.class);
                                startActivity(i);
                            } else
                                Toast.makeText(DeleteCustomer.this, "Customer Not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
