package computerMaster.example.malumukendi.computermaster.serviceTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import computerMaster.example.malumukendi.computermaster.conf.databases.GlobalContext;
import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.factory.DesignerFactory;
import computerMaster.example.malumukendi.computermaster.repos.Impl.DesignerRepoImpl;
import computerMaster.example.malumukendi.computermaster.service.DesignerService.impl.DesignerServiceImpl;

/**
 * Created by Malu.Mukendi on 2016-09-01.
 */
public class DesignerServiceTest extends TestCase {
    private static final String TAG="EMPLOYEE TEST1";
    private Long id;
    private DesignerServiceImpl employeeService;
    DesignerRepoImpl employeeRepo;
    private boolean isBound;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DesignerServiceImpl.EmployeeServiceLocalBinder binder
                    = (DesignerServiceImpl.EmployeeServiceLocalBinder) service;
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
        Intent intent = new Intent(this.employeeService, DesignerServiceImpl.class);
        GlobalContext.context = this.employeeService;
        employeeService = DesignerServiceImpl.getInstance();
        GlobalContext.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    public void testCreateReadUpdateDelete() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Louise");
        values.put("surname", "Malu");
        values.put("address", "Plumstead");
        Designer employee = DesignerFactory.createEmployee(values);
        assertNotNull(employee);
        Designer insertedEntity = employeeRepo.save(employee);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Designer> books = employeeService.findAll();
        Assert.assertTrue(TAG + " READ ALL", books.size() > 0);

        //READ ENTITY
        Designer entity = employeeService.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Designer updateEntity = new Designer.Builder()
                .identification(entity.getIdentification())
                .copy(entity)
                .address("Cape Town")
                .build();
        employeeService.update(updateEntity);
        Designer newEntity = employeeService.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Cape Town", newEntity.getAddress());
    }
}

