package computerMaster.example.malumukendi.computermaster.domain;

import java.io.Serializable;
/**
 * Created by Malu.Mukendi on 2016-08-14.
 */
public class Customer implements Serializable {

    private Long id;
    private String custNum;
    private String name;
    private String surname;
    public Customer(){}

    public Customer(Builder b){
        id = b.id;
        name = b.name;
        surname = b.surname;
        custNum = b.custNum;
    }
    public static class Builder{
         Long id;
         String name;
         String surname;
         String custNum;
        public Builder ()
        {

        }
        public Builder custNum(String custNum) {
            this.custNum = custNum;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder identification(Long id){
            this.id = id;
            return this;
        }
        public Builder copy(Customer value){
            this.id = value.id;
            this.custNum= value.custNum;
            this.name=value.name;
            this.surname=value.surname;
            return  this;
        }
        public Customer build(){
            return new Customer(this);
        }
    }
    public String getCustNum() {
        return custNum;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
