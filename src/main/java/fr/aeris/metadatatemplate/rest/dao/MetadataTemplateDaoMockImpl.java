package fr.aeris.metadatatemplate.rest.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.aeris.metadatatemplate.rest.config.Profiles;
import fr.aeris.metadatatemplate.rest.domain.MetadataTemplate;

@Component
@Profile(Profiles.OFFLINE_PROFILE)
public class MetadataTemplateDaoMockImpl implements MetadataTemplateDao {

	private Map<String, MetadataTemplate> templates = new HashMap<>();

	@Override
	public MetadataTemplate findByName(String templateName) throws Exception {
		MetadataTemplate metadataTemplate = templates.get(templateName.toLowerCase());
		if (metadataTemplate != null) {
			return metadataTemplate;
		} else {
			throw new Exception("Template " + templateName + " not found");
		}
	}

	@Override
	public void delete(String id) {
		MetadataTemplate template = findById(id);
		if (template != null) {
			templates.remove(getKey(template));
		}

	}

	private MetadataTemplate findById(String id) {
		Collection<MetadataTemplate> values = templates.values();
		for (MetadataTemplate metadataTemplate : values) {
			if (metadataTemplate.getId().equalsIgnoreCase(id)) {
				return metadataTemplate;
			}
		}
		return null;
	}

	@Override
	public MetadataTemplate save(MetadataTemplate metadataTemplate) {
		templates.put(getKey(metadataTemplate), metadataTemplate);
		return metadataTemplate;
	}

	private String getKey(MetadataTemplate metadataTemplate) {
		return metadataTemplate.getName().toLowerCase();
	}

	@Override
	public List<MetadataTemplate> findAll() {
		List<MetadataTemplate> result = new ArrayList<MetadataTemplate>();
		result.addAll(templates.values());
		return result;
	}

}
