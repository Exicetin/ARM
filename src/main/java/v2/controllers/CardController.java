//package v2.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import v2.Service.CardService;
//import v2.domain.CardV2;
//import v2.model.request.CreateCardRequest;
//import v2.model.response.CardResponse;
//import v2.repository.CardRepository;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("resources/templates")
//@RequiredArgsConstructor
//public class CardController {
//
//    private final CardService cardService;
//    private final CardRepository cardRepository;
//
//
////    @GetMapping("/card_list")
////    public ModelAndView openList() {
////        ModelAndView mav = new ModelAndView("cards_list");
////        mav.addObject("listCards", findAll());
////        //WebContext ctx = new WebContext();
////        //ctx.setVariable("cards_list", cardsList);
////        //System.out.println(findAll())
////        return mav;
////    }
//
//    @GetMapping("/card_create")
//    public ModelAndView openEditCards() {
//        ModelAndView mav = new ModelAndView("card_create");
//        CreateCardRequest cr = new CreateCardRequest();
//        mav.addObject("card_create", cr);
//        return mav;
//    }
//
//    @GetMapping("card_edit/{idCards}")
//    public ModelAndView openEditWithId(/*@RequestParam*/@PathVariable Integer idCards) {
//        ModelAndView mav = new ModelAndView("card_edit");
//        CreateCardRequest cr = new CreateCardRequest();
//        mav.addObject("cardsKorr", cardService.findById(idCards));
//        return mav;
//    }
//
//    @RequestMapping( value ="/new_card", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
//    public String createCard(/*@ModelAttribute*/ CreateCardRequest request){
//        ModelAndView mav = new ModelAndView("card_create");
//        CardResponse cardResponse =  cardService.createCard(request);
//        return "redirect:card_list";
//    }
//
//    @PostMapping( "/card_edit/save_card_change/{idCards}")
//    public String updateCard(CreateCardRequest request, @PathVariable Integer idCards) {
//        ModelAndView mav = new ModelAndView("card_edit");
//        //System.out.println(request);
//        CardResponse cardResponse = cardService.update(idCards,request);
//        return "redirect:../../card_view/"+idCards;
//    }
//
////    @GetMapping("/page_not_found")
////    public ModelAndView openPage404() {
////        ModelAndView mav = new ModelAndView("page_not_found");
////        return mav;
////    }
//
//    @GetMapping("/card_view/{idCards}")
//    public ModelAndView openCardView(/*@RequestParam*/@PathVariable Integer idCards) {
//        ModelAndView mav = new ModelAndView("card_view");
//        mav.addObject("cardView",cardService.findById(idCards));
//        return mav;
//    }
//
//
////    @PostMapping( value ="save_card_change")
////    public String updateCard(/*@ModelAttribute*/ CreateCardRequest request, Integer idCards) {
////        ModelAndView mav = new ModelAndView("card_edit");
////        //CardResponse cardResponse = cardService.findById(idCards);
//////        mav.addObject("cardsKorr", request);
////        System.out.println(request);
////        CardResponse cardResponse = cardService.update(idCards,request);
////        System.out.println(request);
////        return "redirect:card_list";
////    }
//
//
//    public List<CardResponse> findAll() {
//        return cardService.findAll();
//    }
//
//    //Получаем весь список карточек
////    @GetMapping(produces = APPLICATION_JSON_VALUE)
////    public List<CardResponse> findAll() {
////        return cardService.findAll();
////    }
//
////    @GetMapping("/card_view")
////    public ModelAndView openCardView() {
////        ModelAndView mav = new ModelAndView("card_view");
////        mav.addObject("listCards", findById());
////        //       WebContext ctx = new WebContext();
//////        ctx.setVariable("cards_list", cardsList);
////        System.out.println(findById());
////        return mav;
////    }
//
//
//
//   // @RequestMapping( value ="card_view", method = {RequestMethod.GET, RequestMethod.PUT}, consumes = MediaType.ALL_VALUE)
//
//
////@GetMapping("/card_list")
////  public String openList(Model model) {
////    model.addAttribute("cardsList", findAll());
////    return "cards_list";
////    }
//
// //   @GetMapping("/card_edit")
// //   public ModelAndView openEditCards() {
//  //      ModelAndView mav = new ModelAndView("card_create");
//  //      CreateCardRequest cr = new CreateCardRequest();
//  //      mav.addObject("card_create", cr);
//  //      return mav;
//  // }
//
//
//    ////    //Создаем карту
////    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
////    public CardResponse create(@RequestBody CreateCardRequest request) {
////        return cardService.createCard(request);
////    }
//
//    //Обработка открытия карточки из card_list
////    @GetMapping("/open_card")
////    public String openViewCard(){
////        cardService.findById();  //ЧТО ПЕРЕДАЕТСЯ?
////        return"card_view";
////    }
//
//
//
//
////    @RequestMapping(value = "/new_card", method = RequestMethod.POST)
////    public String createUser(Model model, @ModelAttribute CreateCardRequest card_edit) {
////        System.out.println("Я работаю");
////        @NotNull CreateCardRequest cr = cardService.createCard(card_edit);
////        return "redirect:/card_list";
////    }
//
////
////
////////    //Обновляем карту по id
////    @PatchMapping(value = "/{IdCard}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
////   public CardResponse update(@PathVariable Integer IdCard, @RequestBody CreateCardRequest request) {
////        return cardService.update(IdCard, request);
////    }
//
////    @RequestMapping( value ="korr_view", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
////    public String korr(/*@RequestBody*/ CreateCardRequest request,/*@RequestParam*/@PathVariable  Integer idCards){
////        System.out.println(request);
////    cardService.update(idCards,request);
////    return "redirect:card_view/{idCards}";
////}
//
//
//
//
////////    //Удаляем карту по id
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    @DeleteMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
////    public void delete(@PathVariable Integer IdCard) {
////        cardService.delete(IdCard);
////    }
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    @DeleteMapping(value = "/{idCard}")
////    public String delete(@RequestParam int idCards) {
////        cardService.delete(idCards);
////        return "redirect:/card_list";
////    }
//    public ModelAndView search(@RequestParam String keyword) {
//        List<CardV2> result = cardService.search(keyword);
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("result", result);
//        return mav;
//    }
////    @GetMapping("/card_list")
////    public String openList(Mode0 l model) {
////        model.addAttribute("cardList", cardService.findAll());
////        return "card_list";
////    }
////    @GetMapping("/edit")
////    public String openEditCards(){
////        return "cards_edit";
////    }
//
////      @GetMapping("open_order_list")
////    public ModelAndView openOrderList() {
////          ModelAndView ol = new ModelAndView("orders_list");
////          return ol;
////    }
//
//    @GetMapping("dashboard")
//    public ModelAndView openDashboard() {
//        ModelAndView dash = new ModelAndView("dashboard");
//        return dash;
//    }
//
//}
