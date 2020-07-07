package fr.aeris.metadatatemplate.rest.domain.v2_0;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bloc {

	private String name;
	private boolean editable;
	private String options;

	public Bloc() {
	}

	public Bloc(String name, boolean editable) {
		this.name = name;
		this.editable = editable;
	}
}
