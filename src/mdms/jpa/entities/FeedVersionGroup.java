package mdms.jpa.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the FEED_VERSION_GROUP_T database table.
 * 
 */
@Entity
@Table(name = "FEED_VERSION_GROUP_T")
@NamedQueries({ @NamedQuery(name = "FeedVersionGroup.findAll", query = "SELECT f FROM FeedVersionGroup f"),})
public class FeedVersionGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private List<Feed> feedTs;

	public FeedVersionGroup() {
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

	// bi-directional many-to-one association to Feed
	@OneToMany(mappedBy = "feedVersionGroupT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setFeedVersionGroupT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setFeedVersionGroupT(null);

		return feedT;
	}

}