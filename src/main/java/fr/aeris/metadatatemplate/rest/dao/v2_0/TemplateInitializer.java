package fr.aeris.metadatatemplate.rest.dao.v2_0;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.config.Constants;
import fr.aeris.metadatatemplate.rest.domain.v2_0.Criteria;
import fr.aeris.metadatatemplate.rest.domain.v2_0.MetadataTemplates;
import fr.aeris.metadatatemplate.rest.domain.v2_0.Template;

@Component("TemplateInitializer_v2")
public class TemplateInitializer {

	@Autowired
	@Qualifier("MetadataTemplateDaoMongoImpl_v2")
	MetadataTemplateDao metadataTemplateDao;

	@Autowired
	@Qualifier("CriteriaDaoMongoImpl_v2")
	CriteriaDao criteriaDao;

	@PostConstruct
	public void initMetadataTemplate() {
		List<MetadataTemplates> templates = metadataTemplateDao.findAll();
		if (templates.size() == 0) {
			MetadataTemplates defaultTemplates = new MetadataTemplates();
			defaultTemplates.setName(Constants.DEFAULT);

			Template defaultCatalogueTemplate = new Template();
			defaultCatalogueTemplate.addMetadataBlock("aeris-metadata-title", true);
			defaultCatalogueTemplate.addMetadataBlock("aeris-metadata-description", true);
			defaultCatalogueTemplate.addMetadataBlock("aeris-metadata-contacts", true);
			defaultCatalogueTemplate.addMetadataBlock("aeris-metadata-information-links", true);
			defaultCatalogueTemplate.addMetadataBlock("aeris-metadata-publications", true);

			defaultTemplates.addTemplate(Constants.DEFAULT, defaultCatalogueTemplate);
			metadataTemplateDao.save(defaultTemplates);

		}
	}

	@PostConstruct
	public void initCriteriaTemplate() {
		List<Criteria> criteria = criteriaDao.findAll();
		if (criteria.size() == 0) {
			Criteria defaultCriteria = new Criteria();
			defaultCriteria.setCatalogueName(Constants.DEFAULT);

			List<String> blocs = new ArrayList<>();
			blocs.add("data-aeris-keyword-search-criteria");
			blocs.add("data-aeris-temporal-extents-search-criteria");
			blocs.add("data-aeris-spatial-extents-search-criteria");
			blocs.add("data-aeris-project-search-criteria");
			blocs.add("aeris-parameter-search-criteria");
			blocs.add("aeris-platform-search-criteria");
			blocs.add("aeris-instrument-search-criteria");
			blocs.add("aeris-levels-search-criteria");
			blocs.add("data-aeris-collection-search-criteria-content");

			defaultCriteria.setCriteria(blocs);

			criteriaDao.save(defaultCriteria);
		}
	}

}
