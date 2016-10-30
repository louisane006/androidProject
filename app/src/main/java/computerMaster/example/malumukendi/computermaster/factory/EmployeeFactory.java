package computerMaster.example.malumukendi.computermaster.factory;


import java.util.Map;

import computerMaster.example.malumukendi.computermaster.domain.Designer;

/**
 * Created by Malu.Mukendi on 2016-08-14.
 */
public class EmployeeFactory {
    public static Designer createEmployee(Map<String,String> values){
        return new Designer.Builder()
                .name(values.get("name"))
                .surname(values.get("surname"))
                .address(values.get("address"))
                .build();
    }
}
