package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // Custom method to find a user by username
}
