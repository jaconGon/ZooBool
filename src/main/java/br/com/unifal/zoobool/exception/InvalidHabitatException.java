package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidHabitatException extends RuntimeException{

    public InvalidHabitatException(String message){
        super(message);
    }

}
