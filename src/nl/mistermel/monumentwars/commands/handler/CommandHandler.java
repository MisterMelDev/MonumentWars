package nl.mistermel.monumentwars.commands.handler;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nl.mistermel.monumentwars.MonumentWars;

public class CommandHandler implements CommandExecutor {
	
	private Set<MonumentCommand> commands = new HashSet<MonumentCommand>();
	
	public void registerCommand(MonumentCommand cmd) {
		commands.add(cmd);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(ChatColor.GOLD + "MonumentWars " + ChatColor.GRAY + "version " + MonumentWars.getInstance().getDescription().getVersion());
			sender.sendMessage(ChatColor.GOLD + "Authors: " + ChatColor.GRAY + "MisterMel & Rens4000");
			sender.sendMessage(ChatColor.GOLD + "Use " + ChatColor.GRAY + "/monumentwars help" + ChatColor.GOLD + " for a list of commands.");
			return true;
		}
		for(MonumentCommand cmd : commands) {
			if(cmd.getLabel().equals(args[0])) {
				CommandResult result = cmd.execute(sender, args);
				if(result == CommandResult.INVALID_ARGS) {
					sender.sendMessage(ChatColor.GRAY + "Use: " + ChatColor.RED + cmd.getLabel() + cmd.getArgs());
				} else if(result.getMessage() != null) sender.sendMessage(result.getMessage());
				return true;
			}
		}
		sender.sendMessage(ChatColor.RED + "Subcommand not found!");
		return true;
	}

	public Set<MonumentCommand> getCommands() {
		return commands;
	}

}
