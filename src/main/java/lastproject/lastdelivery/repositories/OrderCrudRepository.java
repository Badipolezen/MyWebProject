package lastproject.lastdelivery.repositories;

import lastproject.lastdelivery.data.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCrudRepository extends CrudRepository<Order,Long> {
    Order findByBarcode(String barcode);
}
