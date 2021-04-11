package lastproject.lastdelivery.services.services.Impl;

import lastproject.lastdelivery.repositories.OrdersRepositories;
import lastproject.lastdelivery.services.models.OrderServiceModel;
import lastproject.lastdelivery.services.services.OrderValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderValidationServiceImpl implements OrderValidationService {


    private final OrdersRepositories ordersRepositories;

    @Autowired
    public OrderValidationServiceImpl(OrdersRepositories ordersRepositories) {
        this.ordersRepositories = ordersRepositories;
    }

    @Override
    public boolean isValidOrder(OrderServiceModel order) {
        return this.isBarcodeFree(order.getBarcode());
    }

    private boolean isBarcodeFree(String barcode) {
        return !ordersRepositories.existsByBarcode(barcode);
    }

}
