package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidReptilException extends RuntimeException{

    public InvalidReptilException(String message){
        super(message);
    }

}
