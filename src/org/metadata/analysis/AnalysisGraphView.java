package org.metadata.analysis;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mdms.jpa.entities.FeedAnalysisDetails;
import mdms.jpa.entity.manager.EntityManagerBean;

import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;

@ManagedBean
@ViewScoped
public class AnalysisGraphView extends EntityManagerBean implements
		Serializable {

	private static final long serialVersionUID = 8373072821792746738L;
	private int feedAnalysisDetailsId;

	public void setFeedAnalysisDetailsId(int feedAnalysisDetailsId) {
		this.feedAnalysisDetailsId = feedAnalysisDetailsId;
	}

	public FeedAnalysisDetails getFeedAnalysisDetails() {
		FeedAnalysisDetails feedAnalysisDetails = null;
		if (feedAnalysisDetailsId > 0) {
			feedAnalysisDetails = getEntityManager().find(
					FeedAnalysisDetails.class, feedAnalysisDetailsId);
			closeEntityManager();
		}
		return feedAnalysisDetails;
	}

	public void onNodeSelect(NodeSelectEvent event) {
		if (event.getTreeNode() instanceof MdmsDefaultTreeNode) {
			MdmsDefaultTreeNode node = (MdmsDefaultTreeNode) event
					.getTreeNode();	
			feedAnalysisDetailsId = node.getPassedId();
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('myDialogVar').show();");			
		}

	}
}