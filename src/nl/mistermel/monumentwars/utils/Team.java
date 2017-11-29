package nl.mistermel.monumentwars.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Team {
	
	private String name;
	private Set<UUID> players = new HashSet<UUID>();
	
	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UUID> getPlayers() {
		return players;
	}
	
	

}
