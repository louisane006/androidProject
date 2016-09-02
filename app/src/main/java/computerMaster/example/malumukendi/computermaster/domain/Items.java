package computerMaster.example.malumukendi.computermaster.domain;

import java.io.Serializable;

/**
 * Created by Malu.Mukendi on 2016-08-15.
 */
public class Items implements Serializable{
    private Long id;
    private String name;
    private String code;
    private String section;

    public Items() {
    }

    public Items(Builder builder) {
        id = builder.id;
        name = builder.name;
        code = builder.code;
        section = builder.section;
    }
    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getSection() {
        return section;
    }

    public static class Builder{

        private String name;
        private String code;
        private Long id;
        private String section;
        public Builder() {

        }
        //public Builder(String code) {
            //this.code = code;
       // }

        public Builder section(String value){
            this.section = value;
            return this;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder code(String code){
            this.code = code;
            return this;
        }
        public Builder copy(Items i){
            this.name = i.name;
            this.code = i.code;
            this.id = i.id;
            this.section = i.section;
            return this;
        }
        public Items build(){
            return new Items(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items)) return false;
        Items items = (Items) o;

        return !(id != null ? !id.equals(items.id) : items.id != null);
    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                "code=" + code+
                ", name ='" + name + '\'' +
                '}';
    }
}
