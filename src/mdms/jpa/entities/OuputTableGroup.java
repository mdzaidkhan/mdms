package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OUPUT_TABLE_GROUP_T database table.
 * 
 */
@Entity
@Table(name="OUPUT_TABLE_GROUP_T")
@NamedQuery(name="OuputTableGroup.findAll", query="SELECT o FROM OuputTableGroup o")
public class OuputTableGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private List<Feed> feedTs;
	private List<OutputTableDetails> outputTableDetailsTs;

	public OuputTableGroup() {
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


	//bi-directional many-to-one association to Feed
	@OneToMany(mappedBy="ouputTableGroupT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setOuputTableGroupT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setOuputTableGroupT(null);

		return feedT;
	}


	//bi-directional many-to-one association to OutputTableDetails
	@OneToMany(mappedBy="ouputTableGroupT")
	public List<OutputTableDetails> getOutputTableDetailsTs() {
		return this.outputTableDetailsTs;
	}

	public void setOutputTableDetailsTs(List<OutputTableDetails> outputTableDetailsTs) {
		this.outputTableDetailsTs = outputTableDetailsTs;
	}

	public OutputTableDetails addOutputTableDetailsT(OutputTableDetails outputTableDetailsT) {
		getOutputTableDetailsTs().add(outputTableDetailsT);
		outputTableDetailsT.setOuputTableGroupT(this);

		return outputTableDetailsT;
	}

	public OutputTableDetails removeOutputTableDetailsT(OutputTableDetails outputTableDetailsT) {
		getOutputTableDetailsTs().remove(outputTableDetailsT);
		outputTableDetailsT.setOuputTableGroupT(null);

		return outputTableDetailsT;
	}

}