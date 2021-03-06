package org.sot.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "controlboards")
public class ControlBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Brand brand;

	@Column(length = 60)
	private String model;
	private String code;

	@Column(columnDefinition = "DECIMAL default 0.00", precision = 10, scale = 2)
	private Double price;
	@Column(length = 100, nullable = true)
	private String link;
	@Column(length = 100, nullable = true)
	private String fileUrl;

	@ManyToMany(mappedBy = "controlBoards")
	@JsonIgnore
	private List<Point> points;

	public ControlBoard() {
	}

	public ControlBoard(Brand brand, String model, String code, Double price, String link, String fileUrl, List<Point> points) {
		this.brand = brand;
		this.model = model;
		this.code = code;
		this.price = price;
		this.link = link;
		this.fileUrl = fileUrl;
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
