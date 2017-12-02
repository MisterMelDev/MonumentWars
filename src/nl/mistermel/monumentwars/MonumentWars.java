package nl.mistermel.monumentwars;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import nl.mistermel.monumentwars.commands.HelpCommand;
import nl.mistermel.monumentwars.commands.handler.CommandHandler;
import nl.mistermel.monumentwars.managers.ArenaManager;
import nl.mistermel.monumentwars.managers.ConfigManager;

public class MonumentWars extends JavaPlugin {
	
	private static MonumentWars instance;
	private ArenaManager arenaMan;
	private CommandHandler cmdHandle;
	private ConfigManager configMan;
	
	@Override
	public void onEnable() {
		instance = this;
		this.arenaMan = new ArenaManager();
		this.cmdHandle = new CommandHandler();
		this.configMan = new ConfigManager(this);
		
		this.getCommand("monumentwars").setExecutor(this.cmdHandle);
		this.registerCmd();
		this.loadConfig();
		
		arenaMan.loadAllArenas();
	}
	
	private void registerCmd() {
		this.cmdHandle.registerCommand(new HelpCommand());
	}
	
	private void setDefaults() {
		FileConfiguration config = configMan.getConfig();
		config.addDefault("game.countdown", 10);
		config.options().copyDefaults(true);
		configMan.save();
	}
	
	private void loadConfig() {
		setDefaults();
	}
	
	@Override
	public void onDisable() {
		arenaMan.saveAllArenas();
	}
	
	public ArenaManager getArenaMan() {
		return arenaMan;
	}
	
	public CommandHandler getCommandHandle() {
		return cmdHandle;
	}
	
	public static MonumentWars getInstance() {
		return instance;
	}
	
}
