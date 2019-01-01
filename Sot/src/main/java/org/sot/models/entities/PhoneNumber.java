package org.sot.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 14, unique = true, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "responsible_person_id", referencedColumnName = "id")
    @JsonIgnore
    private ResponsiblePerson responsiblePerson;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ResponsiblePerson getResponsiblePerson() {
        return responsiblePerson;
    }
}
