package fr.aeris.metadatatemplate.rest.dao.v2_0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.config.Constants;
import fr.aeris.metadatatemplate.rest.domain.v2_0.MetadataTemplates;

@Component("MetadataTemplateDaoMongoImpl_v2")
public class MetadataTemplateDaoMongoImpl implements MetadataTemplateDao {

	@Autowired
	MetadataTemplateV2Repository repository;

	@Override
	public List<MetadataTemplates> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String id) {

		repository.deleteById(id);
	}

	@Override
	public MetadataTemplates save(MetadataTemplates metadataTemplate) {
		return repository.save(metadataTemplate);
	}

	@Override
	public MetadataTemplates findByName(String templateName, boolean returnDefault) throws Exception {
		MetadataTemplates result = repository.findByName(templateName);
		if (result == null) {
			if (returnDefault) {
				return repository.findByName(Constants.DEFAULT);
			} else {
				return null;
			}
		} else {
			return result;
		}
	}

}
