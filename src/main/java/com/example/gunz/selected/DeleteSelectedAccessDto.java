package com.example.gunz.selected;

public class DeleteSelectedAccessDto {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DeleteSelectedAccessDto(String message){
        this.message = message;
    }
    public DeleteSelectedAccessDto(){
        this.message = "caaaaaaaaa";
    }
}
