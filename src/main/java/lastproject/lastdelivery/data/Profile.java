package lastproject.lastdelivery.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Transient;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile extends BaseEntity {

    @Column
    @Size(max = 32)
    private String zipCode;
    @Column
    @Size(max = 100)
    private String country;
    @Column
    @Size(max = 100)
    private String state;
    @Column
    @Size(max = 50)
    private String city;
    @Column
    @Size(max = 50)
    private String street;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
}
