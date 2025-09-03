package uz.developers.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import uz.developers.user.domain.enumuration.UserStatus;

@Getter
@Setter
@Builder
@ToString
@Entity(name = "\"user\"")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractBaseDomain {
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private UserStatus status;
}
