package by.grobcore.bancomat_simulator.service.serviceForCard;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;
import by.grobcore.bancomat_simulator.repository.CardRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepo cardRepo;

    @Override
    public List<Card> getCards() {
        return cardRepo.findAll();
    }

    @Override
    public Card getCardByNumber(String cardNumber) {
        return cardRepo.findByNumber(cardNumber);
    }

    @Override
    public Card createCard(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepo.save(card);
    }

    @Override
    @Transactional
    public void deleteCard(String cardNumber) {
        cardRepo.deleteByNumber(cardNumber);
    }

    @Override
    public String getBalance(String cardNumber, String code) {
        Card card = cardRepo.findByNumber(cardNumber);
        if(Objects.equals(code, card.getCode()))
            return "Balance = " + card.getBalance() + "$.";

        return "Incorrect code.";
    }

    @Override
    public String takeMoneyFromCard(String cardNumber, String code, double amount) {
        Card card = cardRepo.findByNumber(cardNumber);
        if (isLegit(cardNumber)) {
            if(Objects.equals(code, card.getCode())) {
                if(card.getBalance() >= amount) {
                    card.setBalance(card.getBalance() - amount);
                    cardRepo.save(card);
                    return "From card " + cardNumber + " was taken " + amount + "$.";
                } else
                    return "Insufficient funds on the card.";
            } else
                return "Incorrect code.";
        }
        return "Card was blocked.";
    }

    @Override
    public String putMoneyOnCard(String cardNumber, String code, double amount) {
        Card card = cardRepo.findByNumber(cardNumber);
        if (isLegit(cardNumber)) {
            if(Objects.equals(code, card.getCode())) {
                card.setBalance(card.getBalance() + amount);
                cardRepo.save(card);
                return "On card " + cardNumber + " was put " + amount + "$.";
            }
            return "Incorrect code.";
        }
        return "Card was blocked.";
    }

    @Override
    public Person getOwner(String number) {
        return cardRepo.getOwner(number);
    }

    @Override
    public Boolean isLegit(String cardNumber) {
        Card card = getCardByNumber(cardNumber);
        return card.getLegitDays() > 0;
    }
}
