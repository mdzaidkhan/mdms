package mdms.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the FEED_ANALYSIS_DETAILS_T database table.
 * 
 */
@Entity
@Table(name="FEED_ANALYSIS_DETAILS_T")
@NamedQuery(name="FeedAnalysisDetails.findAll", query="SELECT f FROM FeedAnalysisDetails f")
public class FeedAnalysisDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private byte[] analysisTrace;
	private String attribute;
	private FeedAnalysis feedAnalysisT;

	public FeedAnalysisDetails() {
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

	@Lob
	public byte[] getAnalysisTrace() {
		return this.analysisTrace;
	}

	public void setAnalysisTrace(byte[] analysisTrace) {
		this.analysisTrace = analysisTrace;
	}


	@Column(nullable=false, length=45)
	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}


	//bi-directional many-to-one association to FeedAnalysis
	@ManyToOne
	@JoinColumn(name="FK_FEED_ANALYSIS_ID", nullable=false)
	public FeedAnalysis getFeedAnalysisT() {
		return this.feedAnalysisT;
	}

	public void setFeedAnalysisT(FeedAnalysis feedAnalysisT) {
		this.feedAnalysisT = feedAnalysisT;
	}
	
	public String getAnalysisTraceToString(){
		String retVal = "";
		if(this.analysisTrace != null){
			 retVal = new String(this.analysisTrace);
		}
		return retVal;
	}

}