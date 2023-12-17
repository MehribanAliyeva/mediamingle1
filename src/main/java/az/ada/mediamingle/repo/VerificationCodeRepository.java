package az.ada.mediamingle.repo;

import az.ada.mediamingle.model.entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode,Long> {
    public Optional<VerificationCode> findByCode(String code);
}
