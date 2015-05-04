package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DATA_STEWARD_T database table.
 * 
 */
@Entity
@Table(name="DATA_STEWARD_T")
@NamedQuery(name="DataSteward.findAll", query="SELECT d FROM DataSteward d")
public class DataSteward implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private DataOwner dataOwnerT;
	private List<Feed> feedTs;

	public DataSteward() {
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


	@Column(nullable=false, length=150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to DataOwner
	@ManyToOne
	@JoinColumn(name="FK_DATA_OWNER_ID", nullable=false)
	public DataOwner getDataOwnerT() {
		return this.dataOwnerT;
	}

	public void setDataOwnerT(DataOwner dataOwnerT) {
		this.dataOwnerT = dataOwnerT;
	}


	//bi-directional many-to-one association to Feed
	@OneToMany(mappedBy="dataStewardT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setDataStewardT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setDataStewardT(null);

		return feedT;
	}

}