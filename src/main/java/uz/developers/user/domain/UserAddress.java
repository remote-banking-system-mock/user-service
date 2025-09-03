package uz.developers.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress extends AbstractBaseDomain {
    private Long regionId;
    private Long districtId;
    private String address;

    @OneToOne
    private User user;
}
