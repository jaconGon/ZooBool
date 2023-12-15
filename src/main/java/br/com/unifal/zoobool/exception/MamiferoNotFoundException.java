package br.com.unifal.zoobool.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MamiferoNotFoundException extends RuntimeException {

    public MamiferoNotFoundException(String message){
        super(message);
    }

}
