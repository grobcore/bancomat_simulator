package by.grobcore.bancomat_simulator.controller;

import by.grobcore.bancomat_simulator.models.Card;
import by.grobcore.bancomat_simulator.models.Person;
import by.grobcore.bancomat_simulator.service.serviceForPerson.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping("/{numOfPhone}")
    public Person getPersonsByNumOfPhone(@PathVariable String numOfPhone) {
        return personService.getPersonsByNumOfPhone(numOfPhone);
    }

    @PostMapping("create_person")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("update_person")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("delete_person")
    public void deletePerson(String numOfPhone) {
        personService.deletePerson(numOfPhone);
    }

    @PostMapping("get_person_cards/{numOfPhone}")
    public List<Card> getPersonsCards(@PathVariable String numOfPhone) {
        return personService.getPersonsCards(numOfPhone);
    }
}
