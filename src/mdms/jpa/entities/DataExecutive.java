package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DATA_EXECUTIVE_T database table.
 * 
 */
@Entity
@Table(name="DATA_EXECUTIVE_T")
@NamedQuery(name="DataExecutive.findAll", query="SELECT d FROM DataExecutive d")
public class DataExecutive implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String domain;
	private String name;
	private List<Application> applicationTs;
	private List<DataOwner> dataOwnerTs;

	public DataExecutive() {
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
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}


	@Column(nullable=false, length=150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="dataExecutiveT")
	public List<Application> getApplicationTs() {
		return this.applicationTs;
	}

	public void setApplicationTs(List<Application> applicationTs) {
		this.applicationTs = applicationTs;
	}

	public Application addApplicationT(Application applicationT) {
		getApplicationTs().add(applicationT);
		applicationT.setDataExecutiveT(this);

		return applicationT;
	}

	public Application removeApplicationT(Application applicationT) {
		getApplicationTs().remove(applicationT);
		applicationT.setDataExecutiveT(null);

		return applicationT;
	}


	//bi-directional many-to-one association to DataOwner
	@OneToMany(mappedBy="dataExecutiveT")
	public List<DataOwner> getDataOwnerTs() {
		return this.dataOwnerTs;
	}

	public void setDataOwnerTs(List<DataOwner> dataOwnerTs) {
		this.dataOwnerTs = dataOwnerTs;
	}

	public DataOwner addDataOwnerT(DataOwner dataOwnerT) {
		getDataOwnerTs().add(dataOwnerT);
		dataOwnerT.setDataExecutiveT(this);

		return dataOwnerT;
	}

	public DataOwner removeDataOwnerT(DataOwner dataOwnerT) {
		getDataOwnerTs().remove(dataOwnerT);
		dataOwnerT.setDataExecutiveT(null);

		return dataOwnerT;
	}

}