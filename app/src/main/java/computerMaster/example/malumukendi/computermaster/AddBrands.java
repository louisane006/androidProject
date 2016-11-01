package computerMaster.example.malumukendi.computermaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.malumukendi.computermaster.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import computerMaster.example.malumukendi.computermaster.domain.Brands;
import computerMaster.example.malumukendi.computermaster.factory.BrandsFactory;
import computerMaster.example.malumukendi.computermaster.repos.BrandsRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.BrandsRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-08-18.
 */public class AddBrands extends Activity {

    EditText code;
    EditText name;
    Button itemadd;
    Button itemback;
    Spinner section;
    String tempName;
    String tempCode;
    public AddBrands() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbrand);
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
                        BrandsRepo repo = new BrandsRepoImpl(getApplicationContext());
                        tempName = name.getText().toString();
                        tempCode = code.getText().toString();

                        Map<String, String> values = new HashMap<>();
                        String.valueOf(section.getSelectedItem());
                        values.put("code", code.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("section", String.valueOf(section.getSelectedItem()));

                        if (tempName.matches("") || tempCode.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Brands brands = BrandsFactory.createItem(values);
                            if (brands != null) {
                                repo.save(brands);
                                Toast.makeText(AddBrands.this, "Item Inserted Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), CustomerActivity.class);
                                startActivity(i);
                            }
                            else
                                Toast.makeText(AddBrands.this, "Item Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
