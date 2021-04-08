package lastproject.lastdelivery.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Table(name = "tracks")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Track extends BaseEntity{
    @Column( nullable = false)
    private String barcode;
    private String destination;

    private String sendNumber;

    private String receiveNumber;

    private String location;

    private String recipientName;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updateDate;

}
