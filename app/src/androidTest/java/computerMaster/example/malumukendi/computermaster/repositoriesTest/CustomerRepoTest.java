package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;

import computerMaster.example.malumukendi.computermaster.domain.Customer;
import computerMaster.example.malumukendi.computermaster.repos.CustomerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.CustomerRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on images4/images2/2016.
 */
public class CustomerRepoTest extends AndroidTestCase {
    private static final String TAG = "CUSTOMER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CustomerRepo repo = new CustomerRepoImpl(this.getContext());
        // CREATE
        Customer createEntity = new Customer.Builder()
                .name("Emily")
                .surname("Smith")
                .custNum("200")
                .build();
        Customer insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Customer> cust = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", cust.size() > 0);

        //READ ENTITY
        Customer entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Customer updateEntity = new Customer.Builder()
                .name("photos")
                .build();
        repo.update(updateEntity);
        Customer newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Emily", newEntity.getName());

        // DELETE ENTITY
        repo.delete(entity);
        Customer deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
