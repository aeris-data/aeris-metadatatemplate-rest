package fr.aeris.metadatatemplate.rest.service.v1_0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.aeris.metadatatemplate.rest.dao.MetadataTemplateDao;
import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

@RestController
@CrossOrigin
@RequestMapping(value = "/template")
public class MetadataTemplateService {

	@Autowired
	MetadataTemplateDao dao;

	@RequestMapping(value = "/isalive", method = RequestMethod.GET)
	public String isalive() {
		return "yes";
	}

	@RequestMapping(value = "/byname/{templateName}", method = RequestMethod.GET)
	public MetadataTemplate getMetadataTemplate(@PathVariable("templateName") String templateName) {
		try {
			return dao.findByName(templateName);
		} catch (Exception e) {
			throw new RuntimeException("No corresponding template");
		}
	}

}
