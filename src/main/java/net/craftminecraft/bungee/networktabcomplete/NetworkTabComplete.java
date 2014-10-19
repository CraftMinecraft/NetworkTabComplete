package net.craftminecraft.bungee.networktabcomplete;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by roblabla on 10/20/14.
 */

public class NetworkTabComplete extends Plugin implements Listener {
    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerListener(this, this);
    }
    public void onDisable() {}

    @EventHandler
    public void onTabComplete(TabCompleteEvent ev) {
        String[] splits = ev.getCursor().split(" ");
        String startname = splits[splits.length - 1];
        for (ProxiedPlayer p : this.getProxy().getPlayers()) {
            if (p.getDisplayName().toLowerCase().startsWith(startname) && !ev.getSuggestions().contains(p.getDisplayName()))
                ev.getSuggestions().add(p.getDisplayName());
        }
    }
}
