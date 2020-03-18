package fr.aeris.metadatatemplate.rest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

public interface MetadataTemplateRepository extends MongoRepository<MetadataTemplate, String> {

	MetadataTemplate findByName(String templateName);

}
