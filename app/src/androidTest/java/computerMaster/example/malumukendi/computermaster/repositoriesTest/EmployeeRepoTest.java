package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;

import computerMaster.example.malumukendi.computermaster.domain.Employee;
import computerMaster.example.malumukendi.computermaster.factory.EmployeeFactory;
import computerMaster.example.malumukendi.computermaster.repos.EmployeeRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.EmployeeRepoImpl;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class EmployeeRepoTest  extends AndroidTestCase {
    private static final String TAG="EMPLOYEE TEST";
    private Long id;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {
        EmployeeRepo repo = new EmployeeRepoImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Louise");
        values.put("surname", "Malu");
        values.put("address", "Plumstead");
        Employee employee = EmployeeFactory.createEmployee(values);
        assertNotNull(employee);
        Employee insertedEntity = repo.save(employee);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        Set<Employee> employees = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",employees.size()>0);

        //READ ENTITY
        Employee entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Employee updateEntity = new Employee.Builder()
                .identification(entity.getIdentification())
                .copy(entity)
                .address("Cape Town")
                .build();
        repo.update(updateEntity);
        Employee newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Cape Town",newEntity.getAddress());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Employee deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
