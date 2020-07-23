
package com.quitarbloquestructural.comando;


import com.github.intellectualsites.plotsquared.api.PlotAPI;
import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import com.quitarbloquestructural.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class QuitarBloqueEstructural implements CommandExecutor {

    private final Main plugin;

    public QuitarBloqueEstructural(Main plugin) {

        this.plugin = plugin;
    }


    public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
        if (!(sender instanceof Player)) {

            Bukkit.getConsoleSender().sendMessage(plugin.name + ChatColor.WHITE + " ¡No puedes ejecutar comandos desde la consola!");
            return false;

        } else {

            Player jugador = (Player) sender;
            PlotAPI api = new PlotAPI();
            PlotPlayer plotPlayer = PlotPlayer.wrap(jugador);
            Plot atPlayer = Plot.getPlot(plotPlayer.getLocation());
            Location blockLoc = jugador.getLocation().add(0, -1, 0);

            if (atPlayer.getOwners().contains(jugador.getUniqueId())) {


                if (blockLoc.getBlock().getType().equals(Material.STRUCTURE_BLOCK)) {


                    blockLoc.getBlock().setType(Material.AIR);
                    jugador.sendMessage(plugin.name + ChatColor.GREEN + " ¡Bloque estructural eliminado correctamente!");
                    return true;

                } else {
                    jugador.sendMessage(plugin.name + ChatColor.RED + " ¡El bloque que tienes debajo no es un bloque estructural!");
                    return true;
                }
            } else {
                jugador.sendMessage(plugin.name + ChatColor.RED + " ¡No eres el dueño de la plot!");
                return true;

            }


        }

    }
}