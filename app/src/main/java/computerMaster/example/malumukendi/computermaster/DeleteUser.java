package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.malumukendi.computermaster.R;

/**
 * Created by Malu.Mukendi on 2016-08-19.
 */
public class DeleteUser extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText number;
    Button Userdelete;
    EditText UId;
    Button Uback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deluser);
        dataBaseHelper = new DataBaseHelper(this);
        Uback = (Button) findViewById(R.id.cancel_user);
        UId = (EditText) findViewById(R.id.u_id);
        Userdelete = (Button) findViewById(R.id.del_user);
        assert Uback != null;
        Uback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
}
