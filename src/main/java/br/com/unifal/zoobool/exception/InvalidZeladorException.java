package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidZeladorException extends RuntimeException{

    public InvalidZeladorException(String message){
        super(message);
    }

}