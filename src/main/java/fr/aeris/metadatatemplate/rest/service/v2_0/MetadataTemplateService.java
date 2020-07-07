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

import fr.aeris.metadatatemplate.rest.dao.v2_0.MetadataTemplateDao;
import fr.aeris.metadatatemplate.rest.domain.v2_0.MetadataTemplates;
import io.swagger.annotations.Api;

@RestController("MetadataTemplateService_v2")
@Api(tags = "Metadata template service - Version 2", description = " ")
@CrossOrigin
@RequestMapping(value = "/template/v2")
public class MetadataTemplateService {

	@Autowired
	MetadataTemplateDao dao;

	@RequestMapping(value = "/isalive", method = RequestMethod.GET)
	public String isalive() {
		return "yes";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<MetadataTemplates> list() {
		return dao.findAll();
	}

	@RequestMapping(value = "/byname/{templateName}", method = RequestMethod.GET)
	public MetadataTemplates getMetadataTemplate(@PathVariable("templateName") String templateName,
			HttpServletResponse response) {
		try {
			response.setHeader("Cache-Control", "max-age=600, private");
			return dao.findByName(templateName, true);
		} catch (Exception e) {
			throw new RuntimeException("No corresponding template");
		}
	}

	@RequestMapping(value = "/byname/{templateName}", method = RequestMethod.DELETE)
	public void deleteMetadataTemplate(@PathVariable("templateName") String templateName) {
		MetadataTemplates template = null;
		try {
			template = dao.findByName(templateName, false);
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
	public MetadataTemplates save(@RequestBody MetadataTemplates template) {
		if (template == null) {
			throw new RuntimeException();
		} else {
			MetadataTemplates byName = null;
			try {
				byName = dao.findByName(template.getName(), false);
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
