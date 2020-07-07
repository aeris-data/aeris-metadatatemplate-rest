package fr.aeris.metadatatemplate.rest.domain.v2_0;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TypeAlias("metadataTemplates_v2")
@Document(collection = MetadataTemplates.COLLECTION_NAME, language = "english")
public class MetadataTemplates {

	public final static String DEFAULT_CATALOG = "default";

	@Id
	private String id;

	public final static String COLLECTION_NAME = "templates_v2";

	private String name;

	private Map<String, Template> templates;

	public void addTemplate(String catalogueName, Template template) {
		if (templates == null) {
			templates = new HashMap<>();
		}
		templates.put(catalogueName, template);
	}

	public void addTemplate(Template template) {
		if (templates == null) {
			templates = new HashMap<>();
		}
		templates.put(MetadataTemplates.DEFAULT_CATALOG, template);
	}

}
