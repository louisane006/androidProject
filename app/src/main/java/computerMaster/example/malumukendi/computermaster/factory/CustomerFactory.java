package computerMaster.example.malumukendi.computermaster.factory;


import computerMaster.example.malumukendi.computermaster.domain.Customer;
import java.util.Map;

/**
 * Created by Malu.Mukendi on 2016-08-14.
 */
public class CustomerFactory {
    public static Customer createCustomer(Map<String,String> values){
        return new Customer.Builder()
                .custNum(values.get("custNum"))
                .name(values.get("name"))
                .surname(values.get("surname"))
                .build();
    }
}
