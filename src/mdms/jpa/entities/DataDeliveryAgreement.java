package mdms.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the DATA_DELIVERY_AGREEMENT_T database table.
 * 
 */
@Entity
@Table(name = "DATA_DELIVERY_AGREEMENT_T")
@NamedQuery(name = "DataDeliveryAgreement.findAll", query = "SELECT d FROM DataDeliveryAgreement d")
public class DataDeliveryAgreement implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateSigned;
	private byte[] details;
	private String url;
	private List<Feed> feedTs;

	public DataDeliveryAgreement() {
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_SIGNED", nullable = false)
	public Date getDateSigned() {
		return this.dateSigned;
	}

	public void setDateSigned(Date dateSigned) {
		this.dateSigned = dateSigned;
	}

	@Lob
	public byte[] getDetails() {
		return this.details;
	}

	public void setDetails(byte[] details) {
		this.details = details;
	}

	@Column(length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// bi-directional many-to-one association to Feed
	@OneToMany(mappedBy = "dataDeliveryAgreementT")
	public List<Feed> getFeedTs() {
		return this.feedTs;
	}

	public void setFeedTs(List<Feed> feedTs) {
		this.feedTs = feedTs;
	}

	public Feed addFeedT(Feed feedT) {
		getFeedTs().add(feedT);
		feedT.setDataDeliveryAgreementT(this);

		return feedT;
	}

	public Feed removeFeedT(Feed feedT) {
		getFeedTs().remove(feedT);
		feedT.setDataDeliveryAgreementT(null);

		return feedT;
	}
}