package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INPUT_TABLE_GROUP_T database table.
 * 
 */
@Entity
@Table(name="INPUT_TABLE_GROUP_T")
@NamedQuery(name="InputTableGroup.findAll", query="SELECT i FROM InputTableGroup i")
public class InputTableGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private List<Feed> feedTs;
	private List<InputTableDetails> inputTableDetailsTs;

	public InputTableGroup() {
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
	@OneToMany(mappedBy="inputTableGroupT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setInputTableGroupT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setInputTableGroupT(null);

		return feedT;
	}


	//bi-directional many-to-one association to InputTableDetails
	@OneToMany(mappedBy="inputTableGroupT")
	public List<InputTableDetails> getInputTableDetailsTs() {
		return this.inputTableDetailsTs;
	}

	public void setInputTableDetailsTs(List<InputTableDetails> inputTableDetailsTs) {
		this.inputTableDetailsTs = inputTableDetailsTs;
	}

	public InputTableDetails addInputTableDetailsT(InputTableDetails inputTableDetailsT) {
		getInputTableDetailsTs().add(inputTableDetailsT);
		inputTableDetailsT.setInputTableGroupT(this);

		return inputTableDetailsT;
	}

	public InputTableDetails removeInputTableDetailsT(InputTableDetails inputTableDetailsT) {
		getInputTableDetailsTs().remove(inputTableDetailsT);
		inputTableDetailsT.setInputTableGroupT(null);

		return inputTableDetailsT;
	}

}