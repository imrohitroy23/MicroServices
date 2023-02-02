package com.example.userHotel.userHotel.Exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(){
        super("Resource Not Found");
    }
    public ResourceNotFound(String message){
        super(message);
    }
}
