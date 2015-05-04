package mdms.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OUTPUT_TABLE_DETAILS_T database table.
 * 
 */
@Entity
@Table(name="OUTPUT_TABLE_DETAILS_T")
@NamedQuery(name="OutputTableDetails.findAll", query="SELECT o FROM OutputTableDetails o")
public class OutputTableDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
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
	private String tableDesc;
	private String tableName;
	private OuputTableGroup ouputTableGroupT;
	private TableAttribute tableAttributeT;

	public OutputTableDetails() {
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


	@Column(name="TABLE_DESC", length=150)
	public String getTableDesc() {
		return this.tableDesc;
	}

	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}


	@Column(name="TABLE_NAME", length=150)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	//bi-directional many-to-one association to OuputTableGroup
	@ManyToOne
	@JoinColumn(name="FK_OUTPUT_TABLE_GROUP_ID", nullable=false)
	public OuputTableGroup getOuputTableGroupT() {
		return this.ouputTableGroupT;
	}

	public void setOuputTableGroupT(OuputTableGroup ouputTableGroupT) {
		this.ouputTableGroupT = ouputTableGroupT;
	}


	//bi-directional many-to-one association to TableAttribute
	@ManyToOne
	@JoinColumn(name="FK_TBL_ATTRS_ID")
	public TableAttribute getTableAttributeT() {
		return this.tableAttributeT;
	}

	public void setTableAttributeT(TableAttribute tableAttributeT) {
		this.tableAttributeT = tableAttributeT;
	}

}