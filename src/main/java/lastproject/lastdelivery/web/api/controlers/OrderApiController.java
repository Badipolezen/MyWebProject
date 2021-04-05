package lastproject.lastdelivery.web.api.controlers;

import lastproject.lastdelivery.repositories.OrdersRepositories;
import lastproject.lastdelivery.services.models.OrderServiceModel;
import lastproject.lastdelivery.services.services.OrderService;
import lastproject.lastdelivery.web.api.models.OrdersResponseModels;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class OrderApiController {
    private final OrderService orderService;
    private  final ModelMapper  modelMapper;

    @Autowired
    public OrderApiController(OrdersRepositories ordersRepositories, OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/all")
    public List<OrdersResponseModels> allOrder() {

   return  orderService.getAll()
           .stream()
           .map(order->this.modelMapper.map(order,OrdersResponseModels.class)).collect(Collectors.toList());





    }



    @GetMapping("/api/update/{barcode}")
                public void forwardOrder(@PathVariable String barcode){
int a=5;
        }

    }


