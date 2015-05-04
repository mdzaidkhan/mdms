package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SYNONYM_GROUP_T database table.
 * 
 */
@Entity
@Table(name="SYNONYM_GROUP_T")
@NamedQuery(name="SynonymGroup.findAll", query="SELECT s FROM SynonymGroup s")
public class SynonymGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String synGroupDesc;
	private String synGroupName;
	private List<SynonymGroupDetails> synonymGroupDetailsTs;
	private List<TableAttributeDetails> tableAttributeDetailsTs;

	public SynonymGroup() {
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


	@Column(name="SYN_GROUP_DESC", nullable=false, length=150)
	public String getSynGroupDesc() {
		return this.synGroupDesc;
	}

	public void setSynGroupDesc(String synGroupDesc) {
		this.synGroupDesc = synGroupDesc;
	}


	@Column(name="SYN_GROUP_NAME", nullable=false, length=150)
	public String getSynGroupName() {
		return this.synGroupName;
	}

	public void setSynGroupName(String synGroupName) {
		this.synGroupName = synGroupName;
	}


	//bi-directional many-to-one association to SynonymGroupDetails
	@OneToMany(mappedBy="synonymGroupT")
	public List<SynonymGroupDetails> getSynonymGroupDetailsTs() {
		return this.synonymGroupDetailsTs;
	}

	public void setSynonymGroupDetailsTs(List<SynonymGroupDetails> synonymGroupDetailsTs) {
		this.synonymGroupDetailsTs = synonymGroupDetailsTs;
	}

	public SynonymGroupDetails addSynonymGroupDetailsT(SynonymGroupDetails synonymGroupDetailsT) {
		getSynonymGroupDetailsTs().add(synonymGroupDetailsT);
		synonymGroupDetailsT.setSynonymGroupT(this);

		return synonymGroupDetailsT;
	}

	public SynonymGroupDetails removeSynonymGroupDetailsT(SynonymGroupDetails synonymGroupDetailsT) {
		getSynonymGroupDetailsTs().remove(synonymGroupDetailsT);
		synonymGroupDetailsT.setSynonymGroupT(null);

		return synonymGroupDetailsT;
	}


	//bi-directional many-to-one association to TableAttributeDetails
	@OneToMany(mappedBy="synonymGroupT")
	public List<TableAttributeDetails> getTableAttributeDetailsTs() {
		return this.tableAttributeDetailsTs;
	}

	public void setTableAttributeDetailsTs(List<TableAttributeDetails> tableAttributeDetailsTs) {
		this.tableAttributeDetailsTs = tableAttributeDetailsTs;
	}

	public TableAttributeDetails addTableAttributeDetailsT(TableAttributeDetails tableAttributeDetailsT) {
		getTableAttributeDetailsTs().add(tableAttributeDetailsT);
		tableAttributeDetailsT.setSynonymGroupT(this);

		return tableAttributeDetailsT;
	}

	public TableAttributeDetails removeTableAttributeDetailsT(TableAttributeDetails tableAttributeDetailsT) {
		getTableAttributeDetailsTs().remove(tableAttributeDetailsT);
		tableAttributeDetailsT.setSynonymGroupT(null);

		return tableAttributeDetailsT;
	}

}