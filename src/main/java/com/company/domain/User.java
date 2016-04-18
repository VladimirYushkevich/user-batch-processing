package com.company.domain;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isMarked;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getMarked() {
        return isMarked;
    }

    public void setMarked(Boolean marked) {
        isMarked = marked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isMarked=" + isMarked +
                ", email='" + email + '\'' +
                '}';
    }
}
