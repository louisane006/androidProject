package computerMaster.example.malumukendi.computermaster.repositoriesTest;

import android.test.AndroidTestCase;

import computerMaster.example.malumukendi.computermaster.domain.User;
import computerMaster.example.malumukendi.computermaster.factory.UserFactory;
import computerMaster.example.malumukendi.computermaster.repos.Impl.UserLoginRepoImpl;
import computerMaster.example.malumukendi.computermaster.repos.UserLoginRepo;

import junit.framework.Assert;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-06-07.
 */
public class UserRepoTest extends AndroidTestCase {

    private static final String TAG="USER TEST";
    private Long id;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {
        UserLoginRepo repo = new UserLoginRepoImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("username","Louisane006");
        values.put("password", "password01");
        values.put("email", "louisane006@gmail.com");
        User user = UserFactory.createUser(values);
        assertNotNull(user);
        User insertedEntity = repo.save(user);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

       Set<User> employees = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",employees.size()>0);

        //READ ENTITY
        User entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        User updateEntity = new User.Builder()
                .identification(entity.getIdentification())
                .copy(entity)
                .password("password3")
                .build();
        repo.update(updateEntity);
        User newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","password3",newEntity.getPassword());

        // DELETE ENTITY
        repo.delete(updateEntity);
        User deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
