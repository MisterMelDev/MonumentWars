package nl.mistermel.monumentwars.managers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import nl.mistermel.monumentwars.Arena;
import nl.mistermel.monumentwars.MonumentWars;
import nl.mistermel.monumentwars.utils.Team;

public class ArenaManager {
	
	private Set<Arena> arenas = new HashSet<Arena>();
	
	public Map<String, Color> allowedColors = new HashMap<String, Color>();
	
	private ConfigManager cm = new ConfigManager(MonumentWars.getInstance());
	private FileConfiguration data = cm.getData();
	
	public void newArena(String name) {
		arenas.add(new Arena(name, 4, 15, false));
	}
	
	public Arena getArena(String name) {
		for(Arena a : arenas) {
			if(a.getName().equals(name)) return a;
		}
		return null;
	}
	
	public Map<String, Color> getAllowedColors() {
		return allowedColors;
	}
	
	public boolean ingame(UUID uuid) {
		for(Arena a : arenas) {
			return a.getPlayers().contains(uuid);
		}
		return false;
	}
	
	public void loadAllArenas() {
		for(String key : data.getConfigurationSection("arenas").getKeys(true)) {
			load(key);
		}
	}
	
	public void saveAllArenas() {
		for(Arena a : arenas) {
			save(a);
		}
	}
	
	public void removeArena(Arena a) {
		arenas.remove(a);
		if(!data.contains("arenas." + a.getName())) return;
		data.set("arenas." + a.getName(), null);
	}
	
	public void load(String name) {
		if(!data.contains("arenas." + name)) return;
		
		int min = data.getInt("arenas." + name + ".min");
		int max = data.getInt("arenas." + name + ".max");
		
		World world = Bukkit.getWorld(data.getString("arenas." + name + ".lobby.world"));
		int x = data.getInt("arenas." + name + ".lobby.x");
		int y = data.getInt("arenas." + name + ".lobby.y");
		int z = data.getInt("arenas." + name + ".lobby.z");
		Location lobby = new Location(world,x,y,z);
		
		Arena a = new Arena(name, min, max, data.getBoolean("arenas." + name + ".active"));
		
		for(String key : data.getConfigurationSection("arenas." + name + ".teams").getKeys(true)) {
			String color = "WHITE";
			if(allowedColors.containsKey(data.getString("arenas." + name + ".teams." + key + ".color"))) {
				color = data.getString("arenas." + name + ".teams." + key + ".color");
			}
			Color c = allowedColors.get(color);
			Team t = new Team(key, c);
			a.getTeams().add(t);
			a.getTeamSpawns().put(t, new Location(Bukkit.getWorld(data.getString("arenas." + name + ".teams." + t.getName() + ".world")),
					data.getInt("arenas." + name + ".teams." + t.getName() + ".x"),
					data.getInt("arenas." + name + ".teams." + t.getName() + ".y"),
					data.getInt("arenas." + name + ".teams." + t.getName() + ".z")));
		}
		a.setLobby(lobby);
		arenas.add(a);
		
	}
	
	public void save(Arena a) {
		String name = a.getName();
		int min = a.getMinPlayers();
		int max = a.getMaxPlayers();
		Location lobby = a.getLobby();
		//How to save map into config?
		for (Team t : a.getTeamSpawns().keySet()) {
			Location loc = a.getTeamSpawn(t.getName());
			data.set("arenas." + name + ".teams." + t.getName() + ".world", loc.getWorld().getName());
			data.set("arenas." + name + ".teams." + t.getName() + ".x", loc.getX());
			data.set("arenas." + name + ".teams." + t.getName() + ".y", loc.getY());
			data.set("arenas." + name + ".teams." + t.getName() + ".z", loc.getZ());
			data.set("arenas." + name + ".teams." + t.getName() + ".color", t.getColor());
			} 
		
		data.set("arenas." + name + ".lobby.world", lobby.getWorld().getName());
		data.set("arenas." + name + ".lobby.x", lobby.getX());
		data.set("arenas." + name + ".lobby.y", lobby.getY());
		data.set("arenas." + name + ".lobby.z", lobby.getZ());
		
		data.set("arenas." + name + ".min", min);
		data.set("arenas." + name + ".min", max);
		
		data.set("arenas." + name + ".active", a.isActive());
		
		cm.save();
	}
}
