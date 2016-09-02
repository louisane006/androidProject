package computerMaster.example.malumukendi.computermaster.factory;


import computerMaster.example.malumukendi.computermaster.domain.Employee;
import java.util.Map;

/**
 * Created by Malu.Mukendi on 2016-08-14.
 */
public class EmployeeFactory {
    public static Employee createEmployee(Map<String,String> values){
        return new Employee.Builder()
                .name(values.get("name"))
                .surname(values.get("surname"))
                .address(values.get("address"))
                .build();
    }
}
