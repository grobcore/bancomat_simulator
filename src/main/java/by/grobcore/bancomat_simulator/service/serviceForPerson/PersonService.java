package by.grobcore.bancomat_simulator.service.serviceForPerson;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();
    Person getPersonsByNumOfPhone(String numOfPhone);
    Person createPerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(String numOfPhone);
    List<Card> getPersonsCards(String numOfPhone);
}
