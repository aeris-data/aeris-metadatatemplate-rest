package fr.aeris.metadatatemplate.rest.dao.v2_0;

import java.util.List;

import fr.aeris.metadatatemplate.rest.domain.v2_0.MetadataTemplates;

public interface MetadataTemplateDao {

	MetadataTemplates findByName(String templateName, boolean returnDefault) throws Exception;

	void delete(String id);

	MetadataTemplates save(MetadataTemplates metadataTemplate);

	List<MetadataTemplates> findAll();

}
