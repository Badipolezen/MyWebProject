package lastproject.lastdelivery.web.view.controlers;


import lastproject.lastdelivery.data.Order;
import lastproject.lastdelivery.repositories.OrdersRepositories;
import lastproject.lastdelivery.services.models.OrderServiceModel;
import lastproject.lastdelivery.services.models.TrackServiceModel;
import lastproject.lastdelivery.services.services.OrderService;
import lastproject.lastdelivery.services.services.TrackService;
import lastproject.lastdelivery.web.view.models.OrderCreateModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrderController {


    private final OrderService orderService;
    private final TrackService trackService;
    private final ModelMapper modelMapper ;
    private final OrdersRepositories ordersRepositories;
    @Autowired
    public OrderController(OrderService orderService, TrackService trackService, ModelMapper modelMapper, OrdersRepositories ordersRepositories) {
        this.orderService = orderService;
        this.trackService = trackService;
        this.modelMapper = modelMapper;

        this.ordersRepositories = ordersRepositories;
    }

    @GetMapping("/all")
    public String allOrder(){
        return "orders/allorders";
    }

    @GetMapping("/track")
    public String trackOrder(){
        return "orders/track-order";
    }



    @GetMapping("/create")
    public String createOrder(){
        return "orders/create-order";
    }

    @PostMapping("/create")
    public String orderConfirm(@ModelAttribute OrderCreateModel createModel) throws Exception {

                OrderServiceModel serviceModel=this.modelMapper.map(createModel, OrderServiceModel.class);
                this.orderService.register(serviceModel);

                return "redirect:/orders/all";}


    @GetMapping("/delete/{barcode}")
    public ModelAndView deleteOrder(@PathVariable String barcode , ModelAndView modelAndView){
            Order order=this.orderService.findOrderByBarcode(barcode);


        modelAndView.addObject("barcode",order.getBarcode());
        modelAndView.setViewName("orders/delete-order.html");

    return modelAndView;
    }

    @PostMapping("/delete/{barcode}")
    public String deleteConfirm(@PathVariable String barcode){


        this.orderService.delete(barcode);

        return "redirect:/orders/all";}




    @GetMapping("/update/{barcode}")
    public ModelAndView forwardOrder(@PathVariable String barcode , ModelAndView modelAndView){
        Order order=this.orderService.findOrderByBarcode(barcode);
        modelAndView.addObject("barcode",order.getBarcode());
        modelAndView.addObject("destination",order.getDestination());
        modelAndView.addObject("sendNumber",order.getSendNumber());
        modelAndView.addObject("receiveNumber",order.getReceiveNumber());
        modelAndView.addObject("recipientName",order.getRecipientName());
        modelAndView.addObject("location",order.getLocation());
        modelAndView.setViewName("orders/update-order.html");

        return modelAndView;
    }


    @PostMapping("/update/{barcode}")


    public String orderUpdate(@PathVariable String barcode,@ModelAttribute OrderCreateModel updateModel)  {
        OrderServiceModel serviceModel=this.modelMapper.map(updateModel, OrderServiceModel.class);
        TrackServiceModel trackServiceModel=this.modelMapper.map(updateModel, TrackServiceModel.class);
        this.trackService.saveTrack(trackServiceModel);
        this.orderService.delete(barcode);
        this.orderService.update(serviceModel);
//
//        Order servicemodel=this.orderService.findOrderByBarcode(barcode);
//            OrderServiceModel serviceModel=this.modelMapper.map(this.orderService.findOrderByBarcode(barcode), OrderServiceModel.class);
//            this.orderService.update(serviceModel);


        return "redirect:/orders/all";}


//    @PostMapping("/create")
//    public String getLoginPage(@RequestParam(required = false) String error, Model model) {
//        if (error != null) {
//            model.addAttribute("error", "Error");
//
//            return  "/create";
//        }
//        return "redirect: /orders/create";
//
//
//    }


//
//    @GetMapping("/details/{barcode}")
//    public String details(@PathVariable String barcode , Model model){
//
//        model.addAttribute("order");
//
//        return "orders/order-details";
//    }

}

