package fr.aeris.metadatatemplate.rest.domain.v2_0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TypeAlias("criteria_v2")
@Document(collection = Criteria.COLLECTION_NAME, language = "english")
public class Criteria {

	public final static String COLLECTION_NAME = "criteria_v2";

	@Id
	private String id;

	String catalogueName;
	List<String> criteria = new ArrayList<>();
}
