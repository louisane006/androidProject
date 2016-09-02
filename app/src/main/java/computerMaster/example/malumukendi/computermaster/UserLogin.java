package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-05-31.
 */
public class UserLogin extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button sign;
    private Button home;
    Button login;
    public UserLogin() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        sign = (Button) findViewById(R.id.signButton);
        login = (Button) findViewById(R.id.loginButton);
        home = (Button) findViewById(R.id.homeBtn);

        assert sign != null;
        sign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivateActivity.class);
                startActivity(i);
            }
        });
        assert login != null;
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
        assert home != null;
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
