package fr.aeris.metadatatemplate.rest.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetadataTemplate {
	
	private String name;
	private List<String> metadataTab;
	private List<String> dowloadTab;
	private List<String> statisticsTab;
	private List<String> visualisationTab;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMetadataTab() {
		return metadataTab;
	}

	public void setMetadataTab(List<String> metadataTab) {
		this.metadataTab = metadataTab;
	}

	public List<String> getDowloadTab() {
		return dowloadTab;
	}

	public void setDowloadTab(List<String> dowloadTab) {
		this.dowloadTab = dowloadTab;
	}

	public List<String> getStatisticsTab() {
		return statisticsTab;
	}

	public void setStatisticsTab(List<String> statisticsTab) {
		this.statisticsTab = statisticsTab;
	}

	public List<String> getVisualisationTab() {
		return visualisationTab;
	}
	
	public void setVisualisationTab(List<String> visualisationTab) {
		this.visualisationTab = visualisationTab;
	}

	public void addMetadataBlock(String blockName) {
		if (metadataTab == null) {
			metadataTab = new ArrayList<>();
		}
		metadataTab.add(blockName);
	}

	public void addDowloadBlock(String blockName) {
		if (dowloadTab == null) {
			dowloadTab = new ArrayList<>();
		}
		dowloadTab.add(blockName);
	}
	
	public void addStatisticsBlock(String blockName) {
		if (statisticsTab == null) {
			statisticsTab = new ArrayList<>();
		}
		statisticsTab.add(blockName);
	}
	
	public void addVisualisationBlock(String blockName) {
		if (visualisationTab == null) {
			visualisationTab = new ArrayList<>();
		}
		visualisationTab.add(blockName);
	}

}
