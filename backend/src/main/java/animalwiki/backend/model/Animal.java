package animalwiki.backend.model;

import animalwiki.backend.model.type.Vertebrates;

import java.io.Serializable;

public class Animal implements Serializable {

    @Override
    public boolean equals(Object object)
    {
        if (object == this) {
            return true;
        }

        if (!(object instanceof Animal)) {
            return false;
        }

        Animal animal = (Animal) object;
        return name == animal.name && img == animal.img && desc == animal.desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Vertebrates getType() {
        return type;
    }

    public void setType(Vertebrates type) {
        this.type = type;
    }

    public Boolean getExtinct() {
        return extinct;
    }

    public void setExtinct(Boolean extinct) {
        this.extinct = extinct;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    private String name;
    private String img;
    private Vertebrates type;
    private Boolean extinct;
    private String desc;
}
