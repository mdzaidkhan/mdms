package org.metadata.dashboard;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mdms.jpa.entities.MetadataAutovsmanualStats;
import mdms.jpa.entities.MetadataCapStats;
import mdms.jpa.entity.manager.EntityManagerBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class DashBoardChartView extends EntityManagerBean implements Serializable{
	private static final long serialVersionUID = 5107063284689855428L;
	private PieChartModel pieModelPROD1;
	private PieChartModel pieModelPROD2;
	private PieChartModel pieModelPTA1;
	private PieChartModel pieModelPTA2;
	private PieChartModel pieModelIT1;
	private PieChartModel pieModelIT2;
	private String colorSeriesGreenOrange = "32CD32,FFA500";
	private String colorSeriesGreenRed = "32CD32,FF0000";
	private String legendPosition = "2";

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModelPROD1() {
		return pieModelPROD1;
	}

	public void setPieModelPROD1(PieChartModel pieModelPROD1) {
		this.pieModelPROD1 = pieModelPROD1;
	}

	public PieChartModel getPieModelPROD2() {
		return pieModelPROD2;
	}

	public void setPieModelPROD2(PieChartModel pieModelPROD2) {
		this.pieModelPROD2 = pieModelPROD2;
	}

	public PieChartModel getPieModelPTA1() {
		return pieModelPTA1;
	}

	public void setPieModelPTA1(PieChartModel pieModelPTA1) {
		this.pieModelPTA1 = pieModelPTA1;
	}

	public PieChartModel getPieModelPTA2() {
		return pieModelPTA2;
	}

	public void setPieModelPTA2(PieChartModel pieModelPTA2) {
		this.pieModelPTA2 = pieModelPTA2;
	}

	public PieChartModel getPieModelIT1() {
		return pieModelIT1;
	}

	public void setPieModelIT1(PieChartModel pieModelIT1) {
		this.pieModelIT1 = pieModelIT1;
	}

	public PieChartModel getPieModelIT2() {
		return pieModelIT2;
	}

	public void setPieModelIT2(PieChartModel pieModelIT2) {
		this.pieModelIT2 = pieModelIT2;
	}

	private void createPieModels() {
		List<MetadataCapStats> capVsMissingStats = getEntityManager().createNamedQuery(
				"MetadataCapStats.findAll", MetadataCapStats.class)
				.getResultList();
		for (MetadataCapStats metadataCapStats : capVsMissingStats) {
			if (("PROD").equals(metadataCapStats.getInstance())) {
				pieModelPROD1 = createPieModel1(metadataCapStats.getCaptured(),
						metadataCapStats.getMissing());
			} else if (("PTA").equals(metadataCapStats.getInstance())) {
				pieModelPTA1 = createPieModel1(metadataCapStats.getCaptured(),
						metadataCapStats.getMissing());
			} else if (("IT").equals(metadataCapStats.getInstance())) {
				pieModelIT1 = createPieModel1(metadataCapStats.getCaptured(),
						metadataCapStats.getMissing());
			}
		}

		List<MetadataAutovsmanualStats> autoVsManualStats = getEntityManager()
				.createNamedQuery("MetadataAutovsmanualStats.findAll",
						MetadataAutovsmanualStats.class).getResultList();
		for (MetadataAutovsmanualStats metadataAutovsmanualStats : autoVsManualStats) {
			if (("PROD").equals(metadataAutovsmanualStats.getInstance())) {
				pieModelPROD2 = createPieModel2(
						metadataAutovsmanualStats.getAutomatic(),
						metadataAutovsmanualStats.getManual());
			} else if (("PTA").equals(metadataAutovsmanualStats.getInstance())) {
				pieModelPTA2 = createPieModel2(
						metadataAutovsmanualStats.getAutomatic(),
						metadataAutovsmanualStats.getManual());
			} else if (("IT").equals(metadataAutovsmanualStats.getInstance())) {
				pieModelIT2 = createPieModel2(
						metadataAutovsmanualStats.getAutomatic(),
						metadataAutovsmanualStats.getManual());
			}
		}
		closeEntityManager();
	}

	private PieChartModel createPieModel1(int captured, int missing) {
		PieChartModel pieModel = new PieChartModel();

		pieModel.set("Captured", Integer.valueOf(captured));
		pieModel.set("Missing", Integer.valueOf(missing));

		pieModel.setTitle("Overall Health of The MDMS");
		pieModel.setLegendPosition(legendPosition);
		pieModel.setSeriesColors(colorSeriesGreenOrange);
		return pieModel;
	}

	private PieChartModel createPieModel2(int automatic, int manual) {
		PieChartModel pieModel = new PieChartModel();

		pieModel.set("Automatic", Integer.valueOf(automatic));
		pieModel.set("Manual", Integer.valueOf(manual));

		pieModel.setTitle("Automatic vs Manaul Metadata captured in MDMS");
		pieModel.setLegendPosition(legendPosition);
		pieModel.setSeriesColors(colorSeriesGreenRed);
		return pieModel;
	}
}