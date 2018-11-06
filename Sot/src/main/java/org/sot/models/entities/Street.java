package org.sot.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.sot.enums.LifeStatus;

/**
 *
 * Holder for street name.
 *
 * @author <a>Yordan Lazarov<a>
 *
 */
@Entity(name = "streets")
public class Street {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 60, unique = true)
	private String name;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "tinyint")
	private LifeStatus status;
	
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

	public LifeStatus getStatus() {
		return status;
	}

	public void setStatus(LifeStatus status) {
		this.status = status;
	}
}
