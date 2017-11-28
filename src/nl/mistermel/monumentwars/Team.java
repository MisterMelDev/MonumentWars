package nl.mistermel.monumentwars;

public enum Team {
	
	RED("Red"), BLUE("Blue");
	
	private String name;
	
	Team(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
