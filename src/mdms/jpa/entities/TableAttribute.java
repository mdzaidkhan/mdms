package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TABLE_ATTRIBUTE_T database table.
 * 
 */
@Entity
@Table(name="TABLE_ATTRIBUTE_T")
@NamedQuery(name="TableAttribute.findAll", query="SELECT t FROM TableAttribute t")
public class TableAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private List<OutputTableDetails> outputTableDetailsTs;
	private List<TableAttributeDetails> tableAttributeDetailsTs;

	public TableAttribute() {
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


	//bi-directional many-to-one association to OutputTableDetails
	@OneToMany(mappedBy="tableAttributeT")
	public List<OutputTableDetails> getOutputTableDetailsTs() {
		return this.outputTableDetailsTs;
	}

	public void setOutputTableDetailsTs(List<OutputTableDetails> outputTableDetailsTs) {
		this.outputTableDetailsTs = outputTableDetailsTs;
	}

	public OutputTableDetails addOutputTableDetailsT(OutputTableDetails outputTableDetailsT) {
		getOutputTableDetailsTs().add(outputTableDetailsT);
		outputTableDetailsT.setTableAttributeT(this);

		return outputTableDetailsT;
	}

	public OutputTableDetails removeOutputTableDetailsT(OutputTableDetails outputTableDetailsT) {
		getOutputTableDetailsTs().remove(outputTableDetailsT);
		outputTableDetailsT.setTableAttributeT(null);

		return outputTableDetailsT;
	}


	//bi-directional many-to-one association to TableAttributeDetails
	@OneToMany(mappedBy="tableAttributeT")
	public List<TableAttributeDetails> getTableAttributeDetailsTs() {
		return this.tableAttributeDetailsTs;
	}

	public void setTableAttributeDetailsTs(List<TableAttributeDetails> tableAttributeDetailsTs) {
		this.tableAttributeDetailsTs = tableAttributeDetailsTs;
	}

	public TableAttributeDetails addTableAttributeDetailsT(TableAttributeDetails tableAttributeDetailsT) {
		getTableAttributeDetailsTs().add(tableAttributeDetailsT);
		tableAttributeDetailsT.setTableAttributeT(this);

		return tableAttributeDetailsT;
	}

	public TableAttributeDetails removeTableAttributeDetailsT(TableAttributeDetails tableAttributeDetailsT) {
		getTableAttributeDetailsTs().remove(tableAttributeDetailsT);
		tableAttributeDetailsT.setTableAttributeT(null);

		return tableAttributeDetailsT;
	}

}