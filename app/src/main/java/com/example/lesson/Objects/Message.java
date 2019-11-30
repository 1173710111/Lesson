package com.example.lesson.Objects;

public class Message {
    private String addresser;
    private String message;

    public Message() {
    }

    public Message(String addresser,String message) {
        this.addresser = addresser;
        this.message = message;
    }

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
