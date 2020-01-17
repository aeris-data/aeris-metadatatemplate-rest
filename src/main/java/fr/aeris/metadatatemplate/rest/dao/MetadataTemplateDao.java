package fr.aeris.metadatatemplate.rest.dao;

import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

public interface MetadataTemplateDao {

	MetadataTemplate findByName(String templateName) throws Exception;

}
