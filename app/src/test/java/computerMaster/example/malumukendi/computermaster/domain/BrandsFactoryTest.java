package computerMaster.example.malumukendi.computermaster.domain;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import computerMaster.example.malumukendi.computermaster.factory.BrandsFactory;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class BrandsFactoryTest extends TestCase {

    public BrandsFactoryTest() {
    }
    @Test
    public void testCreate() {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", "Laptop");
        values.put("code", "LP500");
        values.put("section", "PCs");
        Brands i = BrandsFactory.createItem(values);
        Assert.assertEquals("Laptop", i.getName());
        Assert.assertEquals("LP500", i.getCode());
        Assert.assertEquals("PCs", i.getSection());
    }
    @Test
    public void testUpdate() {
        Map<String, String> values = new HashMap<String, String>();
        values.put("name", "Laptop");
        values.put("code", "LP500");
        values.put("section", "PCs");
        Brands item = BrandsFactory.createItem(values);
        Brands newItem = (new Brands.Builder().copy(item).code("LP700").build());
        Assert.assertEquals("Laptop", newItem.getName());
        Assert.assertEquals("LP700", newItem.getCode());
        Assert.assertEquals("PCs", newItem.getSection());
    }
}
