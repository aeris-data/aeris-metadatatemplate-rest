package fr.aeris.metadatatemplate.rest.service.v1_0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.aeris.metadatatemplate.rest.dao.MetadataTemplateDao;
import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController("MetadataTemplateService_v1")
@CrossOrigin
@RequestMapping(value = "/template")
@Api(tags = "Metadata template service - Version 1", description = " ")
@SwaggerDefinition(info = @Info(description = "Metadata template service", version = "V1", title = "Metadata template service"))
public class MetadataTemplateService {

	@Autowired
	MetadataTemplateDao dao;

	@RequestMapping(value = "/isalive", method = RequestMethod.GET)
	public String isalive() {
		return "yes";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<MetadataTemplate> list() {
		return dao.findAll();
	}

	@RequestMapping(value = "/byname/{templateName}", method = RequestMethod.GET)
	public MetadataTemplate getMetadataTemplate(@PathVariable("templateName") String templateName) {
		try {
			return dao.findByName(templateName);
		} catch (Exception e) {
			throw new RuntimeException("No corresponding template");
		}
	}

	@RequestMapping(value = "/byname/{templateName}", method = RequestMethod.DELETE)
	public void deleteMetadataTemplate(@PathVariable("templateName") String templateName) {
		MetadataTemplate template = null;
		try {
			template = dao.findByName(templateName);
		} catch (Exception e) {
			throw new RuntimeException("No corresponding template");
		}
		if (template == null) {
			return;
		} else {
			dao.delete(template.getId());
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public MetadataTemplate save(@RequestBody MetadataTemplate template) {
		if (template == null) {
			throw new RuntimeException();
		} else {
			MetadataTemplate byName = null;
			try {
				byName = dao.findByName(template.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (byName != null) {
				dao.delete(byName.getId());
			}

		}
		return dao.save(template);
	}

}
