package computerMaster.example.malumukendi.computermaster.domain;

import computerMaster.example.malumukendi.computermaster.factory.EmployeeFactory;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class EmployeeFactoryTest extends TestCase {
    public EmployeeFactoryTest() {
    }
    @Test
    public void testCreate() {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", "Louise");
        values.put("surname", "Malu");
        values.put("address", "Wynberg");
        Employee e = EmployeeFactory.createEmployee(values);
        Assert.assertEquals("Louise", e.getName());
        Assert.assertEquals("Malu", e.getSurname());
        Assert.assertEquals("Wynberg", e.getAddress());
    }
    @Test
    public void testUpdate() {
        HashMap values = new HashMap<>();
        values.put("name", "Louise");
        values.put("surname", "Malu");
        values.put("address", "Wynberg");
        Employee e = EmployeeFactory.createEmployee(values);
        Employee newE = (new Employee.Builder().name("Louise").copy(e).surname("Mukendi").build());
        Assert.assertEquals("Louise", newE.getName());
        Assert.assertEquals("Mukendi", newE.getSurname());
        Assert.assertEquals("Wynberg", newE.getAddress());
    }
}
