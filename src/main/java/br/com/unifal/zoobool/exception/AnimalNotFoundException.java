package br.com.unifal.zoobool.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException(String message){
        super(message);
    }

}
