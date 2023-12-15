package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidAnimalException extends RuntimeException{

    public InvalidAnimalException(String message){
        super(message);
    }

}
