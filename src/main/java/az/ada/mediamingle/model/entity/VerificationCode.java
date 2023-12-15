package az.ada.mediamingle.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "verification_codes")
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "verification_code_id")
    private User user;
    private String code;
    private LocalDateTime expiresAt;

    public VerificationCode(User user) {
        this.user = user;
        Random random = new Random();
        int value  = random.nextInt(99999 - 10000 + 1) + 10000;
        this.code = String.valueOf(value);
        expiresAt = LocalDateTime.now().plusMinutes(20);
    }
}
