package org.metadata.dashboard;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mdms.jpa.entities.NewlyUpdatedFeeds;
import mdms.jpa.entities.TopSearchesInMdms;
import mdms.jpa.entities.UpcomingFeedUpdate;
import mdms.jpa.entity.manager.EntityManagerBean;

@ManagedBean
@ViewScoped
public class DashBoardDataListView extends EntityManagerBean implements Serializable {
	private static final long serialVersionUID = 5058364338693605830L;
	
	private List<TopSearchesInMdms> topHitsProd;
	private List<NewlyUpdatedFeeds> newlyUpdatedFeedsProd;
	private List<UpcomingFeedUpdate> toBeUpdatedFeedsProd;

	private List<TopSearchesInMdms> topHitsPta;
	private List<NewlyUpdatedFeeds> newlyUpdatedFeedsPta;
	private List<UpcomingFeedUpdate> toBeUpdatedFeedsPta;
	
	private List<TopSearchesInMdms> topHitsIt;
	private List<NewlyUpdatedFeeds> newlyUpdatedFeedsIt;
	private List<UpcomingFeedUpdate> toBeUpdatedFeedsIt;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TopSearchesInMdms> getTopHitsProd() {
		return topHitsProd;
	}

	public List<NewlyUpdatedFeeds> getNewlyUpdatedFeedsProd() {
		return newlyUpdatedFeedsProd;
	}

	public List<UpcomingFeedUpdate> getToBeUpdatedFeedsProd() {
		return toBeUpdatedFeedsProd;
	}

	public List<TopSearchesInMdms> getTopHitsPta() {
		return topHitsPta;
	}

	public List<NewlyUpdatedFeeds> getNewlyUpdatedFeedsPta() {
		return newlyUpdatedFeedsPta;
	}

	public List<UpcomingFeedUpdate> getToBeUpdatedFeedsPta() {
		return toBeUpdatedFeedsPta;
	}

	public List<TopSearchesInMdms> getTopHitsIt() {
		return topHitsIt;
	}

	public List<NewlyUpdatedFeeds> getNewlyUpdatedFeedsIt() {
		return newlyUpdatedFeedsIt;
	}

	public List<UpcomingFeedUpdate> getToBeUpdatedFeedsIt() {
		return toBeUpdatedFeedsIt;
	}

	@PostConstruct
	public void init() {		
		topHitsProd = findTopHits("PROD");
		newlyUpdatedFeedsProd = findNewlyUpdatedFeeds("PROD");
		toBeUpdatedFeedsProd = findtoBeUpdatedFeeds("PROD");

		topHitsPta  = findTopHits("PTA");
		newlyUpdatedFeedsPta = findNewlyUpdatedFeeds("PTA");
		toBeUpdatedFeedsPta = findtoBeUpdatedFeeds("PTA");
		
		topHitsIt = findTopHits("IT");
		newlyUpdatedFeedsIt = findNewlyUpdatedFeeds("IT");
		toBeUpdatedFeedsIt = findtoBeUpdatedFeeds("IT");
	}
	
	private List<TopSearchesInMdms> findTopHits(String Env){
		List<TopSearchesInMdms> topSearches = getEntityManager().createNamedQuery(
				"TopSearchesInMdms.findAll", TopSearchesInMdms.class).setParameter("instance", Env)
				.getResultList();
		closeEntityManager();
		return topSearches;
	}
	
	private List<NewlyUpdatedFeeds> findNewlyUpdatedFeeds(String Env){
		List<NewlyUpdatedFeeds> newlyUpdateFeeds = getEntityManager().createNamedQuery(
				"NewlyUpdatedFeeds.findAll", NewlyUpdatedFeeds.class).setParameter("instance", Env)
				.getResultList();
		closeEntityManager();		
		return newlyUpdateFeeds;
	}
	
	private List<UpcomingFeedUpdate> findtoBeUpdatedFeeds(String Env){
		List<UpcomingFeedUpdate> upcomingFeedUpdate = getEntityManager().createNamedQuery(
				"UpcomingFeedUpdate.findAll", UpcomingFeedUpdate.class).setParameter("instance", Env)
				.getResultList();
		closeEntityManager();		
		return upcomingFeedUpdate;
	}

}