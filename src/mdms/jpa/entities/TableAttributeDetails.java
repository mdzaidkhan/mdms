package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TABLE_ATTRIBUTE_DETAILS_T database table.
 * 
 */
@Entity
@Table(name="TABLE_ATTRIBUTE_DETAILS_T")
@NamedQuery(name="TableAttributeDetails.findAll", query="SELECT t FROM TableAttributeDetails t")
public class TableAttributeDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String dataType;
	private String desc;
	private String info1;
	private String info10;
	private String info2;
	private String info3;
	private String info4;
	private String info5;
	private String info6;
	private String info7;
	private String info8;
	private String info9;
	private String schemaColName;
	private TableAttribute tableAttributeT;
	private LinkedInputAttributeDetails linkedInputAttributeDetailsT;
	private SynonymGroup synonymGroupT;

	public TableAttributeDetails() {
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


	@Column(name="DATA_TYPE", length=150)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	@Column(name="`DESC`", length=250)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Column(name="INFO_1", length=150)
	public String getInfo1() {
		return this.info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}


	@Column(name="INFO_10", length=150)
	public String getInfo10() {
		return this.info10;
	}

	public void setInfo10(String info10) {
		this.info10 = info10;
	}


	@Column(name="INFO_2", length=150)
	public String getInfo2() {
		return this.info2;
	}

	public void setInfo2(String info2) {
		this.info2 = info2;
	}


	@Column(name="INFO_3", length=150)
	public String getInfo3() {
		return this.info3;
	}

	public void setInfo3(String info3) {
		this.info3 = info3;
	}


	@Column(name="INFO_4", length=150)
	public String getInfo4() {
		return this.info4;
	}

	public void setInfo4(String info4) {
		this.info4 = info4;
	}


	@Column(name="INFO_5", length=150)
	public String getInfo5() {
		return this.info5;
	}

	public void setInfo5(String info5) {
		this.info5 = info5;
	}


	@Column(name="INFO_6", length=150)
	public String getInfo6() {
		return this.info6;
	}

	public void setInfo6(String info6) {
		this.info6 = info6;
	}


	@Column(name="INFO_7", length=150)
	public String getInfo7() {
		return this.info7;
	}

	public void setInfo7(String info7) {
		this.info7 = info7;
	}


	@Column(name="INFO_8", length=150)
	public String getInfo8() {
		return this.info8;
	}

	public void setInfo8(String info8) {
		this.info8 = info8;
	}


	@Column(name="INFO_9", length=150)
	public String getInfo9() {
		return this.info9;
	}

	public void setInfo9(String info9) {
		this.info9 = info9;
	}


	@Column(name="SCHEMA_COL_NAME", length=150)
	public String getSchemaColName() {
		return this.schemaColName;
	}

	public void setSchemaColName(String schemaColName) {
		this.schemaColName = schemaColName;
	}


	//bi-directional many-to-one association to TableAttribute
	@ManyToOne
	@JoinColumn(name="FK_GROUP", nullable=false)
	public TableAttribute getTableAttributeT() {
		return this.tableAttributeT;
	}

	public void setTableAttributeT(TableAttribute tableAttributeT) {
		this.tableAttributeT = tableAttributeT;
	}


	//bi-directional many-to-one association to LinkedInputAttributeDetails
	@ManyToOne
	@JoinColumn(name="FK_LINKED_INPUT")
	public LinkedInputAttributeDetails getLinkedInputAttributeDetailsT() {
		return this.linkedInputAttributeDetailsT;
	}

	public void setLinkedInputAttributeDetailsT(LinkedInputAttributeDetails linkedInputAttributeDetailsT) {
		this.linkedInputAttributeDetailsT = linkedInputAttributeDetailsT;
	}


	//bi-directional many-to-one association to SynonymGroup
	@ManyToOne
	@JoinColumn(name="FK_SYN_GROUP_ID")
	public SynonymGroup getSynonymGroupT() {
		return this.synonymGroupT;
	}

	public void setSynonymGroupT(SynonymGroup synonymGroupT) {
		this.synonymGroupT = synonymGroupT;
	}

}