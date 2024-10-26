package by.grobcore.bancomat_simulator.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Column(unique = true, nullable = false)
    private String numOfPhone;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
