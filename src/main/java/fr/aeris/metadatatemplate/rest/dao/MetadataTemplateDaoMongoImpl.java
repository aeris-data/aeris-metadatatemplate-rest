package fr.aeris.metadatatemplate.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

@Component("MetadataTemplateDaoMongoImpl_v1")
public class MetadataTemplateDaoMongoImpl implements MetadataTemplateDao {

	@Autowired
	MetadataTemplateRepository repository;

	@Override
	public List<MetadataTemplate> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String id) {

		repository.deleteById(id);
	}

	@Override
	public MetadataTemplate save(MetadataTemplate metadataTemplate) {
		return repository.save(metadataTemplate);
	}

	@Override
	public MetadataTemplate findByName(String templateName) throws Exception {
		return repository.findByName(templateName);
	}

}
