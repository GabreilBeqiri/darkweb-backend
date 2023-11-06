package com.example.gunz.user.dto;

public class DeleteUserDto {

    String message;

    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public DeleteUserDto(String message){
        this.message = message;
    }
    public DeleteUserDto(){
        this.message = "adsfsdfd";
    }

}
