package fr.aeris.metadatatemplate.rest.service.v2_0;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.aeris.metadatatemplate.rest.dao.v2_0.CriteriaDao;
import fr.aeris.metadatatemplate.rest.domain.v2_0.Criteria;
import io.swagger.annotations.Api;

@RestController("CriteriaService_v2")
@Api(tags = "Search criteria service - Version 2", description = " ")
@CrossOrigin
@RequestMapping(value = "/criteria/v2")
public class CriteriaService {

	@Autowired
	CriteriaDao dao;

	@RequestMapping(value = "/isalive", method = RequestMethod.GET)
	public String isalive() {
		return "yes";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Criteria> list() {
		return dao.findAll();
	}

	@RequestMapping(value = "/bycataloguename/{catalogueName}", method = RequestMethod.GET)
	public Criteria getCriteria(@PathVariable("catalogueName") String catalogueName, HttpServletResponse response) {
		try {
			response.setHeader("Cache-Control", "max-age=600, private");
			return dao.findByCatalogueName(catalogueName, true);
		} catch (Exception e) {
			throw new RuntimeException("No corresponding template");
		}
	}

	@RequestMapping(value = "/bycataloguename/{catalogueName}", method = RequestMethod.DELETE)
	public void deleteMetadataTemplate(@PathVariable("catalogueName") String catalogueName) {
		Criteria criteria = null;
		try {
			criteria = dao.findByCatalogueName(catalogueName, false);
		} catch (Exception e) {
			throw new RuntimeException("No corresponding template");
		}
		if (criteria == null) {
			return;
		} else {
			dao.delete(criteria.getId());
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public Criteria save(@RequestBody Criteria criteria) {
		if (criteria == null) {
			throw new RuntimeException();
		} else {
			Criteria byName = null;
			try {
				byName = dao.findByCatalogueName(criteria.getCatalogueName(), false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (byName != null) {
				dao.delete(byName.getId());
			}

		}
		return dao.save(criteria);
	}

}
