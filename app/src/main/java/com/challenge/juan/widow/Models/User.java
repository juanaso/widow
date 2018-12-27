package com.challenge.juan.widow.Models;

import java.util.Date;
import java.util.List;

public class User {
    String id;
    String name;
    String lastName;
    Date age;
    List<Book> UploadedBook;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public List<Book> getUploadedBook() {
        return UploadedBook;
    }

    public void setUploadedBook(List<Book> uploadedBook) {
        UploadedBook = uploadedBook;
    }
}
