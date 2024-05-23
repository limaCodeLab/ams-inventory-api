package com.skald.ams.backend_ams.model.users;

import lombok.Setter;

public class CompanyUser extends User {

    @Setter
    private String companyName;
    private String cnpj;

    public CompanyUser() {
    }

    public CompanyUser(Long id, String email, String password, String phone, String address, String city, String state, String zipcode, String companyName, String cnpj) {
        super(id, email, password, phone, address, city, state, zipcode);
        this.companyName = companyName;
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

}
