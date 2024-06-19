package com.customerManagement.CustomerCrud.Exception;

public class ChallengeNotFound extends RuntimeException{

    public ChallengeNotFound(Long id){
        super("Challenge Not Found id:"+" "+id);
    }
}
