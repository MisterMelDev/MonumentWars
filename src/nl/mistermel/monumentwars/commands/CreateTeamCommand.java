package nl.mistermel.monumentwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.mistermel.monumentwars.Arena;
import nl.mistermel.monumentwars.MonumentWars;
import nl.mistermel.monumentwars.commands.handler.CommandResult;
import nl.mistermel.monumentwars.commands.handler.MonumentCommand;

public class CreateTeamCommand extends MonumentCommand {

	public CreateTeamCommand() {
		super("createteam", "create a team for an arena", "<arena> <teamname>");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandResult execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)) return CommandResult.PLAYERS_ONLY;
		
		if(args.length != 3) return CommandResult.INVALID_ARGS;
		
		Arena a = MonumentWars.getInstance().getArenaMan().getArena(args[1]);
		if(a == null) return CommandResult.ARENA_NOT_FOUND;
		
		if(a.teamExists(args[2])) return CommandResult.TEAM_EXISTS;
		
		a.addTeam(args[2]);
		
		return CommandResult.TEAM_CREATED;
	}

}
