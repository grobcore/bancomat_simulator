package by.grobcore.bancomat_simulator.repository;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person getPersonsByNumOfPhone(String numOfPhone);
    void deletePersonByNumOfPhone(String numOfPhone);
    @Query("select c from Card c where c.numOfOwner = :numOfPhone")
    List<Card> getPersonsCardsByNumOfPhone(@Param("numOfPhone") String numOfPhone);
}
