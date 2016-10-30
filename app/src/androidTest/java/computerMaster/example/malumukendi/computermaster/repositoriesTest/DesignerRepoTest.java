package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.factory.EmployeeFactory;
import computerMaster.example.malumukendi.computermaster.repos.DesignerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.DesignerRepoImpl;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class DesignerRepoTest extends AndroidTestCase {
    private static final String TAG="EMPLOYEE TEST";
    private Long id;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {
        DesignerRepo repo = new DesignerRepoImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Louise");
        values.put("surname", "Malu");
        values.put("address", "Plumstead");
        Designer employee = EmployeeFactory.createEmployee(values);
        assertNotNull(employee);
        Designer insertedEntity = repo.save(employee);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        Set<Designer> employees = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",employees.size()>0);

        //READ ENTITY
        Designer entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Designer updateEntity = new Designer.Builder()
                .identification(entity.getIdentification())
                .copy(entity)
                .address("Cape Town")
                .build();
        repo.update(updateEntity);
        Designer newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Cape Town",newEntity.getAddress());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Designer deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
