package com.lilium.redis.dto;

// in order to store these details in redis, it needs to be serialised so lets create interface

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private String id;
    private String name;
    private int age;
//getter and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
