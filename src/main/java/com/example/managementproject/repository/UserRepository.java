package com.example.managementproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.managementproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
