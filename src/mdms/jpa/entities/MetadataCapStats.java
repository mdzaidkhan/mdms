package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the METADATA_CAP_STATS_T database table.
 * 
 */
@Entity
@Table(name="METADATA_CAP_STATS_T")
@NamedQuery(name="MetadataCapStats.findAll", query="SELECT m FROM MetadataCapStats m")
public class MetadataCapStats implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int captured;
	private String instance;
	private int missing;

	public MetadataCapStats() {
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


	public int getCaptured() {
		return this.captured;
	}

	public void setCaptured(int captured) {
		this.captured = captured;
	}


	@Column(length=25)
	public String getInstance() {
		return this.instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}


	public int getMissing() {
		return this.missing;
	}

	public void setMissing(int missing) {
		this.missing = missing;
	}

}