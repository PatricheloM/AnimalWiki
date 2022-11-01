package animalwiki.backend.model;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String name;
    private String img;
    private String desc;
}
