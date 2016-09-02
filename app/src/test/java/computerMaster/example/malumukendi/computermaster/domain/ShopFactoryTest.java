package computerMaster.example.malumukendi.computermaster.domain;

import computerMaster.example.malumukendi.computermaster.factory.ShopFactory;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class ShopFactoryTest extends TestCase {
    List<Employee> e;
    public ShopFactoryTest() {
    }
    @Test
    public void testCreate() {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", "Computer Master");
        values.put("address", "Protea 405");
        Shop shop = ShopFactory.createShop(values);
        //Assert.assertEquals(e, shop.getEmployees());
        Assert.assertEquals("Computer Master", shop.getName());
        Assert.assertEquals("Protea 405", shop.getAddress());
    }
    @Test
    public void testUpdate() {
        HashMap values = new HashMap<>();
        values.put("name", "Computer Master");
        values.put("address", "Protea 405");
        Shop shop = ShopFactory.createShop(values);
        Shop newShop= (new Shop.Builder().name("Computer Master").copy(shop).address("Plumstead 405").build());
        //Assert.assertEquals(e, newShop.getEmployees());
        Assert.assertEquals("Computer Master", newShop.getName());
        Assert.assertEquals("Plumstead 405", newShop.getAddress());
    }
}
