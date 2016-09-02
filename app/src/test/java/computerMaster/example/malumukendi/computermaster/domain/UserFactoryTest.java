package computerMaster.example.malumukendi.computermaster.domain;

import computerMaster.example.malumukendi.computermaster.factory.UserFactory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class UserFactoryTest extends TestCase {
    String email;
    User user;
    public UserFactoryTest() {
    }
    @Test
    public void testCreate() {
        HashMap<String, String> values = new HashMap<>();
        values.put("username", "louisane006");
        values.put("password", "password1");
        values.put("email", "louisane006@gmail.com");
        User user = UserFactory.createUser(values);
        Assert.assertEquals("louisane006", user.getUsername());
        Assert.assertEquals("password1", user.getPassword());
    }
    @Test
    public void testUpdate() {
        HashMap values = new HashMap<>();
        values.put("username", "louisane006");
        values.put("password", "password1");
        values.put("email", "louisane006@gmail.com");
        User user = UserFactory.createUser(values);
        User newUser = (new User.Builder().username("louisane006").copy(user).password("password2").build());
        Assert.assertEquals("louisane006", newUser.getUsername());
        Assert.assertEquals("password2", newUser.getPassword());
        Assert.assertEquals("louisane006@gmail.com", newUser.getEmail());
    }
}
