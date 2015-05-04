package mdms.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TOPSEARCHES_IN_MDMS_T database table.
 * 
 */
@Entity
@Table(name = "TOPSEARCHES_IN_MDMS_T")
@NamedQuery(name = "TopSearchesInMdms.findAll", query = "SELECT m FROM TopSearchesInMdms m  where m.instance =:instance order by m.ranking desc")
public class TopSearchesInMdms implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String searchTerm;
	private int ranking;
	private String instance;

	public TopSearchesInMdms() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

}