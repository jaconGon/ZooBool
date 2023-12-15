package br.com.unifal.zoobool.exception;

public class FuncionarioNotFoundException extends RuntimeException{
    public FuncionarioNotFoundException(String message){
        super(message);
    }
}
