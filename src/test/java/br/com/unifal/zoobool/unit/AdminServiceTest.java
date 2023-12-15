package br.com.unifal.zoobool.unit;

import br.com.unifal.zoobool.entity.Admin;
import br.com.unifal.zoobool.repository.AdminRepository;
import br.com.unifal.zoobool.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class AdminServiceTest {

    @InjectMocks
    private AdminService service;

    @Mock
    private AdminRepository repository;

    @Test
    public void testAuthenticateWithValidCredentials() {
        String username = "admin";
        String password = "password";
        Admin admin = new Admin(1,"jacon","jacon", "mavi");

        when(repository.findByUsernameAndPassword(username, password)).thenReturn(admin);

        boolean result = service.authenticate(username, password);


        assertTrue(result);


        verify(repository, times(1)).findByUsernameAndPassword(username, password);
    }

    @Test
    public void testAuthenticateWithInvalidCredentials() {
        String username = "admin";
        String password = "wrongpassword";


        when(repository.findByUsernameAndPassword(username, password)).thenReturn(null);


        boolean result = service.authenticate(username, password);


        assertFalse(result);


        verify(repository, times(1)).findByUsernameAndPassword(username, password);
    }

    @Test
    public void testAuthenticateWithNullCredentials() {

        assertThrows(IllegalArgumentException.class, () -> service.authenticate(null, null));


        verify(repository, never()).findByUsernameAndPassword(any(), any());
    }
}

