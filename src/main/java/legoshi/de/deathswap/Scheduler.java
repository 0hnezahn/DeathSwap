package legoshi.de.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Scheduler {

	public void load() {

		Deathswap.setTime((int) Math.floor((Math.random()*((6000-1200)+1))+1200));
		Bukkit.broadcastMessage("Time in ticks: " + Deathswap.timedelay);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(Deathswap.getInstance(), new Runnable() {

			int index = 0;

			@Override
			public void run() {

				index++;
				//if(index > (Deathswap.timedelay-220) && index%20 == 0) Bukkit.broadcastMessage("§cSwap in: " + (Deathswap.timedelay-index)/20 + "s");
				if(index == Deathswap.timedelay-1) {

					Deathswap.setTime((int) Math.floor((Math.random()*((6000-1200)+1))+1200));
					Bukkit.broadcastMessage("Time in ticks: " + Deathswap.timedelay);
					playerTeleport();
					index = 0;

				}
				Bukkit.getConsoleSender().sendMessage("Active: " + index);

			}

		}, 0, 1);

	}

	public void playerTeleport() {

		int amount = Bukkit.getOnlinePlayers().size();
		ArrayList<Player> players = new ArrayList<>();

		for(Player player : Bukkit.getOnlinePlayers()) {

			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
			if(player.getGameMode().equals(GameMode.SURVIVAL)) players.add(player);

		}

		int index = 0;

		if (amount > 6) {

			Location first = players.get(index).getLocation();

			while(amount-1> index) {

					Location tmp = players.get(index).getLocation();
					players.get(index).teleport(players.get(index+1));
					players.get(index+1).teleport(tmp);
					index++;

				}

				players.get(index).teleport(first);

		} else if(amount == 2) {

			Location tmp = players.get(0).getLocation();
			players.get(0).teleport(players.get(1));
			players.get(1).teleport(tmp);

		} else if(amount == 3) {

			Location tmp = players.get(0).getLocation();
			players.get(0).teleport(players.get(1));
			players.get(1).teleport(players.get(2));
			players.get(2).teleport(tmp);

		} else if(amount == 4) {

			Location tmp = players.get(0).getLocation();
			players.get(0).teleport(players.get(1));
			players.get(1).teleport(players.get(2));
			players.get(2).teleport(players.get(3));
			players.get(3).teleport(tmp);

		} else if(amount == 5) {

			Location tmp = players.get(0).getLocation();
			players.get(0).teleport(players.get(1));
			players.get(1).teleport(players.get(2));
			players.get(2).teleport(players.get(3));
			players.get(3).teleport(players.get(4));
			players.get(4).teleport(tmp);

		} else if(amount == 6) {

			Location tmp = players.get(0).getLocation();
			players.get(0).teleport(players.get(1));
			players.get(1).teleport(players.get(2));
			players.get(2).teleport(players.get(3));
			players.get(3).teleport(players.get(4));
			players.get(4).teleport(players.get(5));
			players.get(5).teleport(tmp);

		}

	}

}
