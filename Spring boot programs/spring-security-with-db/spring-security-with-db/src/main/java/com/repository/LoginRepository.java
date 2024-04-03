package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	@Query("select l from Login l where l.username = :username")
	public Optional<Login> findUserByName(@Param("username") String username);
}
