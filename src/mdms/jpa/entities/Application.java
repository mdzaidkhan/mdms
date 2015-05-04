package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the APPLICATION_T database table.
 * 
 */
@Entity
@Table(name="APPLICATION_T")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String applicationName;
	private DataExecutive dataExecutiveT;
	private List<Feed> feedTs;

	public Application() {
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


	@Column(name="APPLICATION_NAME", nullable=false, length=150)
	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	//bi-directional many-to-one association to DataExecutive
	@ManyToOne
	@JoinColumn(name="FK_DATA_EXECUTIVE_ID")
	public DataExecutive getDataExecutiveT() {
		return this.dataExecutiveT;
	}

	public void setDataExecutiveT(DataExecutive dataExecutiveT) {
		this.dataExecutiveT = dataExecutiveT;
	}


	//bi-directional many-to-one association to Feed
	@OneToMany(mappedBy="applicationT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setApplicationT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setApplicationT(null);

		return feedT;
	}

}