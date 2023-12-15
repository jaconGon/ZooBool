package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VeterinarioNotFoundException extends RuntimeException {

    public VeterinarioNotFoundException(String message){
        super(message);
    }

}