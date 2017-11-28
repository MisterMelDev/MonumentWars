package nl.mistermel.monumentwars;

import java.util.HashSet;
import java.util.Set;

public class ArenaManager {
	
	private Set<Arena> arenas = new HashSet<Arena>();
	
	public void registerArena(String name) {
		arenas.add(new Arena(name));
	}
	
	public void load() {
		
	}
	
	public void save() {
		
	}
}
