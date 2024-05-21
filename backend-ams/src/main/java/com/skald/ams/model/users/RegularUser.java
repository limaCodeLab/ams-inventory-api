package com.skald.ams.model.users;

public class RegularUser extends User {

    private String firstName;
    private String lastName;
    private String cpf;

    public RegularUser() {
    }

    public RegularUser(Long id, String email, String password, String phone, String address, String city, String state, String zipcode, String firstName, String lastName, String cpf) {
        super(id, email, password, phone, address, city, state, zipcode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
