package org.sot.models.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "places")
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(length = 30, unique = true)
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		try {
			return "\"place\":" + new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(Address.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "";
//		return "\"place\":{" + "\"name\":\"" + name + "\"}";
	}
}
