/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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

	@Column(length = 14, unique = true, nullable = false)
	private String number;

	@ManyToOne
	@JoinColumn(name = "responsible_person_id_fk",referencedColumnName = "id")
	private ResponsiblePerson responsiblePerson;
//
	
	public ResponsiblePerson getResponsiblePerson() {
		return responsiblePerson;
	}

	public PhoneNumber(String number) {
		this.number = number;
	}
	public PhoneNumber() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
