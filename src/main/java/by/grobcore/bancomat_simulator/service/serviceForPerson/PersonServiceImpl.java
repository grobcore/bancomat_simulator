package by.grobcore.bancomat_simulator.service.serviceForPerson;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;
import by.grobcore.bancomat_simulator.repository.PersonRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;

    @Override
    public List<Person> getPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person getPersonsByNumOfPhone(String numOfPhone) {
        return personRepo.getPersonsByNumOfPhone(numOfPhone);
    }

    @Override
    public Person createPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(String numOfPhone) {
        personRepo.deletePersonByNumOfPhone(numOfPhone);
    }

    @Override
    public List<Card> getPersonsCards(String number) {
        //return null;
        return personRepo.getPersonsCardsByNumOfPhone(number);
    }
}
