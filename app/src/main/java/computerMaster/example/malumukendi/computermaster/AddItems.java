package computerMaster.example.malumukendi.computermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.malumukendi.computermaster.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */
public class AddItems extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText code;
    EditText name;
    Button itemadd;
    Button itemback;
    Spinner section;
    String tempName;
    String tempCode;
    public AddItems() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        dataBaseHelper = new DataBaseHelper(this);
        code = (EditText) findViewById(R.id.itemName);
        name = (EditText) findViewById(R.id.itemCode);
        itemadd = (Button) findViewById(R.id.AddItem);
        itemback = (Button) findViewById(R.id.BackItem);
        section = (Spinner) findViewById(R.id.sectionList);
        List<String> list = new ArrayList<String>();
        list.add("PCS");
        list.add("Laptops");
        list.add("Phones");
        list.add("Parts");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(dataAdapter);
        AddItemData();
        assert itemback != null;
        itemback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(i);
            }
        });
    }
    public void AddItemData() {
        itemadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tempName = name.getText().toString();
                        tempCode = code.getText().toString();
                        if (tempName.matches("") || tempCode.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        }
                        else {
                        boolean isItemInserted = dataBaseHelper.insertItemData(
                                code.getText().toString(),
                                name.getText().toString(),
                                String.valueOf(section.getSelectedItem()));
                        if (isItemInserted == true) {
                            Toast.makeText(AddItems.this, "Item Inserted Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), ItemsActivity.class);
                            startActivity(i);
                        } else
                            Toast.makeText(AddItems.this, "Item Not Inserted", Toast.LENGTH_LONG).show();
                    }
                    }
                }
        );
    }
}
