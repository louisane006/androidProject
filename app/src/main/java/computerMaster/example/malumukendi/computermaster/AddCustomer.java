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

import computerMaster.example.malumukendi.computermaster.domain.Customer;
import computerMaster.example.malumukendi.computermaster.factory.CustomerFactory;
import computerMaster.example.malumukendi.computermaster.repos.CustomerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.CustomerRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
/*public class AddCustomer extends Activity {

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
                     CustomerRepo repo = new CustomerRepoImpl(getApplicationContext());//
                        Map<String,String> values = new HashMap<String,String>();//
                        tempName = name.getText().toString();
                        tempNumber = number.getText().toString();
                        tempSurname = surname.getText().toString();
                        /*tempNumber = values.put("number", number.getText().toString());//
                        tempName = values.put("name", name.getText().toString());//
                        tempSurname = values.put("surname", surname.getText().toString());//*/

                       /* if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                       }else {
                            boolean isCustInserted = dataBaseHelper.insertCustomerData(
                                    number.getText().toString(),
                                    name.getText().toString(),
                                    surname.getText().toString());
                            //Customer customer = CustomerFactory.createCustomer(values);
                            if (isCustInserted == true) {
                                Toast.makeText(AddCustomer.this, "Customer Inserted Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                                startActivity(i);
                            } else
                                Toast.makeText(AddCustomer.this, "Customer Not Inserted", Toast.LENGTH_LONG).show();*/
                           // if (customer!= null){
                           //     repo.save(customer);
                               // Toast.makeText(AddCustomer.this, "SUCCESSFULLY ADDED", Toast.LENGTH_LONG).show();
                             //   Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                            //    startActivity(i);
                           // }
                            //else{

                              //  Toast.makeText(AddCustomer.this, "Customer Not Inserted", Toast.LENGTH_LONG).show();
                     //   }

                            /*if (isCustInserted == true) {
                                Toast.makeText(AddCustomer.this, "Customer Inserted Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                                startActivity(i);
                            } else
                                Toast.makeText(AddCustomer.this, "Customer Not Inserted", Toast.LENGTH_LONG).show();*/
                      // }

             //   }
    //    );
//    }
//}
public class AddCustomer extends Activity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcust);

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

                        CustomerRepo repo = new CustomerRepoImpl(getApplicationContext());
                        tempName = name.getText().toString();
                        tempNumber = number.getText().toString();
                        tempSurname = surname.getText().toString();

                        Map<String, String> values = new HashMap<>();
                        values.put("number", number.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("surname", surname.getText().toString());

                        if (tempName.matches("") || tempNumber.matches("") || tempSurname.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        } else {
                                    Customer customer = CustomerFactory.createCustomer(values);
                            if (customer != null) {
                                    repo.save(customer);
                                    Toast.makeText(AddCustomer.this, "Customer Inserted Successfully", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                                    startActivity(i);
                            }
                            else
                                Toast.makeText(AddCustomer.this, "Customer Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                    );
            }
    }


