package org.sot.models.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.sot.enums.SseStatus;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, unique = true)
    private String identifier;

    @Column(length = 100, unique = true)
    private String name;

    @Column
    private Double lat;

    @Column
    private Double lng;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "boolean", length = 1)
    private SseStatus sseStatus;

    @Column(columnDefinition = "boolean", length = 1, nullable = false)
    private boolean hasSot;

    @Column(columnDefinition = "boolean", length = 1, nullable = false)
    private boolean hasVideo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                @JoinColumn(name = "point_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "responsible_person_id")})
    private List<ResponsiblePerson> responsiblePersons = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "points_sensors",
            joinColumns = { @JoinColumn(name = "point_id") },
            inverseJoinColumns = { @JoinColumn(name = "sensor_id", columnDefinition = "bigint default 0") })
    private List<Sensor> sensors = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "points_controlboards",
			joinColumns = { @JoinColumn(name = "point_id") },
			inverseJoinColumns = { @JoinColumn(name = "controlboard_id", columnDefinition = "bigint default 0") } )
	private List<ControlBoard> controlBoards = new ArrayList<>();

    public Point() {
    }

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public SseStatus getSseStatus() {
        return sseStatus;
    }

    public void setSseStatus(SseStatus sseStatus) {
        this.sseStatus = sseStatus;
    }

    public boolean isHasSot() {
        return hasSot;
    }

    public void setHasSot(boolean hasSot) {
        this.hasSot = hasSot;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ResponsiblePerson> getResponsiblePersons() {
        return responsiblePersons;
    }

    public void setResponsiblePersons(List<ResponsiblePerson> responsiblePersons) {
        this.responsiblePersons = responsiblePersons;
    }

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public List<ControlBoard> getControlBoards() {
		return controlBoards;
	}

	public void setControlBoards(List<ControlBoard> controlBoards) {
		this.controlBoards = controlBoards;
	}

}
