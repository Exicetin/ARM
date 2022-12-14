package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import v2.Service.CardService;
import v2.model.request.CreateCardRequest;
import v2.model.response.CardResponse;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {
    private CardService cardService;

    //Получаем весь список пользователей
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CardResponse> findAll() {
        return cardService.findAll();
    }

    //Получаем пользователя по id
    @GetMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
    public CardResponse findById(@PathVariable Integer IdCard) {
        return cardService.findById(IdCard);
    }

    //Создаем пользователя
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CardResponse create(@RequestBody CreateCardRequest request) {
        return cardService.createCard(request);
    }

    //Обновляем пользователя по id
    @PatchMapping(value = "/{IdCard}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CardResponse update(@PathVariable Integer IdCard, @RequestBody CreateCardRequest request) {
        return cardService.update(IdCard, request);
    }

    //Удаляем пользователя по id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer IdCard) {
        cardService.delete(IdCard);
    }
}
