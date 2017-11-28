package nl.mistermel.monumentwars;

import org.bukkit.plugin.java.JavaPlugin;

import nl.mistermel.monumentwars.commands.HelpCommand;
import nl.mistermel.monumentwars.commands.handler.CommandHandler;
import nl.mistermel.monumentwars.managers.ArenaManager;

public class MonumentWars extends JavaPlugin {
	
	private static MonumentWars instance;
	private ArenaManager arenaMan;
	private CommandHandler cmdHandle;
	
	@Override
	public void onEnable() {
		instance = this;
		this.arenaMan = new ArenaManager();
		this.cmdHandle = new CommandHandler();
		
		this.getCommand("monumentwars").setExecutor(this.cmdHandle);
		this.registerCmd();
		
		arenaMan.load();
	}
	
	private void registerCmd() {
		this.cmdHandle.registerCommand(new HelpCommand());
	}
	
	@Override
	public void onDisable() {
		arenaMan.save();
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
