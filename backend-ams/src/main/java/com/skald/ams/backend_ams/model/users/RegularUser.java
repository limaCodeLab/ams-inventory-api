package com.skald.ams.backend_ams.model.users;

import lombok.Setter;

public class RegularUser extends User {

    @Setter
    private String firstName;
    @Setter
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

}
