package lastproject.lastdelivery.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "orders")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Order extends BaseEntity {

    @Column( nullable = false,unique = true)
    private String barcode;

    @Column(nullable = false)
        private String destination;
    @Column(nullable = false)
        private String sendNumber;
    @Column( nullable = false)
        private String receiveNumber;
    @Column( nullable = false)

        private String location;
    @Column( nullable = false,updatable = true)
        private String recipientName;


    }
