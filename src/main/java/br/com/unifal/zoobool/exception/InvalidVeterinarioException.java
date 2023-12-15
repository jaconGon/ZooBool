package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidVeterinarioException extends RuntimeException{

    public InvalidVeterinarioException(String message){
        super(message);
    }

}
