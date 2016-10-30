package computerMaster.example.malumukendi.computermaster.factory;


import java.util.Map;

import computerMaster.example.malumukendi.computermaster.domain.Brands;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class BrandsFactory {
    public static Brands createItem(Map<String, String> values) {
        return new Brands.Builder()
                .name(values.get("name"))
                .code(values.get("code"))
                .section(values.get("section"))
                .build();
    }
}
