package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidTratadorException extends RuntimeException{

    public InvalidTratadorException(String message){
        super(message);
    }

}
