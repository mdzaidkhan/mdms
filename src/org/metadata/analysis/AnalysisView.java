package org.metadata.analysis;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mdms.jpa.entities.Application;
import mdms.jpa.entities.DataExecutive;
import mdms.jpa.entities.Feed;
import mdms.jpa.entities.FeedAnalysis;
import mdms.jpa.entities.FeedAnalysisDetails;
import mdms.jpa.entity.manager.EntityManagerBean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "analysisView")
@ViewScoped
public class AnalysisView extends EntityManagerBean implements Serializable {

	private static final long serialVersionUID = 5572357789624395239L;
	private TreeNode rootProd;
	private TreeNode rootPta;
	private TreeNode rootIt;

	private TreeNode selectedNode;

	@PostConstruct
	public void init() {
		List<DataExecutive> dataExecs = getEntityManager().createNamedQuery(
				"DataExecutive.findAll", DataExecutive.class).getResultList();

		rootProd = new DefaultTreeNode("Domain", null);
		rootPta = new DefaultTreeNode("Domain", null);
		rootIt = new DefaultTreeNode("Domain", null);

		for (DataExecutive dataExec : dataExecs) {
			TreeNode nodeProd = new DefaultTreeNode(dataExec.getDomain(),
					rootProd);
			TreeNode nodePta = new DefaultTreeNode(dataExec.getDomain(),
					rootPta);
			TreeNode nodeIt = new DefaultTreeNode(dataExec.getDomain(), rootIt);

			for (Application appln : dataExec.getApplicationTs()) {
				TreeNode nodeProd_1 = new DefaultTreeNode(
						appln.getApplicationName(), nodeProd);
				TreeNode nodePta_1 = new DefaultTreeNode(
						appln.getApplicationName(), nodePta);
				TreeNode nodeIt_1 = new DefaultTreeNode(
						appln.getApplicationName(), nodeIt);

				List<Feed> feeds = appln.getFeedTs();

				for (Feed feed : feeds) {
					if (feed.getOutdated() == null) {
						TreeNode node_1 = null;
						if ("PROD".equals(feed.getFeedInstance())) {
							node_1 = new DefaultTreeNode(feed.getFeedName(),
									nodeProd_1);
						} else if ("PTA".equals(feed.getFeedInstance())) {
							node_1 = new DefaultTreeNode(feed.getFeedName(),
									nodePta_1);
						} else if ("IT".equals(feed.getFeedInstance())) {
							node_1 = new DefaultTreeNode(feed.getFeedName(),
									nodeIt_1);
						}

						if (node_1 != null) {
							List<FeedAnalysis> feedAnalysisList = feed
									.getFeedAnalysisTs();

							for (FeedAnalysis feedAnalysis : feedAnalysisList) {
								List<FeedAnalysisDetails> feedAnalysisDetailsList = feedAnalysis
										.getFeedAnalysisDetailsTs();
								for (FeedAnalysisDetails feedAnalysisDetails : feedAnalysisDetailsList) {
									MdmsDefaultTreeNode node = new MdmsDefaultTreeNode(
											feedAnalysisDetails.getAttribute(),
											node_1);
									node.setPassedId(feedAnalysisDetails
											.getId());
									node.setNodeType("Field_Col");
								}
							}
						}
					}
				}
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

	public boolean isAjaxRequest() {
		boolean val = FacesContext.getCurrentInstance().getPartialViewContext()
				.isAjaxRequest();
		return val;
	}

}