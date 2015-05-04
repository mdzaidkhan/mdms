package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DATA_OWNER_T database table.
 * 
 */
@Entity
@Table(name="DATA_OWNER_T")
@NamedQuery(name="DataOwner.findAll", query="SELECT d FROM DataOwner d")
public class DataOwner implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private DataExecutive dataExecutiveT;
	private List<DataSteward> dataStewardTs;
	private List<Feed> feedTs;

	public DataOwner() {
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


	//bi-directional many-to-one association to DataExecutive
	@ManyToOne
	@JoinColumn(name="FK_DATA_EXEC_ID", nullable=false)
	public DataExecutive getDataExecutiveT() {
		return this.dataExecutiveT;
	}

	public void setDataExecutiveT(DataExecutive dataExecutiveT) {
		this.dataExecutiveT = dataExecutiveT;
	}


	//bi-directional many-to-one association to DataSteward
	@OneToMany(mappedBy="dataOwnerT")
	public List<DataSteward> getDataStewardTs() {
		return this.dataStewardTs;
	}

	public void setDataStewardTs(List<DataSteward> dataStewardTs) {
		this.dataStewardTs = dataStewardTs;
	}

	public DataSteward addDataStewardT(DataSteward dataStewardT) {
		getDataStewardTs().add(dataStewardT);
		dataStewardT.setDataOwnerT(this);

		return dataStewardT;
	}

	public DataSteward removeDataStewardT(DataSteward dataStewardT) {
		getDataStewardTs().remove(dataStewardT);
		dataStewardT.setDataOwnerT(null);

		return dataStewardT;
	}


	//bi-directional many-to-one association to Feed
	@OneToMany(mappedBy="dataOwnerT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setDataOwnerT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setDataOwnerT(null);

		return feedT;
	}

}