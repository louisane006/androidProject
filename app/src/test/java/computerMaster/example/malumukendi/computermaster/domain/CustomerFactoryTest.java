package computerMaster.example.malumukendi.computermaster.domain;

import computerMaster.example.malumukendi.computermaster.factory.CustomerFactory;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class CustomerFactoryTest extends TestCase {
    public CustomerFactoryTest() {
    }
    @Test
    public void testCreate() {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", "Louise");
        values.put("surname", "Malu");
        values.put("custNum", "213015889");
        Customer c = CustomerFactory.createCustomer(values);
        Assert.assertEquals("213015889", c.getCustNum());
        Assert.assertEquals("Louise", c.getName());
        Assert.assertEquals("Malu", c.getSurname());
    }
    @Test
    public void testUpdate() {
        HashMap values = new HashMap<>();
        values.put("name", "Louise");
        values.put("surname", "Malu");
        values.put("custNum", "213015889");
        Customer c = CustomerFactory.createCustomer(values);
        Customer newCust= (new Customer.Builder().name("Louise").copy(c).surname("Mukendi").build());
        Assert.assertEquals("213015889", newCust.getCustNum());
        Assert.assertEquals("Louise", newCust.getName());
        Assert.assertEquals("Mukendi", newCust.getSurname());
    }
}