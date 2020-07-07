package fr.aeris.metadatatemplate.rest.dao.v2_0;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.aeris.metadatatemplate.rest.domain.v2_0.MetadataTemplates;

public interface MetadataTemplateV2Repository extends MongoRepository<MetadataTemplates, String> {

	MetadataTemplates findByName(String templateName);

}
