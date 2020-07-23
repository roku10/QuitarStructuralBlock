package com.quitarbloquestructural;

import com.github.intellectualsites.plotsquared.api.PlotAPI;
import com.quitarbloquestructural.comando.QuitarBloqueEstructural;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    PluginDescriptionFile pdffile = getDescription();

    public String name = ChatColor.GOLD+"["+ChatColor.RED+pdffile.getName()+ChatColor.GOLD+"]";

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("El plugin ha sido encendido");
        Transformarbloque();
        PlotAPI api = new PlotAPI();
    }


    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("El plugin ha sido apagado");
    }

    public void Transformarbloque(){

        this.getCommand("quitarstructure").setExecutor(new QuitarBloqueEstructural(this));
    }
}