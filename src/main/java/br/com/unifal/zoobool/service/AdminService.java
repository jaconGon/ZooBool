package br.com.unifal.zoobool.service;

import br.com.unifal.zoobool.entity.Admin;
import br.com.unifal.zoobool.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    @Autowired
    private final AdminRepository repository;

    public boolean authenticate(String username, String password){
        if(username != null && password != null){
            Admin admin = repository.findByUsernameAndPassword(username, password);
            return admin != null;
        }
        else{
            throw new IllegalArgumentException("Username and password must not be null.");
        }
    }
}
