package com.webwallet.core.applicationServices.dtos;

public class CreateWalletDTO {
        private String jmbg;
        private String firstName;
        private String lastName;
        private String bankAccount;
        private String bankType;
        private String PIN;


    public CreateWalletDTO(String jmbg, String firstName, String lastName, String bankAccount, String bankType, String PIN) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccount = bankAccount;
        this.bankType = bankType;
        this.PIN = PIN;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
