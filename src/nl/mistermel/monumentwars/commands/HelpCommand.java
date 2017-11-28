package nl.mistermel.monumentwars.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import nl.mistermel.monumentwars.commands.handler.MonumentCommand;

public class HelpCommand extends MonumentCommand {

	public HelpCommand() {
		super("help", "Displays this help message.");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		//TODO: Actually include help messages.
		sender.sendMessage(ChatColor.RED + "Work in progress!");
	}
}
