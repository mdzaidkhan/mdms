package mdms.jpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the FEED_T database table.
 * 
 */
@Entity
@Table(name = "FEED_T")
@NamedQueries({
		@NamedQuery(name = "Feed.findAll", query = "SELECT f FROM Feed f"),
		@NamedQuery(name = "Feed.findInstanceSpecificAndGroupByVersionGroup", query = "SELECT f FROM Feed f where f.feedInstance =:instance order by f.feedName,f.feedVersion desc"), })
public class Feed implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String desc;
	private String feedInstance;
	private String feedName;
	private String feedType;
	private String feedVersion;
	private List<FeedAnalysis> feedAnalysisTs;
	private Application applicationT;
	private DataDeliveryAgreement dataDeliveryAgreementT;
	private DataOwner dataOwnerT;
	private DataSteward dataStewardT;
	private InputTableGroup inputTableGroupT;
	private OuputTableGroup ouputTableGroupT;
	private FeedVersionGroup feedVersionGroupT;
	private String outdated;

	public Feed() {
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

	@Column(name = "`DESC`", length = 500)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "FEED_INSTANCE", nullable = false, length = 45)
	public String getFeedInstance() {
		return this.feedInstance;
	}

	public void setFeedInstance(String feedInstance) {
		this.feedInstance = feedInstance;
	}

	@Column(name = "FEED_NAME", nullable = false, length = 250)
	public String getFeedName() {
		return this.feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	@Column(name = "FEED_TYPE", nullable = false, length = 45)
	public String getFeedType() {
		return this.feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	@Column(name = "FEED_VERSION", nullable = false, length = 45)
	public String getFeedVersion() {
		return this.feedVersion;
	}

	public void setFeedVersion(String feedVersion) {
		this.feedVersion = feedVersion;
	}

	// bi-directional many-to-one association to FeedAnalysis
	@OneToMany(mappedBy = "feedT")
	public List<FeedAnalysis> getFeedAnalysisTs() {
		return this.feedAnalysisTs;
	}

	public void setFeedAnalysisTs(List<FeedAnalysis> feedAnalysisTs) {
		this.feedAnalysisTs = feedAnalysisTs;
	}

	public FeedAnalysis addFeedAnalysisT(FeedAnalysis feedAnalysisT) {
		getFeedAnalysisTs().add(feedAnalysisT);
		feedAnalysisT.setFeedT(this);

		return feedAnalysisT;
	}

	public FeedAnalysis removeFeedAnalysisT(FeedAnalysis feedAnalysisT) {
		getFeedAnalysisTs().remove(feedAnalysisT);
		feedAnalysisT.setFeedT(null);

		return feedAnalysisT;
	}

	// bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name = "`FK_APPLICATION _ID`")
	public Application getApplicationT() {
		return this.applicationT;
	}

	public void setApplicationT(Application applicationT) {
		this.applicationT = applicationT;
	}

	// bi-directional many-to-one association to DataDeliveryAgreement
	@ManyToOne
	@JoinColumn(name = "FK_DATA_DELIVERY_AGREEMENT_ID", nullable = false)
	public DataDeliveryAgreement getDataDeliveryAgreementT() {
		return this.dataDeliveryAgreementT;
	}

	public void setDataDeliveryAgreementT(
			DataDeliveryAgreement dataDeliveryAgreementT) {
		this.dataDeliveryAgreementT = dataDeliveryAgreementT;
	}

	// bi-directional many-to-one association to DataOwner
	@ManyToOne
	@JoinColumn(name = "FK_DATA_OWNER_ID", nullable = false)
	public DataOwner getDataOwnerT() {
		return this.dataOwnerT;
	}

	public void setDataOwnerT(DataOwner dataOwnerT) {
		this.dataOwnerT = dataOwnerT;
	}

	// bi-directional many-to-one association to DataSteward
	@ManyToOne
	@JoinColumn(name = "FK_DATA_STEWARD_ID", nullable = false)
	public DataSteward getDataStewardT() {
		return this.dataStewardT;
	}

	public void setDataStewardT(DataSteward dataStewardT) {
		this.dataStewardT = dataStewardT;
	}

	// bi-directional many-to-one association to InputTableGroup
	@ManyToOne
	@JoinColumn(name = "FK_INPUT_TABLE_GROUP_ID")
	public InputTableGroup getInputTableGroupT() {
		return this.inputTableGroupT;
	}

	public void setInputTableGroupT(InputTableGroup inputTableGroupT) {
		this.inputTableGroupT = inputTableGroupT;
	}

	// bi-directional many-to-one association to OuputTableGroup
	@ManyToOne
	@JoinColumn(name = "FK_OUTPUT_TABLE_GROUP_ID")
	public OuputTableGroup getOuputTableGroupT() {
		return this.ouputTableGroupT;
	}

	public void setOuputTableGroupT(OuputTableGroup ouputTableGroupT) {
		this.ouputTableGroupT = ouputTableGroupT;
	}

	// bi-directional many-to-one association to FeedVersionGroup
	@ManyToOne
	@JoinColumn(name = "FK_FEED_VERSION_GROUP_ID")
	public FeedVersionGroup getFeedVersionGroupT() {
		return this.feedVersionGroupT;
	}

	public void setFeedVersionGroupT(FeedVersionGroup feedVersionGroupT) {
		this.feedVersionGroupT = feedVersionGroupT;
	}

	@Override
	public int hashCode() {
		return feedName.hashCode();
	}

	@Column(name = "`OUTDATED`", nullable = false, length = 10)
	public String getOutdated() {
		return outdated;
	}

	public void setOutdated(String outdated) {
		this.outdated = outdated;
	}

}