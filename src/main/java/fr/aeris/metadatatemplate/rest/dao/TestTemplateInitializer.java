package fr.aeris.metadatatemplate.rest.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

@Component
public class TestTemplateInitializer {

	@Autowired
	MetadataTemplateDao dao;

	@PostConstruct
	public void init() {
		List<MetadataTemplate> templates = dao.findAll();
		if (templates.size() == 0) {
			MetadataTemplate template1 = new MetadataTemplate();
			template1.setName("Template1");
			template1.addMetadataBlock("contacts");
			template1.addMetadataBlock("description");
			template1.addMetadataBlock("information");
			template1.addMetadataBlock("information-links");
			template1.addMetadataBlock("publications");
			template1.addMetadataBlock("spatial-extents");
			template1.addMetadataBlock("temporal-extents");
			template1.addDownloadBlock("formats");

			dao.save(template1);

			MetadataTemplate template2 = new MetadataTemplate();
			template2.setName("Template2");
			template2.addMetadataBlock("abstract");
			template2.addMetadataBlock("contacts");
			template2.addDownloadBlock("otherdownload");

			dao.save(template2);

		}
	}

}
