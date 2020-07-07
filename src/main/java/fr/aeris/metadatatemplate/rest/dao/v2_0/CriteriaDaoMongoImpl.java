package fr.aeris.metadatatemplate.rest.dao.v2_0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.config.Constants;
import fr.aeris.metadatatemplate.rest.domain.v2_0.Criteria;

@Component("CriteriaDaoMongoImpl_v2")
public class CriteriaDaoMongoImpl implements CriteriaDao {

	@Autowired
	CriteriaRepositoryV2 repository;

	@Override
	public List<Criteria> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String id) {

		repository.deleteById(id);
	}

	@Override
	public Criteria save(Criteria criteria) {
		return repository.save(criteria);
	}

	@Override
	public Criteria findByCatalogueName(String catalogueName, boolean returnDefault) throws Exception {
		Criteria result = repository.findByCatalogueName(catalogueName);
		if (result == null) {
			if (returnDefault) {
				return repository.findByCatalogueName(Constants.DEFAULT);
			} else {
				return null;
			}
		} else {
			return result;
		}
	}

}
