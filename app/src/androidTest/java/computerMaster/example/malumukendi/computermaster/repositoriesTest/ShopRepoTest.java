package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;
import computerMaster.example.malumukendi.computermaster.domain.Shop;
import computerMaster.example.malumukendi.computermaster.factory.ShopFactory;
import computerMaster.example.malumukendi.computermaster.repos.Impl.ShopRepoImpl;
import computerMaster.example.malumukendi.computermaster.repos.ShopRepo;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by louisane Malu on images4/images2/2016.
 */
public class ShopRepoTest extends AndroidTestCase {
    private static final String TAG="EMPLOYEE TEST";
    private Long id;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {
        ShopRepo repo = new ShopRepoImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Computer Master");
        values.put("address", "Plumstead");
        Shop shop = ShopFactory.createShop(values);
        assertNotNull(shop);
        Shop insertedEntity = repo.save(shop);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        Set<Shop> shops = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",shops.size()>0);

        //READ ENTITY
        Shop entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Shop updateEntity = new Shop.Builder()
                .id(entity.getId())
                .copy(entity)
                .address("Cape Town")
                .build();
        repo.update(updateEntity);
        Shop newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Cape Town",newEntity.getAddress());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Shop deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
