package nl.mistermel.monumentwars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Arena {
	
	private String name;
	private int min, max, countdown;
	private Set<UUID> players = new HashSet<UUID>();
	private Map<Location, Block> placedBlocks = new HashMap<Location, Block>();
	private Location lobby;
	private Map<Team, Location> teamSpawns = new HashMap<Team, Location>();
	
	public Arena(String name, int min, int max) {
		this.name = name;
		this.min = min;
		this.max = max;
	}
	
	public Location getSpawn(Team team) {
		return teamSpawns.get(team);
	}
	
	public Location getLobby() {
		return lobby;
	}
	
	public List<Player> getPlayers() {
		List<Player> list = new ArrayList<Player>();
		for(UUID u : players) {
			list.add(Bukkit.getPlayer(u));
		}
		return list;
	}
	
	public Map<Team, Location> getTeamSpawns() {
		return teamSpawns;
	}
	
	public Map<Location, Block> getPlacedBlocks() {
		return placedBlocks;
	}
	
	public int getMaxPlayers() {
		return max;
	}
	
	public int getMinPlayers() {
		return min;
	}
	
	public String getName() {
		return name;
	}
	
}
