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

import computerMaster.example.malumukendi.computermaster.domain.Brands;
import computerMaster.example.malumukendi.computermaster.factory.BrandsFactory;
import computerMaster.example.malumukendi.computermaster.repos.BrandsRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.BrandsRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-08-19.
 */
public class DeleteBrands extends AppCompatActivity {
    EditText name;
    EditText code;
    EditText section;
    Button update;
    Button Idelete;
    EditText IID;
    Button Iback;
    String tempName;
    String tempCode;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletebrands);
        Iback = (Button) findViewById(R.id.cancel_item);
        name = (EditText) findViewById(R.id.i_name);
        code = (EditText) findViewById(R.id.i_code);
        section = (EditText) findViewById(R.id.i_section);
        IID = (EditText) findViewById(R.id.item_id);
        Idelete = (Button) findViewById(R.id.delete_item);
        update = (Button) findViewById(R.id.update_item);
        deleteItemData();
        updateItems();
        assert Iback != null;
        Iback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BrandsActivity.class);
                startActivity(i);
            }
        });
    }
    public void deleteItemData()
    {
        Idelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        BrandsRepo repo = new BrandsRepoImpl(getApplicationContext());
                        Map<String, String> values = new HashMap<>();
                        values.put("code", code.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("section", section.getText().toString());
                        Brands brands = BrandsFactory.createItem(values);
                        if(brands != null)
                        {
                            repo.delete(brands);
                            Toast.makeText(DeleteBrands.this, "Item deleted Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), BrandsActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(DeleteBrands.this, "Item Not deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void updateItems()
    {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BrandsRepo repo = new BrandsRepoImpl(getApplicationContext());
                        id = IID.getText().toString();
                        tempName = name.getText().toString();
                        tempCode = code.getText().toString();

                        Map<String, String> values = new HashMap<>();
                        values.put("code", code.getText().toString());
                        values.put("name", name.getText().toString());
                        values.put("section", section.getText().toString());
                        Brands brands = BrandsFactory.createItem(values);

                        if (tempName.matches("") || tempCode.matches("") || id.matches("")) {
                            Toast.makeText(getApplicationContext(), "You cannot save blank values", Toast.LENGTH_LONG).show();
                        } else {

                            if (brands != null) {
                                repo.update(brands);
                                Toast.makeText(DeleteBrands.this, "Item Updated Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), DesignerActivity.class);
                                startActivity(i);
                            } else
                                Toast.makeText(DeleteBrands.this, "Item Not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
