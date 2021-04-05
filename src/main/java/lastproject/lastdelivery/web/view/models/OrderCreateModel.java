package lastproject.lastdelivery.web.view.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateModel {

    private String barcode;
    private String destination;
    private String sendNumber;
    private String receiveNumber;
    private String location;
    private String recipientName;
}
