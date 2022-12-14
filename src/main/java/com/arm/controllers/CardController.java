package com.arm.controllers;


import com.arm.service.CardsService;
import com.arm.tables.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class CardController {
//CardsFind.
//    @GetMapping("/card_view")
//    @RequestMapping(method = RequestMethod.GET)
//    public String printCard(ModelMap model) {
//        model.addAttribute("message", );
//        return "card_view";
//    }
    //Здесь тебе нужно глянуть мой пример кода в jsp и вписать потом правильные attributeName пример опять таки есть в search ниже в файле
@Autowired
private CardsService cardsService;
@RequestMapping("/")//по идее сюда обычно начальную странку пихают скорее всего сюда cardlist
public ModelAndView cards() {
    List<Cards> cardsList = cardsService.listAll();
    ModelAndView mav = new ModelAndView("card_list");
    mav.addObject("listCards", cardsList);
    return mav;
}
    @RequestMapping("/edit")
    public String newCustomerForm(Map<String, Object> model) {
        Cards cards = new Cards();
        model.put("cards", cards);
        return "cards_edit";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Cards cards) {
        cardsService.save(cards);
        return "redirect:/";//перекид на card_list
    }
    @RequestMapping("/korr")
    public ModelAndView editCustomerForm(@RequestParam int idCards) {
        ModelAndView mav = new ModelAndView("cards_list");
        Cards cards = cardsService.get(idCards);
        mav.addObject("cards", cards);
        return mav;
    }
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam int idCards) {
        cardsService.delete(idCards);
        return "redirect:/";
    }
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Cards> result = cardsService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }
//
// Пример из jsp хз как в тимьяне
//card_list
// <tr>
//            <th>ID</th>
//            <th>Name</th>
//            <th>E-mail</th>
//            <th>Action</th>
//        </tr>
//        <c:forEach items="${listCards}" var="cards">
//        <tr>
//    <td>${cards.id}</td>
//    <td>${cards.name}</td>
//
//
//            <td>
//                <a href="/edit?id=${cards.id}">Korr</a>
//
//                <a href="/delete?id=${cards.id}">Delete</a>
//            </td>




 //  вот так в jsp я б написал search
//    <div align="center">
//    <h2>Search Result</h2>
//    <table border="1" cellpadding="5">
//        <tr>
//            <th>ID</th>
//            <th>Name</th>
//
//
//        </tr>
//        <c:forEach items="${result}" var="cards">
//        <tr>
//    <td>${cards.id}</td>
//    <td>${cards.name}</td>
//
//
//        </tr>
//        </c:forEach>
    //ID
    //C_NUM_CARD
    //C_OTV
    //C_SYSTEM
    //C_DATE_CREATE
    //C_DATE_KORR
    //C_STATYS
    //C_LETTER
    //C_ORDER_LIST

    //card_edit
    //C_SAVE_CARD
    //C_UNDO_CHANGE

    //card_view
    //C_CHANGES_CARD (корректировать)
    //C_CLOSE (возврат к списку карточек)

    //action

    //card_edit
    //c_save_card
    //c_undo_change

    //card_view
    //adjust (корректировать)
    //card_list (возврат к списку карточек)

    //card_list
    //excel_export
    //create_card
    //card_responsible (ответственный)
    //date_create
    //card_num
    //card_status
    //date_adjust
    //id_card
}
