package org.metadata.explorer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mdms.jpa.entities.Feed;
import mdms.jpa.entity.manager.EntityManagerBean;

import org.metadata.analysis.MdmsDefaultTreeNode;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class MetaDataExplorerView extends EntityManagerBean implements
		Serializable {

	private static final long serialVersionUID = 2497291407967885004L;

	private TreeNode rootProd;
	private TreeNode rootPta;
	private TreeNode rootIt;

	private TreeNode selectedNode;
	private Feed feed;

	@PostConstruct
	public void init() {
		rootProd = new DefaultTreeNode("Feeds", null);
		rootPta = new DefaultTreeNode("Feeds", null);
		rootIt = new DefaultTreeNode("Feeds", null);

		prepareTabs("PROD", rootProd);
		prepareTabs("PTA", rootPta);
		prepareTabs("IT", rootIt);
	}

	private void prepareTabs(String instance, TreeNode rootTreeNode) {
		HashSet<Integer> set = new HashSet<Integer>();
		List<Feed> feedList = getEntityManager()
				.createNamedQuery(
						"Feed.findInstanceSpecificAndGroupByVersionGroup",
						Feed.class).setParameter("instance", instance)
				.getResultList();
		MdmsDefaultTreeNode prevNode = null;
		for (Feed feed : feedList) {
			if (set.add(feed.hashCode())) {
				MdmsDefaultTreeNode node = new MdmsDefaultTreeNode(
						feed.getFeedName(), rootTreeNode);
				node.setPassedId(feed.getId());
				prevNode = node;
			} else if(prevNode != null) {
				MdmsDefaultTreeNode node1 = new MdmsDefaultTreeNode(
						"Version: "+ feed.getFeedVersion(), prevNode);
				node1.setPassedId(feed.getId());
				
			}
		}
		closeEntityManager();
	}

	public TreeNode getRootProd() {
		return rootProd;
	}

	public void setRootProd(TreeNode rootProd) {
		this.rootProd = rootProd;
	}

	public TreeNode getRootPta() {
		return rootPta;
	}

	public void setRootPta(TreeNode rootPta) {
		this.rootPta = rootPta;
	}

	public TreeNode getRootIt() {
		return rootIt;
	}

	public void setRootIt(TreeNode rootIt) {
		this.rootIt = rootIt;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void onNodeSelect(NodeSelectEvent event) {
		if (event.getTreeNode() instanceof MdmsDefaultTreeNode) {
			MdmsDefaultTreeNode node = (MdmsDefaultTreeNode) event
					.getTreeNode();
			feed = getFeedDetails(node.getPassedId());
		}
	}

	public Feed getFeedDetails(int iD) {
		Feed feed = null;
		if (iD > 0) {
			feed = getEntityManager().find(Feed.class, iD);
			closeEntityManager();
		}
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public Feed getFeed() {
		return feed;
	}

	public boolean isAjaxRequest() {
		if (feed == null) {
			return false;
		}
		boolean val = FacesContext.getCurrentInstance().getPartialViewContext()
				.isAjaxRequest();
		return val;
	}

	public void onTabChange(TabChangeEvent event) {
		feed = null;
	}
}