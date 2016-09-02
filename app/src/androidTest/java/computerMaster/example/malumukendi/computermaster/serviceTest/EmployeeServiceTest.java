package computerMaster.example.malumukendi.computermaster.serviceTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import computerMaster.example.malumukendi.computermaster.conf.databases.GlobalContext;
import computerMaster.example.malumukendi.computermaster.domain.Employee;
import computerMaster.example.malumukendi.computermaster.factory.EmployeeFactory;
import computerMaster.example.malumukendi.computermaster.repos.Impl.EmployeeRepoImpl;
import computerMaster.example.malumukendi.computermaster.service.EmployeeService.impl.EmployeeServiceImpl;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class EmployeeServiceTest extends TestCase {
    private static final String TAG="EMPLOYEE TEST1";
    private Long id;
    private EmployeeServiceImpl employeeService;
    EmployeeRepoImpl employeeRepo;
    private boolean isBound;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            EmployeeServiceImpl.EmployeeServiceLocalBinder binder
                    = (EmployeeServiceImpl.EmployeeServiceLocalBinder) service;
            employeeService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.employeeService, EmployeeServiceImpl.class);
        GlobalContext.context = this.employeeService;
        employeeService = EmployeeServiceImpl.getInstance();
        GlobalContext.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    @Test
    public void testCreateReadUpdateDelete() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Louise");
        values.put("surname", "Malu");
        values.put("address", "Plumstead");
        Employee employee = EmployeeFactory.createEmployee(values);
        assertNotNull(employee);
        Employee insertedEntity = employeeRepo.save(employee);
        id=insertedEntity.getIdentification();
        org.junit.Assert.assertNotNull(TAG+" CREATE",insertedEntity);
        //READ ALL
        Set<Employee> books = employeeService.findAll();
        Assert.assertTrue(TAG + " READ ALL", books.size() > 0);
        //READ ENTITY
        Employee entity = employeeService.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);
        //UPDATE ENTITY
        Employee updateEntity = new Employee.Builder()
                .identification(entity.getIdentification())
                .copy(entity)
                .address("Cape Town")
                .build();
        employeeService.update(updateEntity);
        Employee newEntity = employeeService.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Cape Town", newEntity.getAddress());
    }
}

