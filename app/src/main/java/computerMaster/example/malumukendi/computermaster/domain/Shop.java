package computerMaster.example.malumukendi.computermaster.domain;

import java.io.Serializable;

/**
 * Created by Malu.Mukendi on 2016-08-14.
 */

public class Shop implements Serializable {

    private Long id;
    private String name;
    private String address;

    public Shop() {
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }


    public Shop(Builder builder) {
        this.address = builder.address;
       // this.employee = builder.employee;
        this.id = builder.id;
        this.name =  builder.name;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String address;
        //private List<Employee> employee;
        public Builder(String name) {
            this.name = name;
        }

        public Builder() {

        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder address(String value){
            this.address = value;
            return this;
        }
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        //public Builder employee(List<Employee> value){
          //  this.employee = value;
           // return this;
       // }
        public Builder copy(Shop value){
            this.address = value.address;
            //this.employee = value.employee;
            this.id = value.id;
            this.name = value.name;
            return this;
        }
        public Shop build(){
            return new Shop(this);
        }
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id.equals(shop.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return "Shop name =" + name + " Address = " + address + "Section = "+ employee ;
    }*/
}