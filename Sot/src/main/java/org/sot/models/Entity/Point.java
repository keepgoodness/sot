package org.sot.models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Jordan
 */
@Entity(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, nullable = true)
    private String identifier;

    @Column(length = 100, nullable = true)
    private String name;

    @OneToOne
	@JoinColumn(name = "address_id")
    private Address address;
	
	@OneToOne
	@JoinColumn(name = "place_id")
	private Place place;
	
//	@OneToOne
//	@MapsId
//	private ControlBoard controlBoard;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
//
//	public ControlBoard getControlBoard() {
//		return controlBoard;
//	}

//	public void setControlBoard(ControlBoard controlBoard) {
//		this.controlBoard = controlBoard;
//	}
}
