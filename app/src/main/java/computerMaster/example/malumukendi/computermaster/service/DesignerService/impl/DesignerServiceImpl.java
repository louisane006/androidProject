package computerMaster.example.malumukendi.computermaster.service.DesignerService.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import computerMaster.example.malumukendi.computermaster.conf.databases.GlobalContext;
import computerMaster.example.malumukendi.computermaster.domain.Designer;
import computerMaster.example.malumukendi.computermaster.repos.DesignerRepo;
import computerMaster.example.malumukendi.computermaster.repos.Impl.DesignerRepoImpl;
import computerMaster.example.malumukendi.computermaster.service.DesignerService.DesignerService;

/**
 * Created by Malu.Mukendi on 2016-05-31.
 */
public class DesignerServiceImpl extends Service implements DesignerService {

    DesignerRepo repo;
    private static DesignerServiceImpl service = null;
    public DesignerServiceImpl()
    {
         repo = new DesignerRepoImpl(GlobalContext.getAppContext());
    }
    private final IBinder localBinder = new EmployeeServiceLocalBinder();
    public static DesignerServiceImpl getInstance() {
        if (service == null)
            service = new DesignerServiceImpl();
        return service;
    }
    @Override
    public Designer findById(Long id) {
       return repo.findById(id);
    }
    @Override
    public Designer save(Designer entity) {
       return repo.save(entity);
    }
   @Override
    public Designer update(Designer entity) {
        repo.update(entity);
        return entity;
    }
    @Override
    public Designer delete(Designer entity) {
        repo.delete(entity);
        return  entity;
    }
    @Override
    public Set<Designer> findAll() {

        Set<Designer> employees;
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
        public DesignerServiceImpl getService() {
            return DesignerServiceImpl.this;
        }
    }
}
