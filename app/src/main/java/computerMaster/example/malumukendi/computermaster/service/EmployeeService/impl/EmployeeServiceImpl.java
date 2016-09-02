package computerMaster.example.malumukendi.computermaster.service.EmployeeService.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import computerMaster.example.malumukendi.computermaster.conf.databases.GlobalContext;
import computerMaster.example.malumukendi.computermaster.domain.Employee;
import computerMaster.example.malumukendi.computermaster.repos.EmployeeRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.EmployeeRepoImpl;
import computerMaster.example.malumukendi.computermaster.service.EmployeeService.EmployeeService;
import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-05-31.
 */
public class EmployeeServiceImpl extends Service implements EmployeeService {

    EmployeeRepo repo;
    private static EmployeeServiceImpl service = null;
    public EmployeeServiceImpl()
    {
         repo = new EmployeeRepoImpl(GlobalContext.getAppContext());
    }
    private final IBinder localBinder = new EmployeeServiceLocalBinder();
    public static EmployeeServiceImpl getInstance() {
        if (service == null)
            service = new EmployeeServiceImpl();
        return service;
    }
    @Override
    public Employee findById(Long id) {
       return repo.findById(id);
    }
    @Override
    public Employee save(Employee entity) {
       return repo.save(entity);
    }
   @Override
    public Employee update(Employee entity) {
        repo.update(entity);
        return entity;
    }
    @Override
    public Employee delete(Employee entity) {
        repo.delete(entity);
        return  entity;
    }
    @Override
    public Set<Employee> findAll() {

        Set<Employee> employees;
        employees =   repo.findAll();
        return employees;
    }
    @Override
    public int deleteAll() {
        int result = repo.deleteAll();
        return result;
    }
    public boolean passwordValidation(String password)
    {

        if (password.length() >=  5)

            return  true;
        else
            return false;
    }
  @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class EmployeeServiceLocalBinder extends Binder {
        public EmployeeServiceImpl getService() {
            return EmployeeServiceImpl.this;
        }
    }
}
