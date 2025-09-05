package uz.developers.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserCompany extends AbstractBaseDomain {
    private Long companyId;
    private Long roleId;
    private List<Long> permissions;

    @ManyToOne
    private User user;
}
