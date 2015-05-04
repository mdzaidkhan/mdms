package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the NEWLY_UPDATED_FEEDS_T database table.
 * 
 */
@Entity
@Table(name="NEWLY_UPDATED_FEEDS_T")
@NamedQuery(name="NewlyUpdatedFeeds.findAll", query="SELECT n FROM NewlyUpdatedFeeds n Where n.instance =:instance order by n.date desc")
public class NewlyUpdatedFeeds implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	private String feedName;
	private String instance;
	private int version;

	public NewlyUpdatedFeeds() {
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


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(name="FEED_NAME", length=45)
	public String getFeedName() {
		return this.feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}


	@Column(length=45)
	public String getInstance() {
		return this.instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}


	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}