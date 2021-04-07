package lastproject.lastdelivery.web.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackResponceModel {
    private String barcode;
    private String destination;
    private String sendNumber;
    private String receiveNumber;
    private String location;
    private String recipientName;
    private Date createDate;
    private Date updateDate;

}
