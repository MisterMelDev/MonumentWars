package nl.mistermel.monumentwars;

import org.bukkit.plugin.java.JavaPlugin;

public class MonumentWars extends JavaPlugin {
	
	private static MonumentWars instance;
	
	private ArenaManager arenaMan;
	
	@Override
	public void onEnable() {
		instance = this;
		this.arenaMan = new ArenaManager();
		
		arenaMan.load();
	}
	
	@Override
	public void onDisable() {
		arenaMan.save();
	}
	
	public ArenaManager getArenaMan() {
		return arenaMan;
	}
	
	public static MonumentWars getInstance() {
		return instance;
	}
	
}
