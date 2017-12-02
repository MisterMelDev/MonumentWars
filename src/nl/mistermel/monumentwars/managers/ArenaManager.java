package nl.mistermel.monumentwars.managers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import nl.mistermel.monumentwars.Arena;
import nl.mistermel.monumentwars.MonumentWars;
import nl.mistermel.monumentwars.utils.Team;

public class ArenaManager {
	
	private Set<Arena> arenas = new HashSet<Arena>();
	
	private ConfigManager cm = new ConfigManager(MonumentWars.getInstance());
	private FileConfiguration config = cm.getConfig();
	
	public void newArena(String name) {
		arenas.add(new Arena(name, 4, 15, false));
	}
	
	public Arena getArena(String name) {
		for(Arena a : arenas) {
			if(a.getName().equals(name)) return a;
		}
		return null;
	}
	
	public void load(String name) {
		if(!config.contains("arenas." + name)) return;
		
		
	}
	
	public void save(Arena a) {
		String name = a.getName();
		int min = a.getMinPlayers();
		int max = a.getMaxPlayers();
		Location lobby = a.getLobby();
		Map<Team, Location> teamSpawns = a.getTeamSpawns();
		//How to save map into config?
	}
}
