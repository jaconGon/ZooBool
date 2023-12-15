package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidManutencaoException extends RuntimeException{

    public InvalidManutencaoException(String message){
        super(message);
    }

}
