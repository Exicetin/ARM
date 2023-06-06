package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.CardService;
import v2.Service.OrderService;
import v2.domain.Orders;
import v2.model.request.CreateOrderRequest;
import v2.model.response.OrderResponse;
import v2.repository.OrderRepository;

import java.util.List;
//import v2.Service.SystemService;
//import v2.Service.UserService;
//import v2.model.request.CreateUserRequest;

@Controller
@RequestMapping("/templates")
@RequiredArgsConstructor
public class MenuController {
    private final OrderService orderService;
    private final CardService cardService;

    @GetMapping("/card_list")
    public ModelAndView openCardList() {
        ModelAndView mav = new ModelAndView("cards_list");
        mav.addObject("listCards", cardService.findAll());
        return mav;
    }

    @GetMapping("/test_orders")
    public ModelAndView openTestOrdersList() {
        ModelAndView mav = new ModelAndView("test_orders");
        mav.addObject("ordersList");
        return mav;
    }

    @GetMapping("/order_list")
    public ModelAndView openOrderList() {
        ModelAndView mav = new ModelAndView("orders_list");
        mav.addObject("listOrders", orderService.findAll());
        return mav;
    }

//    public List<Orders> findByTemplate(Boolean template){
//        OrderRepository orderRepository = null;
//        List <Orders> orders = orderRepository.findByTemplate(template);
//        return orders;
//    }

    @GetMapping("/templates_list")
    @ResponseBody
    public ModelAndView openTemplatesList(@RequestParam(defaultValue = "true",required=false) Boolean template) {
        ModelAndView mav = new ModelAndView("templates_list");
//        Boolean templateBoolean = template;
        System.out.println(template);
        CreateOrderRequest co = new CreateOrderRequest();
        mav.addObject("listTemplates", orderService.findByTemplate(template));
        return mav;
    }

    public List<Orders> findTemplate(Boolean template){
        OrderRepository orderRepository = null;
        List <Orders> orders = orderRepository.findByTemplate(template);
        return orders;
    }

//    @GetMapping("/user_list")
//    public ModelAndView openUserList(){
//        ModelAndView mav = new ModelAndView("user_list");
//        mav.addObject("users", userService.findAll());
//        System.out.println("user list");
//        return mav;
//    }

    @GetMapping("/page_with_errors")
    public ModelAndView openErrorPage() {
        ModelAndView mav = new ModelAndView("page_with_errors");
        return mav;

    }

}
