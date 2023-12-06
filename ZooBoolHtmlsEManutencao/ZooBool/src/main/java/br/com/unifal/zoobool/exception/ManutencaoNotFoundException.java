package br.com.unifal.zoobool.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ManutencaoNotFoundException extends RuntimeException {

    public ManutencaoNotFoundException(String message){
        super(message);
    }

}
