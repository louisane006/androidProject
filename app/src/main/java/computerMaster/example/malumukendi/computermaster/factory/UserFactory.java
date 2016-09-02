package computerMaster.example.malumukendi.computermaster.factory;
import computerMaster.example.malumukendi.computermaster.domain.User;
import java.util.Map;

/**
 * Created by Malu.Mukendi on 2016-06-07.
 */
public class UserFactory {
    public static User createUser(Map<String,String> values)
    {
                return new User.Builder()
                .username(values.get("username"))
                .password(values.get("password"))
                .email(values.get("email"))
                .build();

    }
}