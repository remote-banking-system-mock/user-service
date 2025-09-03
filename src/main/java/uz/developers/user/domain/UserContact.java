package uz.developers.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import uz.developers.user.domain.enumuration.UserContactStatus;
import uz.developers.user.domain.enumuration.UserContactType;

@Getter
@Setter
@Builder
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserContact extends AbstractBaseDomain {
    private String contact;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private UserContactType type;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private UserContactStatus status;

    @ManyToOne
    private User user;
}
