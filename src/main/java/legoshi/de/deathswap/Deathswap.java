package legoshi.de.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Deathswap extends JavaPlugin {

	public static int timedelay = 7200;
	public static Deathswap instance;
	public Scheduler scheduler;

	@Override
	public void onEnable() {

		scheduler = new Scheduler();
		instance = this;

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DeathListener(), this);

		scheduler.load();

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static Deathswap getInstance() {

		return instance;

	}

	public static void setTime(int t) {

		timedelay = t;

	}

}
