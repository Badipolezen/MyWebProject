package lastproject.lastdelivery.services.services.Impl;


import lastproject.lastdelivery.data.Order;
import lastproject.lastdelivery.repositories.OrderCrudRepository;
import lastproject.lastdelivery.repositories.OrdersRepositories;
import lastproject.lastdelivery.services.models.OrderServiceModel;
import lastproject.lastdelivery.services.services.OrderService;
import lastproject.lastdelivery.services.services.OrderValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrdersRepositories ordersRepositories ;
    private final OrderCrudRepository orderCrudRepository;
    private final ModelMapper modelMapper;
    private final OrderValidationService orderValidationService;


    @Autowired
    public OrderServiceImpl(OrdersRepositories ordersRepositories, OrderCrudRepository orderCrudRepository, ModelMapper modelMapper, OrderValidationService orderValidationService) {
        this.ordersRepositories = ordersRepositories;
        this.orderCrudRepository = orderCrudRepository;
        this.modelMapper = modelMapper;
        this.orderValidationService = orderValidationService;
    }

    @Override
    public void register(OrderServiceModel model) throws Exception {

        if(!orderValidationService.isValidOrder(model)){
            throw new Exception("This order exist");
        }
        else{
            Order order = this.modelMapper.map(model, Order.class);

        this.ordersRepositories.saveAndFlush(order);
        }

    }

    @Override
    public boolean isValidOrder(OrderServiceModel orderServiceModel) {
        return true;
    }

    @Override
    public Order findOrderByBarcode(String barcode) {
        Order model= ordersRepositories.findByBarcode(barcode);


     return model;

    }

//    @Override
//    public Order findById(String id) {
//        Order model= ordersRepositories.findById(id);
//        return model;
//    }


    @Override
    public List<OrderServiceModel> getAll() {
        return ordersRepositories.findAll()
                .stream()
                .map(ord->modelMapper.map(ord,OrderServiceModel.class)).collect(Collectors.toList());
    }


    @Override
    public void update(OrderServiceModel  updateModel) {
        Order order = this.modelMapper.map(updateModel, Order.class);
        this.ordersRepositories.save(order);


    }


    @Override
    public void delete(String barcode) {

        Order order=this.ordersRepositories.findByBarcode(barcode);
        this.ordersRepositories.delete(order);

    }

//    @Override
//    public void delete(String id) {
//
//        Order order=this.ordersRepositories.findById(id);
//        this.ordersRepositories.delete(order);
//
//    }


}
