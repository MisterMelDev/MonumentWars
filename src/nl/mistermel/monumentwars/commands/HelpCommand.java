package nl.mistermel.monumentwars.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import nl.mistermel.monumentwars.MonumentWars;
import nl.mistermel.monumentwars.commands.handler.CommandResult;
import nl.mistermel.monumentwars.commands.handler.MonumentCommand;

public class HelpCommand extends MonumentCommand {

	public HelpCommand() {
		super("help", "Displays this help message.");
	}

	@Override
	public CommandResult execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GOLD + "List of commands:");
		for(MonumentCommand cmd : MonumentWars.getInstance().getCommandHandle().getCommands()) {
			sender.sendMessage(ChatColor.GREEN + "/mwars " + cmd.getLabel() + cmd.getArgs() + ChatColor.YELLOW + " - " + cmd.getDescription());
		}
		return CommandResult.PLAYERS_ONLY;
	}
}
