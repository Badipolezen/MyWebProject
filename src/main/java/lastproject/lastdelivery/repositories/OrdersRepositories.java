package lastproject.lastdelivery.repositories;


import lastproject.lastdelivery.data.Order;
import lastproject.lastdelivery.services.models.OrderServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepositories extends JpaRepository<Order,Long> {

  Order findByBarcode(String barcode);
   boolean existsByBarcode( String barcode);
   boolean existsById(String id);



}
