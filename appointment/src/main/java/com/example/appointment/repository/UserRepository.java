package com.example.appointment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.appointment.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("from User where email=:email")
	Optional<User> getUserByEmail(@Param("email")String email);
}
