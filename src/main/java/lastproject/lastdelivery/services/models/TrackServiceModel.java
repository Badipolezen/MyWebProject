package lastproject.lastdelivery.services.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TrackServiceModel {

        private String barcode;
        private String destination;
        private String sendNumber;
        private String receiveNumber;
        private String location;
        private String recipientName;
        private Date createDate;
        private Date updateDate;
          }

