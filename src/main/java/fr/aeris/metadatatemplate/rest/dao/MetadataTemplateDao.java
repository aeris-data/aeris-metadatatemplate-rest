package fr.aeris.metadatatemplate.rest.dao;

import java.util.List;

import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

public interface MetadataTemplateDao {

	MetadataTemplate findByName(String templateName) throws Exception;

	void delete(String id);

	MetadataTemplate save(MetadataTemplate metadataTemplate);

	List<MetadataTemplate> findAll();

}
