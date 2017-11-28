package nl.mistermel.monumentwars.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.mistermel.monumentwars.MonumentWars;

public class ConfigManager {
	
	private MonumentWars mw;
	
	private File configFile;
	private FileConfiguration config;
	
	private File dataFile;
	private FileConfiguration data;
	
	public ConfigManager(MonumentWars mw) {
		this.mw = mw;
		
		configFile = new File(mw.getDataFolder(), "config.yml");
		config = YamlConfiguration.loadConfiguration(configFile);
		
		dataFile = new File(mw.getDataFolder(), "config.yml");
		data = YamlConfiguration.loadConfiguration(configFile);
	}

	public File getConfigFile() {
		return configFile;
	}

	public FileConfiguration getConfig() {
		return config;
	}

	public File getDataFile() {
		return dataFile;
	}

	public FileConfiguration getData() {
		return data;
	}
	
	public void save() {
		try {
			config.save(configFile);
			data.save(dataFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
