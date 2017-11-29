package nl.mistermel.monumentwars.utils;

import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
	
	public static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Monument" + ChatColor.RED + "Wars" + ChatColor.GRAY + "] " + ChatColor.WHITE;
	
	public void broadcast(String message, Set<UUID> players) {
		for(UUID u : players) {
			Player p = Bukkit.getPlayer(u);
			p.sendMessage(message);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void broadcastTitle(String first, String second, Set<UUID> players) {
		for(UUID u : players) {
			Player p = Bukkit.getPlayer(u);
			p.sendTitle(first, second);
		}
	}

}
