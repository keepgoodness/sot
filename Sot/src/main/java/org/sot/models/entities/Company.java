package org.sot.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jordan
 */
@Entity(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 15, nullable = false)
	private String bulstat;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private Mrp mrp;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Resipient resipient;
//
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn
//	private Address address;
//
//	@Column(length = 15, nullable = true)
//	private String vat;
//
//	@Column(columnDefinition = "boolean default 0")
//	private boolean vatStatus;

	public Company() {
	}

	public Company(String bulstat) {
		this.bulstat = bulstat;
	}

	public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
    }
	public String getBulstat() {
		return bulstat;
	}

	public void setBulstat(String bulstat) {
		this.bulstat = bulstat;
	}

//	public Mrp getMrp() {
//		return mrp;
//	}
//
//	public void setMrp(Mrp mrp) {
//		this.mrp = mrp;
//	}
//
//	public Resipient getResipient() {
//		return resipient;
//	}
//
//	public void setResipient(Resipient resipient) {
//		this.resipient = resipient;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

}
