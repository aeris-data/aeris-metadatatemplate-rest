package fr.aeris.metadatatemplate.rest.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

@Component
public class MetadataTemplateDaoMockImpl implements MetadataTemplateDao {

	private Map<String, MetadataTemplate> templates = new HashMap<>();

	@Override
	public MetadataTemplate findByName(String templateName) throws Exception {
		MetadataTemplate metadataTemplate = templates.get(templateName.toLowerCase());
		if (metadataTemplate != null) {
			return metadataTemplate;
		} else {
			throw new Exception("Template " + templateName + " not found");
		}
	}

	private void add(MetadataTemplate template) {
		templates.put(template.getName().toLowerCase(), template);
	}

	@PostConstruct
	private void init() {
		MetadataTemplate template1 = new MetadataTemplate();
		template1.setName("Template1");
		/**
		 * TEMPLATE1-----------------------------------------------------------------------------------------------------------
		 */
		
		/**
		 * METADATA BLOCKS
		 */
		template1.addMetadataBlock("contacts");
//		template1.addMetadataBlock("data-links");
		template1.addMetadataBlock("description");
//		template1.addMetadataBlock("information");
//		template1.addMetadataBlock("information-links");
//		template1.addMetadataBlock("instruments");
//		template1.addMetadataBlock("modification");
//		template1.addMetadataBlock("parameters");
//		template1.addMetadataBlock("platforms");
//		template1.addMetadataBlock("publications");
//		template1.addMetadataBlock("quicklook-gallery");
//		template1.addMetadataBlock("spatial-extents");
//		template1.addMetadataBlock("temporal-extents");
	
		
		/**
		 * DOWLOAD BLOCKS
		 */
//		template1.addDownloadBlock("citations");
//		template1.addDownloadBlock("data-links");
//		template1.addDownloadBlock("datapolicy");
		template1.addDownloadBlock("formats");
//		template1.addDowloadBlock("single-file-download");
//		template1.addDownloadBlock("year-select-download");

		/**
		 * TEMPLATE2-----------------------------------------------------------------------------------------------------------
		 */
		MetadataTemplate template2 = new MetadataTemplate();
		template2.setName("Template2");
		
		/**
		 * METADATA BLOCKS
		 */
		template2.addMetadataBlock("abstract");
		template2.addMetadataBlock("contacts");
		
		/**
		 * DOWLOAD BLOCKS
		 */
		template2.addDownloadBlock("otherdownload");

		add(template1);
		add(template2);

	}

}

