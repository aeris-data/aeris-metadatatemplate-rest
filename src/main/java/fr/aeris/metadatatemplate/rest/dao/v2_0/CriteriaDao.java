package fr.aeris.metadatatemplate.rest.dao.v2_0;

import java.util.List;

import fr.aeris.metadatatemplate.rest.domain.v2_0.Criteria;

public interface CriteriaDao {

	Criteria findByCatalogueName(String catalogueName, boolean returnDefault) throws Exception;

	void delete(String id);

	Criteria save(Criteria metadataTemplate);

	List<Criteria> findAll();

}
