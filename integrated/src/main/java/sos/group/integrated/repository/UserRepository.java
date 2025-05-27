package sos.group.integrated.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sos.group.integrated.model.User;

@Repository
public interface  UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
