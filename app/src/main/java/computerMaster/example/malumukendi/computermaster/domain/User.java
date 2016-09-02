package computerMaster.example.malumukendi.computermaster.domain;

import java.io.Serializable;

/**
 * Created by Malu.Mukendi on 2016-06-07.
 */
public class User implements Serializable {

    private Long id;
    private String username;
    private String email;
    private  String password;
    public User(){}

    private User(Builder b){
        id = b.id;
        username = b.username;
        password = b.password;
        email = b.email;
    }
    public static class Builder{
        private Long id;
        private String username;
        private String password;
        private String email;

        public Builder identification(Long id) {
            this.id= id;
            return this;
        }
        public Builder(String username){
            this.username = username;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder email(String email){
            this.email= email;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder() {
        }
        public Builder user(User user){
            id= user.id;
            email = user.getEmail();
            password = user.getPassword();
            return this;
        }

        public User build(){
            return new User(this);
        }

        public Builder copy(User user) {
            id = user.id;
            username = user.username;
            password = user.password;
            email = user.email;
            return this;
        }
    }
    public Long getIdentification() {return id;}
    public String getUsername(){ return username;}
    public String getPassword(){ return password; }
    public String getEmail() {return email;}
}
