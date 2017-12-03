package nl.mistermel.monumentwars.commands.handler;

import org.bukkit.ChatColor;

public enum CommandResult {
	
	PLAYERS_ONLY(ChatColor.RED + "This command can only be used by players!"),
	ARENA_NOT_FOUND(ChatColor.RED + "Arena not found!"),
	ARENA_ALREADY_EXISTS(ChatColor.RED + "Arena already exists!"),
	ARENA_NOT_ACTIVE(ChatColor.RED + "Arena isn't active!"),
	TEAM_EXISTS(ChatColor.RED + "Team already exists!"),
	TEAM_CREATED(ChatColor.GREEN + "Team has been created and added to the arena!"),
	INVALID_ARGS(null),
	FAILURE(null),
	SUCCESS(null);
	
	private String msg;
	
	private CommandResult(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
}
