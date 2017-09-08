package domain;

import java.io.Serializable;

/**
 * Created by Pamir on 4/22/2015.
 */
public class Customer implements Serializable {
    private int age;
    private String name;

    public Customer(){};

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
