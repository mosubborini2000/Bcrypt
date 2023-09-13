package com.example.AuthWithBcrypt.repo;

import com.example.AuthWithBcrypt.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<SiteUser,Long> {
    SiteUser findByUserName(String userName);
}
