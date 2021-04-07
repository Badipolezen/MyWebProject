package lastproject.lastdelivery.services.services;



import lastproject.lastdelivery.data.Order;
import lastproject.lastdelivery.services.models.OrderServiceModel;

import java.util.List;

public interface OrderService {

    void register(OrderServiceModel model) throws Exception;
    boolean isValidOrder(OrderServiceModel orderServiceModel);
    Order findOrderByBarcode(String barcode);
//    Order findById(String id);
    List<OrderServiceModel> getAll();
    void update (OrderServiceModel  updateModel);
    void delete(String barcode);

}
