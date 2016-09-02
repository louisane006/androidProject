package computerMaster.example.malumukendi.computermaster.factory;


import computerMaster.example.malumukendi.computermaster.domain.Items;

import java.util.Map;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class ItemFactory {
    public static Items createItem(Map<String, String> values) {
        return new Items.Builder()
                .name(values.get("name"))
                .code(values.get("code"))
                .section(values.get("section"))
                .build();
    }
}
