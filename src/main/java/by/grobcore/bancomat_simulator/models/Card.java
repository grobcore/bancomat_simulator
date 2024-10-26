package by.grobcore.bancomat_simulator.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true, nullable = false)
    private String number;
    private String cvv;
    private String code;
    private double balance;
    private LocalDate dateOfLegit;
    @Column(nullable = false)
    private String numOfOwner;
    @Transient
    private long legitDays;

    public long getLegitDays() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dateOfLegit);
    }

    public void getPerson(Person person) {
        person.getFirstName();
    }
}
