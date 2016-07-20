package org.kornogcomputing.bossanova;

public enum Action {
	
	Default(""),
	Cancel("Cancel"),
	Delete("Delete"),
	ToAction("ToAction"),
	Validate("Validate")
	;

	private String name;
	/**
	 * @param name
	 */
	private Action(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public static Action valueOfByName(final String name) {
		for (final Action values : values()) {
			if (values.getName().equalsIgnoreCase(name)) {
				return values;
			}
		}
		return Default;
	}
	
}
