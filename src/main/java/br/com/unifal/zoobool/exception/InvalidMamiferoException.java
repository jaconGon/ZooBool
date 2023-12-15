package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidMamiferoException extends RuntimeException{

    public InvalidMamiferoException(String message){
        super(message);
    }

}
