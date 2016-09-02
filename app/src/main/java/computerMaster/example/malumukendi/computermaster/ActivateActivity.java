package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-05-31.
 */

public class ActivateActivity extends AppCompatActivity{

    DataBaseHelper dataBaseHelper;
    EditText username;
    EditText emailAddress;
    EditText password;
    EditText user_Id;
    Button activateButton;
    Button userDelete;
    Button view;
    Button update;
    Button cancelButton;
    TextView textView;
    public ActivateActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);
        dataBaseHelper = new DataBaseHelper(this);
        username = (EditText) findViewById(R.id.username);
        emailAddress = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        activateButton  = (Button) findViewById(R.id.createButton);
        userDelete = (Button) findViewById(R.id.deleteUser);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        textView = (TextView) findViewById(R.id.textView26);
        view = (Button) findViewById(R.id.view_user);
        user_Id = (EditText) findViewById(R.id.user);
        update = (Button) findViewById(R.id.update_user);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserLogin.class);
                startActivity(i);
            }
        });
        assert userDelete != null;
        userDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteUser.class);
                startActivity(i);
            }
        });
    }
}



