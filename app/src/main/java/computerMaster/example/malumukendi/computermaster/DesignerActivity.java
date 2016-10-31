package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.malumukendi.computermaster.R;

import java.util.ArrayList;
import java.util.Set;

import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.repos.Impl.DesignerRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
public class DesignerActivity extends AppCompatActivity {
    DataBaseHelper db;
    private Button addE;
    private Button updateE;
    private Button deleteE;
    private Button viewE;
    private Button CancelE;
    TextView textView;
    public DesignerActivity(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer);
        db = new DataBaseHelper(this);
        addE = (Button) findViewById(R.id.addEmp);
        updateE = (Button) findViewById(R.id.updateEmp);
        deleteE = (Button) findViewById(R.id.deleteEmp);
        viewE = (Button) findViewById(R.id.viewEmp);
        CancelE = (Button) findViewById(R.id.cancelEmp);

        viewDesigners();
        assert addE != null;
        addE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddDesigner.class);
                startActivity(i);
            }
        });
       assert updateE != null;
        updateE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteDesigner.class);
                startActivity(i);
            }
        });
        assert deleteE != null;
        deleteE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeleteDesigner.class);
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
    public void viewDesigners()
    {
        viewE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //db.viewEmployees(textView);
                        DesignerRepoImpl repo = new DesignerRepoImpl(getApplicationContext());
                        Set<Designer> designers;
                        designers =   repo.findAll();
                        ArrayList<String> names = new ArrayList<String>();

                        for (Designer designer : designers)
                        {
                            names.add( designer.getIdentification()+ " " + designer.getName() + " "+ designer.getSurname());
                        }
                        textView = (TextView) findViewById(R.id.textView25);
                    }
                }
        );
    }
}
