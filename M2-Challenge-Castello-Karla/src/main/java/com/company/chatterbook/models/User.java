package com.company.chatterbook.models;

import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private List<ChatterPost> chatterPosts;

    public User(String name) {
        this.name = name;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

    public List<ChatterPost> getChatterPosts() {
        return this.chatterPosts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getChatterPosts(), user.getChatterPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChatterPosts());
    }
}


