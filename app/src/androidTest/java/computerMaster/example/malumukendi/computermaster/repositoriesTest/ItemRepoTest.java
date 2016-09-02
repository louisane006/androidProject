package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;

import computerMaster.example.malumukendi.computermaster.domain.Items;
import computerMaster.example.malumukendi.computermaster.factory.ItemFactory;
import computerMaster.example.malumukendi.computermaster.repos.Impl.ItemRepoImpl;
import computerMaster.example.malumukendi.computermaster.repos.ItemRepo;
import junit.framework.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class ItemRepoTest extends AndroidTestCase {
    private static final String TAG ="ITEM TEST";
    private Long id;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {
        ItemRepo repo = new ItemRepoImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Lenovo2010");
        values.put("code", "LP200");
        values.put("section", "Laptops");
        Items item = ItemFactory.createItem(values);
        assertNotNull(item);
        Items insertedEntity = repo.save(item);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        Set<Items> items = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",items.size()>0);

        //READ ENTITY
        Items entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Items updateEntity = new Items.Builder()
                .id(entity.getId())
                .copy(entity)
                .name("HP300")
                .build();
        repo.update(updateEntity);
        Items newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","HP300",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Items deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
