package br.com.unifal.zoobool.repository;

import br.com.unifal.zoobool.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM admin WHERE " +
                    "UPPER(username) = UPPER(:username) " + " AND " + " UPPER(password) = UPPER(:password)"
    )
    Admin findByUsernameAndPassword(String username, String password);
}
