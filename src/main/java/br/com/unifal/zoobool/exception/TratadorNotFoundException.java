package br.com.unifal.zoobool.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TratadorNotFoundException extends RuntimeException {

    public TratadorNotFoundException(String message){
        super(message);
    }

}
