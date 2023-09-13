package com.example.AuthWithBcrypt.repo;

import com.example.AuthWithBcrypt.models.SitePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepo extends JpaRepository <SitePost,Long>{
}
