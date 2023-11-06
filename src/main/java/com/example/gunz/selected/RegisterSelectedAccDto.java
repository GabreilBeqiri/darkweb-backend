package com.example.gunz.selected;

public class RegisterSelectedAccDto {
    public String userEmail;

    public RegisterSelectedAccDto(String userEmail, int accId) {
        this.userEmail = userEmail;
        this.accId = accId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int gunId) {
        this.accId = accId;
    }

    public int accId;

}
