package fr.aeris.metadatatemplate.rest.dao.v2_0;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.aeris.metadatatemplate.rest.domain.v2_0.Criteria;

public interface CriteriaRepositoryV2 extends MongoRepository<Criteria, String> {

	Criteria findByCatalogueName(String catalogueName);

}
