package nl.mistermel.monumentwars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import nl.mistermel.monumentwars.managers.ConfigManager;
import nl.mistermel.monumentwars.utils.ChatUtils;
import nl.mistermel.monumentwars.utils.Team;

public class Arena {
	
	private String name;
	private GameState state = GameState.WAITING;
	private int min, max;
	private int countdown;
	private ConfigManager configMan;
	private Set<UUID> players = new HashSet<UUID>();
	private Map<Location, Block> placedBlocks = new HashMap<Location, Block>();
	private Location lobby;
	private Map<Team, Location> teamSpawns = new HashMap<Team, Location>();
	private Set<Team> teams = new HashSet<Team>();
	private MonumentWars mw;
	private ChatUtils cu = new ChatUtils();
	
	public Arena(String name, int min, int max) {
		mw = MonumentWars.getPlugin(MonumentWars.class);
		configMan = new ConfigManager(mw);
		this.name = name;
		this.min = min;
		this.max = max;
		countdown = configMan.getConfig().getInt("game.countdown");
	}
	
	public boolean isFull() {
		return players.size() >= max;
	}
	
	public void join(Player p) {
		players.add(p.getUniqueId());
		checkCountdown();
	}
	
	private void checkCountdown() {
		if(state == GameState.WAITING) {
			if(players.size() >= min) {
				countdown();
			}
		}
	}
	
	private boolean ableToCountdown() {
		
		if(players.size() < min) return false;
		
		if(state != GameState.STARTING) return false;
		
		return true;
	}
	
	public boolean countdownBroadcast() {
		switch(countdown) {
			case 60: return true;
			case 30: return true;
			case 15: return true;
			case 10: return true;
			case 5: return true;
			case 4: return true;
			case 3: return true;
			case 2: return true;
			case 1: return true;
			default: return false;
		}
	}

	private void countdown() {
		new BukkitRunnable() {

			@Override
			public void run() {
				if(!ableToCountdown()) {
					countdown = configMan.getConfig().getInt("game.countdown");
					this.cancel();
					return;
				}
				if(countdown >= 0) {
					start();
					this.cancel();
				}
				if(countdownBroadcast()) {
					cu.broadcast(ChatUtils.PREFIX + countdown + " second(s) left until the game starts!", players);
					cu.broadcastTitle(ChatColor.BOLD + "" + countdown + " seconds left", ChatColor.RED + "Prepare to fight!", players);
				}
				countdown--;
			}
			
		}.runTaskTimer(mw, 0, 20);
	}

	private void start() {
		//TODO: Divide the players in to the teams and teleport them and give them their stuff.
	}

	public void leave(Player p) {
		players.remove(p.getUniqueId());
	}
	
	public Location getSpawn(Team team) {
		return teamSpawns.get(team);
	}
	
	public Location getLobby() {
		return lobby;
	}
	
	public List<Player> getPlayers() {
		List<Player> list = new ArrayList<Player>();
		for(UUID u : players) {
			list.add(Bukkit.getPlayer(u));
		}
		return list;
	}
	
	public Map<Team, Location> getTeamSpawns() {
		return teamSpawns;
	}
	
	public Map<Location, Block> getPlacedBlocks() {
		return placedBlocks;
	}
	
	public int getMaxPlayers() {
		return max;
	}
	
	public int getMinPlayers() {
		return min;
	}
	
	public String getName() {
		return name;
	}

	public int getCountdown() {
		return countdown;
	}

	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}
	
}
