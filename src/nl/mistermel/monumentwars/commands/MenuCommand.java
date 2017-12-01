package nl.mistermel.monumentwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.mistermel.monumentwars.commands.handler.CommandResult;
import nl.mistermel.monumentwars.commands.handler.MonumentCommand;

public class MenuCommand extends MonumentCommand {

	public MenuCommand() {
		super("menu", "Open the arena selection menu.");
	}

	@Override
	public CommandResult execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)) {
			return CommandResult.PLAYERS_ONLY;
		}
		return CommandResult.SUCCESS;
	}

}
