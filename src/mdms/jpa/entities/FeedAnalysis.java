package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FEED_ANALYSIS_T database table.
 * 
 */
@Entity
@Table(name="FEED_ANALYSIS_T")
@NamedQuery(name="FeedAnalysis.findAll", query="SELECT f FROM FeedAnalysis f")
public class FeedAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private List<FeedAnalysisDetails> feedAnalysisDetailsTs;
	private Feed feedT;

	public FeedAnalysis() {
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


	//bi-directional many-to-one association to FeedAnalysisDetails
	@OneToMany(mappedBy="feedAnalysisT")
	public List<FeedAnalysisDetails> getFeedAnalysisDetailsTs() {
		return this.feedAnalysisDetailsTs;
	}

	public void setFeedAnalysisDetailsTs(List<FeedAnalysisDetails> feedAnalysisDetailsTs) {
		this.feedAnalysisDetailsTs = feedAnalysisDetailsTs;
	}

	public FeedAnalysisDetails addFeedAnalysisDetailsT(FeedAnalysisDetails feedAnalysisDetailsT) {
		getFeedAnalysisDetailsTs().add(feedAnalysisDetailsT);
		feedAnalysisDetailsT.setFeedAnalysisT(this);

		return feedAnalysisDetailsT;
	}

	public FeedAnalysisDetails removeFeedAnalysisDetailsT(FeedAnalysisDetails feedAnalysisDetailsT) {
		getFeedAnalysisDetailsTs().remove(feedAnalysisDetailsT);
		feedAnalysisDetailsT.setFeedAnalysisT(null);

		return feedAnalysisDetailsT;
	}


	//bi-directional many-to-one association to Feed
	@ManyToOne
	@JoinColumn(name="FK_FEED_ID", nullable=false)
	public Feed getFeedT() {
		return this.feedT;
	}

	public void setFeedT(Feed feedT) {
		this.feedT = feedT;
	}

}