package by.grobcore.bancomat_simulator.service.serviceForCard;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;
//import by.grobcore.bancomat_simulator.models.Person;

import java.util.List;

public interface CardService {
    List<Card> getCards();
    Card getCardByNumber(String cardNumber);
    Card createCard(Card card);
    Card updateCard(Card card);
    void deleteCard(String cardNumber);
    String getBalance(String cardNumber, String code);
    String takeMoneyFromCard(String cardNumber, String code, double amount);
    String putMoneyOnCard(String cardNumber, String code, double amount);
    Person getOwner(String cardNumber);
    Boolean isLegit(String cardNumber);
}
