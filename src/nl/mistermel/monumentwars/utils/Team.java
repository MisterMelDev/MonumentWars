package nl.mistermel.monumentwars.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Material;

public class Team {
	
	private String name;
	private Material build;
	private Set<UUID> players = new HashSet<UUID>();
	
	public Team(String name, Material build) {
		this.name = name;
		this.build = build;
	}

	public Material getBuild() {
		return build;
	}

	public void setBuild(Material build) {
		this.build = build;
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
	
	public void addPlayer(UUID uuid) {
		players.add(uuid);
	}

}
