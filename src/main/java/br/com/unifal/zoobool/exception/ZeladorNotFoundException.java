package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ZeladorNotFoundException extends RuntimeException {

    public ZeladorNotFoundException(String message){
        super(message);
    }

}