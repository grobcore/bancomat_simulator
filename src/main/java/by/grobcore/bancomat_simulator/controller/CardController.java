package by.grobcore.bancomat_simulator.controller;

import by.grobcore.bancomat_simulator.models.Card;
//import by.grobcore.bancomat_simulator.models.Person;
import by.grobcore.bancomat_simulator.models.Person;
import by.grobcore.bancomat_simulator.service.serviceForCard.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cards")
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @PostMapping("/{cardNumber}")
    public Card getCardByNumber(@PathVariable String cardNumber) {
        return cardService.getCardByNumber(cardNumber);
    }

    @PostMapping("create_card")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("update_card")
    public Card updateCard(@RequestBody Card card) {
        return cardService.updateCard(card);
    }

    @DeleteMapping("delete_card/{cardNumber}")
    public void deleteCard(@PathVariable String cardNumber) {
        cardService.deleteCard(cardNumber);
    }

    @PostMapping("get_balance/{cardNumber}/{code}")
    public String getBalance (@PathVariable String cardNumber, @PathVariable String code) {
        return cardService.getBalance(cardNumber, code);
    }

    @PostMapping("take_money/{cardNumber}/{code}/{amount}")
    public String takeMoneyFromCard (@PathVariable String cardNumber, @PathVariable String code, @PathVariable double amount) {
        return cardService.takeMoneyFromCard(cardNumber, code, amount);
    }

    @PostMapping("put_money/{cardNumber}/{code}/{amount}")
    public String putMoneyOnCard (@PathVariable String cardNumber, @PathVariable String code, @PathVariable double amount) {
        return cardService.putMoneyOnCard(cardNumber, code, amount);
    }

    @PostMapping("get_owner/{cardNumber}")
    public Person getOwner (@PathVariable String cardNumber) {
        return cardService.getOwner(cardNumber);
    }

    @PostMapping("is_legit/{cardNumber}")
    public Boolean isLegit (@PathVariable String cardNumber) {
        return cardService.isLegit(cardNumber);
    }

}
