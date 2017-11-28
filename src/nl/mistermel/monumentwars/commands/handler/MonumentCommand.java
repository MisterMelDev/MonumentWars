package nl.mistermel.monumentwars.commands.handler;

import org.bukkit.command.CommandSender;

public abstract class MonumentCommand {
	
	private String label;
	private String[] args;
	private String description;
	
	public MonumentCommand(String label, String description, String... args) {
		this.label = label;
		this.args = args;
		this.description = description;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String[] getArgs() {
		return args;
	}
	
	public String getDescription() {
		return description;
	}
	
	public abstract CommandResult execute(CommandSender sender, String[] args);
	
}
