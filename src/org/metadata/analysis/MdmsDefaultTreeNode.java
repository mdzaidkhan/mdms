package org.metadata.analysis;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class MdmsDefaultTreeNode extends DefaultTreeNode {
	
	public MdmsDefaultTreeNode() {
		super();
	}
	public MdmsDefaultTreeNode(Object data, TreeNode parent) {
		super(data, parent);
	}
	public MdmsDefaultTreeNode(Object data) {
		super(data);
	}
	public MdmsDefaultTreeNode(String type, Object data, TreeNode parent) {
		super(type, data, parent);
	}
	
	private static final long serialVersionUID = -3151312132209953918L;
	private String nodeType;
	private int passedId;
	
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public int getPassedId() {
		return passedId;
	}
	public void setPassedId(int passedId) {
		this.passedId = passedId;
	}
	
}
