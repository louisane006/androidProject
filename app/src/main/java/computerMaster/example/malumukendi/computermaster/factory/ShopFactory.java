package computerMaster.example.malumukendi.computermaster.factory;


import computerMaster.example.malumukendi.computermaster.domain.Shop;
import java.util.Map;

/**
 * Created by Malu.Mukendi on 2016-08-14.
 */
public class ShopFactory {
    public static Shop createShop(Map<String, String> values) {
                return new Shop.Builder()
                .name(values.get("name"))
                .address(values.get("address"))
                .build();
    }
}

