package by.grobcore.bancomat_simulator.repository;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardRepo extends JpaRepository<Card, Long> {
    Card findByNumber(String number);
    void deleteByNumber(String number);
    @Query("select p, c from Person p join Card c on p.numOfPhone = c.numOfOwner and c.number = :number")
    Person getOwner(@Param("number")String number);
}
