package fr.aeris.metadatatemplate.rest.domain.v2_0;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bloc {

	private String name;
	private boolean editable;
	private Map<String, String> props;

	public Bloc() {
	}

	public Bloc(String name, boolean editable) {
		this.name = name;
		this.editable = editable;
	}

	public Map<String, String> getProps() {
		if (props == null) {
			return new HashMap<String, String>();
		} else {
			return props;
		}
	}
}
