package nl.mistermel.monumentwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.mistermel.monumentwars.Arena;
import nl.mistermel.monumentwars.MonumentWars;
import nl.mistermel.monumentwars.commands.handler.CommandResult;
import nl.mistermel.monumentwars.commands.handler.MonumentCommand;

public class JoinCommand extends MonumentCommand {

	public JoinCommand() {
		super("join", "Join an arena.", "<Arena>");
	}

	@Override
	public CommandResult execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)) return CommandResult.PLAYERS_ONLY;
		
		Player p = (Player) sender;
		
		if(args.length != 2) return CommandResult.INVALID_ARGS;
		
		Arena a = MonumentWars.getInstance().getArenaMan().getArena(args[1]);
		if(a == null) return CommandResult.ARENA_NOT_FOUND;
		
		if(!a.isActive()) return CommandResult.ARENA_NOT_ACTIVE;
			
		a.join(p);
		return CommandResult.SUCCESS;
	}

}
