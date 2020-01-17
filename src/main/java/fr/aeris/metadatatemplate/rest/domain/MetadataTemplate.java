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

}
