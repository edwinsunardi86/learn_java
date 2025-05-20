package sos.group.integrated.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sos.group.integrated.model.User;

public interface  UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
