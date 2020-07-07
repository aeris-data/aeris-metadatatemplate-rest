package fr.aeris.metadatatemplate.rest.domain.v2_0;

import java.util.ArrayList;
import java.util.List;

public class Template {

	private List<Bloc> metadataTab;
	private List<Bloc> downloadTab;
	private List<Bloc> statisticsTab;
	private List<Bloc> visualisationTab;

	public List<Bloc> getMetadataTab() {
		return metadataTab;
	}

	public void setMetadataTab(List<Bloc> metadataTab) {
		this.metadataTab = metadataTab;
	}

	public List<Bloc> getDownloadTab() {
		return downloadTab;
	}

	public void setDownloadTab(List<Bloc> downloadTab) {
		this.downloadTab = downloadTab;
	}

	public List<Bloc> getStatisticsTab() {
		return statisticsTab;
	}

	public void setStatisticsTab(List<Bloc> statisticsTab) {
		this.statisticsTab = statisticsTab;
	}

	public List<Bloc> getVisualisationTab() {
		return visualisationTab;
	}

	public void setVisualisationTab(List<Bloc> visualisationTab) {
		this.visualisationTab = visualisationTab;
	}

	public void addMetadataBlock(String blockName, boolean editable) {
		if (metadataTab == null) {
			metadataTab = new ArrayList<>();
		}
		metadataTab.add(new Bloc(blockName, editable));
	}

	public void addDownloadBlock(String blockName, boolean editable) {
		if (downloadTab == null) {
			downloadTab = new ArrayList<>();
		}
		downloadTab.add(new Bloc(blockName, editable));
	}

	public void addStatisticsBlock(String blockName, boolean editable) {
		if (statisticsTab == null) {
			statisticsTab = new ArrayList<>();
		}
		statisticsTab.add(new Bloc(blockName, editable));
	}

	public void addVisualisationBlock(String blockName, boolean editable) {
		if (visualisationTab == null) {
			visualisationTab = new ArrayList<>();
		}
		visualisationTab.add(new Bloc(blockName, editable));
	}

}
