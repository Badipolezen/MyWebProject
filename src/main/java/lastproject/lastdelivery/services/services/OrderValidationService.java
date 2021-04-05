package lastproject.lastdelivery.services.services;

import lastproject.lastdelivery.services.models.OrderServiceModel;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;

public interface OrderValidationService {
    boolean isValidOrder(OrderServiceModel model);
}
