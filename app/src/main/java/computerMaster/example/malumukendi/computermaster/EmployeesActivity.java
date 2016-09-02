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
public class EmployeesActivity extends AppCompatActivity {
    DataBaseHelper db;
    private Button addE;
    private Button updateE;
    private Button deleteE;
    private Button viewE;
    private Button CancelE;
    TextView textView;
    public EmployeesActivity(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        db = new DataBaseHelper(this);
        addE = (Button) findViewById(R.id.addEmp);
        updateE = (Button) findViewById(R.id.updateEmp);
        deleteE = (Button) findViewById(R.id.deleteEmp);
        viewE = (Button) findViewById(R.id.viewEmp);
        CancelE = (Button) findViewById(R.id.cancelEmp);
        textView = (TextView) findViewById(R.id.textView25);
        viewEmployees();
        assert addE != null;
        addE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddEmployees.class);
                startActivity(i);
            }
        });
       assert updateE != null;
        updateE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteEmployee.class);
                startActivity(i);
            }
        });
        assert deleteE != null;
        deleteE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteEmployee.class);
                startActivity(i);
            }
        });
        assert CancelE != null;
        CancelE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void viewEmployees()
    {
        viewE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.viewEmployees(textView);
                    }
                }
        );
    }
}
