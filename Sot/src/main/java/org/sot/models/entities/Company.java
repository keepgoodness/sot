package org.sot.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Jordan
 */
@Entity(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 15, nullable = true)
	private String bulstat;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn
	private ResponsiblePerson responsiblePerson;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private ResponsiblePerson recipientPerson;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn
	private Address address;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
