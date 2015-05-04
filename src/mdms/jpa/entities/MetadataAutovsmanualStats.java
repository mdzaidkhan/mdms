package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the METADATA_AUTOVSMANUAL_STATS_T database table.
 * 
 */
@Entity
@Table(name="METADATA_AUTOVSMANUAL_STATS_T")
@NamedQuery(name="MetadataAutovsmanualStats.findAll", query="SELECT m FROM MetadataAutovsmanualStats m")
public class MetadataAutovsmanualStats implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int automatic;
	private String instance;
	private int manual;

	public MetadataAutovsmanualStats() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getAutomatic() {
		return this.automatic;
	}

	public void setAutomatic(int automatic) {
		this.automatic = automatic;
	}


	@Column(length=25)
	public String getInstance() {
		return this.instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}


	public int getManual() {
		return this.manual;
	}

	public void setManual(int manual) {
		this.manual = manual;
	}

}