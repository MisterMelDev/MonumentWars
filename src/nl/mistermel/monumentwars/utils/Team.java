package nl.mistermel.monumentwars.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Team {
	
	private String name;
	private ItemStack build;
	private Color color;
	private Set<UUID> players = new HashSet<UUID>();
	
	public Team(String name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	public void setBuild(Color color) {
		@SuppressWarnings("deprecation")
		ItemStack build = new ItemStack(Material.STAINED_CLAY, 64,(byte) DyeColor.getByColor(color).getDyeData());
		this.build = build;
	}

	public ItemStack getBuild() {
		return build;
	}

	public void setBuild(ItemStack build) {
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
	
	public void removePlayer(UUID uuid) {
		players.remove(uuid);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

}
