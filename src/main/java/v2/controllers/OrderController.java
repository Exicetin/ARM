package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import v2.Service.OrderService;
//import v2.Service.SystemService;
import v2.Service.SystemService;
import v2.domain.Orders;
import v2.logic.LinkDeveloper;
import v2.logic.NextOrderNumber;
import v2.model.request.CreateOrderRequest;
import v2.model.response.OrderResponse;
import v2.repository.OrderRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/templates")
@RequiredArgsConstructor
public class OrderController {

    private final SystemService systemService;
    private final OrderService orderService;

    @GetMapping("/order_view/{idOrders}")
    public ModelAndView openOrderView(/*@RequestParam*/@PathVariable Integer idOrders) {
        ModelAndView mav = new ModelAndView("order_view");

        mav.addObject("orderView",orderService.findById(idOrders));
        return mav;
    }



    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }

    private Date dateNow() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = format.format(date);
        Date newdate = format.parse(strDate);
        return newdate;
    }

    @RequestMapping( value ="order_view", method = {RequestMethod.GET, RequestMethod.PUT}, consumes = MediaType.ALL_VALUE)
    public ModelAndView findById(@RequestParam Integer idOrder){
        ModelAndView mav = new ModelAndView("order_view");
        OrderResponse orderResponse = orderService.findById(idOrder);
        mav.addObject("orders",orderResponse);
        return mav;
    }

    @GetMapping("/order_create")
    public ModelAndView openCreateOrder() {
        ModelAndView mav = new ModelAndView("order_create");
        CreateOrderRequest cr = new CreateOrderRequest();
        mav.addObject("order_create", cr);
        mav.addObject("systemList", systemService.findAll());
        return mav;
    }

    public String linkDeveloper(String number,String system) {
        LinkDeveloper linkDeveloper = new LinkDeveloper();
        return linkDeveloper.linkDeveloper(number,system);
    }

    @RequestMapping( value ="/new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
    public String createOrder(/*@ModelAttribute*/@RequestParam(name = "template", required = false) boolean template, CreateOrderRequest request) throws ParseException {
        ModelAndView mav = new ModelAndView("order_create");
        System.out.println(template);
        boolean temp = true;
        if (template){
            request.setTemplate(Boolean.valueOf("true"));
            System.out.println("TRUE");
        } else {
            request.setTemplate(Boolean.valueOf("false"));
            System.out.println("FALSE");
        }
        String sys = request.getSystems();
        String number = nextOrderNumber(sys);
        String linksAssembly = linkDeveloper(Integer.toString(request.getAssemblyNumber()),request.getSystems());
        request.setAssemblyLink(linksAssembly);
        System.out.println(number);
        request.setNumber(number);
        request.setAssemblyLink(linksAssembly);
        request.setDateInstallProd(null);
        request.setDateInstallTest(null);
        request.setStopSystem(2);
        request.setDateCreate(java.sql.Date.valueOf(LocalDate.now()));
        OrderResponse orderResponse =  orderService.create(request);
        return "redirect:order_list";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{idOrder}")
    public String delete(@RequestParam int idOrder) {
        orderService.delete(idOrder);
        return "redirect:/order_list";
    }
    public ModelAndView search(@RequestParam String keyword) {
        List<Orders> result = orderService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }

    //Для получения следующего номера Наряда на вход нужно передать Систему в строковом формате
    public String nextOrderNumber(String sys) {
        NextOrderNumber nextOrderNumber = new NextOrderNumber(orderService);
        return nextOrderNumber.nextOrderNumber(sys);
    }

    @GetMapping("order_edit/{idOrders}")
    public ModelAndView openEditWithId(/*@RequestParam*/@PathVariable Integer idOrders) {
        ModelAndView mav = new ModelAndView("order_edit");
        CreateOrderRequest co = new CreateOrderRequest();
        mav.addObject("orderKorr", orderService.findById(idOrders));
        return mav;
    }

    @PostMapping("/order_edit/save_order_change/{idOrder}")
    public String updateOrder(CreateOrderRequest request, @PathVariable Integer idOrder){
        ModelAndView mav = new ModelAndView("order_edit");
        System.out.println(idOrder);
        OrderResponse orderResponse = orderService.update(idOrder, request);
        return "redirect:../../order_view/"+idOrder;
    }
    @GetMapping("order_edit_template/{idOrders}")
    public ModelAndView openEditWithTemplate(/*@RequestParam*/@PathVariable Integer idOrders) {
        ModelAndView mav = new ModelAndView("order_edit_template");
        CreateOrderRequest co = new CreateOrderRequest();
        mav.addObject("orderTemplate", orderService.findById(idOrders));
        mav.addObject("systemList", systemService.findAll());
        return mav;
    }

    @RequestMapping("/order_edit_template/create_order_with_template")
    public String createOrderWithTemplate(CreateOrderRequest request){
        request.setIdOrder(null);
        request.setNumber(nextOrderNumber(request.getSystems()));
        OrderResponse orderResponse = orderService.create(request);
        return "redirect:../order_list";
    }
}