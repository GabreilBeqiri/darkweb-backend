package com.example.gunz.selected;

public class RegisterSelectedDto {
    public String userEmail;

    public RegisterSelectedDto(String userEmail, int gunId) {
        this.userEmail = userEmail;
        this.gunId = gunId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getGunId() {
        return gunId;
    }

    public void setGunId(int gunId) {
        this.gunId = gunId;
    }

    public int gunId;

}
