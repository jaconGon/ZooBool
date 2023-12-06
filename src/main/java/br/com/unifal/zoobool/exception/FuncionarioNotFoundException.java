package br.com.unifal.zoobool.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FuncionarioNotFoundException extends RuntimeException{
    public FuncionarioNotFoundException(String message){
        super(message);
    }
}
