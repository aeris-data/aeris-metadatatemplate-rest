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
		template1.addDowloadBlock("download");
		template1.addMetadataBlock("contacts");

		MetadataTemplate template2 = new MetadataTemplate();
		template2.setName("Template2");
		template2.addDowloadBlock("otherdownload");
		template2.addMetadataBlock("abstract");
		template2.addMetadataBlock("contacts");

		add(template1);
		add(template2);

	}

}
