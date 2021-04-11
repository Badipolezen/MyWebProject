package lastproject.lastdelivery.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Table(name = "orders")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Order extends BaseEntity {

    @Column( nullable = false,unique = true)
    @NotEmpty

    private String barcode;
    @Column(nullable = false)
    @NotEmpty
        private String destination;
    @NotEmpty
    @Column(nullable = false)
        private String sendNumber;
    @NotEmpty
    @Column( nullable = false)
    @NotEmpty
        private String receiveNumber;
    @Column( nullable = false)
    @NotEmpty
        private String location;
    @NotEmpty
    @Column( nullable = false)
        private String recipientName;


    }
