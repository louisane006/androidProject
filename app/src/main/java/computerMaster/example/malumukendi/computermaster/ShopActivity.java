package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-08-17.
 */
public class ShopActivity extends AppCompatActivity {

    private Button customerBtn;
    private Button employeeBtn;
    private Button itemBtn;
    private Button backS;
    public ShopActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        customerBtn = (Button) findViewById(R.id.customer);
        employeeBtn = (Button) findViewById(R.id.employee);
        itemBtn = (Button) findViewById(R.id.item);
        backS = (Button) findViewById(R.id.backShop);

        assert customerBtn != null;
        customerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(i);
            }
        });
       assert employeeBtn != null;
        employeeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EmployeesActivity.class);
                startActivity(i);
            }
        });
        assert itemBtn != null;
        itemBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(i);
            }
        });
        assert backS != null;
        backS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
