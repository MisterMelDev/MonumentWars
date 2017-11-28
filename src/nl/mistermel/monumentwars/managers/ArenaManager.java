package nl.mistermel.monumentwars.managers;

import java.util.HashSet;
import java.util.Set;

import nl.mistermel.monumentwars.Arena;

public class ArenaManager {
	
	private Set<Arena> arenas = new HashSet<Arena>();
	
	public void newArena(String name) {
		arenas.add(new Arena(name, 4, 15));
	}
	
	public void load() {
		
	}
	
	public void save() {
		
	}
}
