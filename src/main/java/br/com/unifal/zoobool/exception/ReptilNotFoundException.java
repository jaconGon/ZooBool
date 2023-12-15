package br.com.unifal.zoobool.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReptilNotFoundException extends RuntimeException {

    public ReptilNotFoundException(String message){
        super(message);
    }

}
