package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SYNONYM_GROUP_DETAILS_T database table.
 * 
 */
@Entity
@Table(name="SYNONYM_GROUP_DETAILS_T")
@NamedQuery(name="SynonymGroupDetails.findAll", query="SELECT s FROM SynonymGroupDetails s")
public class SynonymGroupDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String desc;
	private String term;
	private SynonymGroup synonymGroupT;

	public SynonymGroupDetails() {
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


	@Column(name="`DESC`", nullable=false, length=150)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Column(nullable=false, length=150)
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}


	//bi-directional many-to-one association to SynonymGroup
	@ManyToOne
	@JoinColumn(name="FK_SYNONYM_ID", nullable=false)
	public SynonymGroup getSynonymGroupT() {
		return this.synonymGroupT;
	}

	public void setSynonymGroupT(SynonymGroup synonymGroupT) {
		this.synonymGroupT = synonymGroupT;
	}

}