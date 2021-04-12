package lastproject.lastdelivery.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {


    @Column(nullable = false,unique = true)

    private String username;

    @Column(nullable = false)

    private String firstName;

    @Column(nullable = false)

    private String lastName;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Role> authorities;

//    public User() {
//        authorities = new HashSet<>();
//    }

    public User() {
        this.authorities=authorities ;
    }


    @Column
    @Transient
    public boolean isAccountNonExpired(){
        return true;
    };

    @Column
    public boolean isAccountNonLocked(){
        return true;
    };
    @Column
    public boolean isCredentialsNonExpired(){
        return true;
    };
    @Column
    public boolean isEnabled(){
        return true;
    };

}