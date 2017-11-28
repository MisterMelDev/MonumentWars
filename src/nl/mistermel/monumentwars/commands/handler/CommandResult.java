package nl.mistermel.monumentwars.commands.handler;

import org.bukkit.ChatColor;

public enum CommandResult {
	
	PLAYERS_ONLY(ChatColor.RED + "This command can only be used by players!"),
	SUCCESS(null);
	
	private String msg;
	
	private CommandResult(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
}
