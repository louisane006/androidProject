package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;
import junit.framework.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import computerMaster.example.malumukendi.computermaster.domain.Brands;
import computerMaster.example.malumukendi.computermaster.factory.BrandsFactory;
import computerMaster.example.malumukendi.computermaster.repos.BrandsRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.BrandsRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class BrandsRepoTest extends AndroidTestCase {
    private static final String TAG ="ITEM TEST";
    private Long id;
    public void testCreateReadUpdateDelete() throws Exception {
        BrandsRepo repo = new BrandsRepoImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Lenovo2010");
        values.put("code", "LP200");
        values.put("section", "Laptops");
        Brands item = BrandsFactory.createItem(values);
        assertNotNull(item);
        Brands insertedEntity = repo.save(item);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        Set<Brands> items = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",items.size()>0);

        //READ ENTITY
        Brands entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Brands updateEntity = new Brands.Builder()
                .id(entity.getId())
                .copy(entity)
                .name("HP300")
                .build();
        repo.update(updateEntity);
        Brands newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","HP300",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Brands deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
