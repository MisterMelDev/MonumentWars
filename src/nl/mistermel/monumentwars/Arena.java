package nl.mistermel.monumentwars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Arena {
	
	private String name;
	private Location lobby;
	private int min, max, countdown;
	private Set<UUID> players = new HashSet<UUID>();
	private Map<Location, Block> placedBlocks = new HashMap<Location, Block>();
	
	
	public Arena(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
