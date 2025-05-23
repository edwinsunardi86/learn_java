package sos.group.integrated.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sos.group.integrated.model.User;
import sos.group.integrated.model.VerificationToken;

public interface TokenRepository extends JpaRepository<VerificationToken, Long>{
    Optional<VerificationToken> findByToken(String token);
    void deleteByUser(User user);
}
