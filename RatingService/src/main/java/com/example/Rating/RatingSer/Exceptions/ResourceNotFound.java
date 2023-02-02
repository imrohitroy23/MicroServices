package com.example.Rating.RatingSer.Exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(){
        super("Resource Not Found");
    }
    public ResourceNotFound(String message){
        super(message);
    }
}
