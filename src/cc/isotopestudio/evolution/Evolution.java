package cc.isotopestudio.evolution;

import cc.isotopestudio.evolution.command.AdminCommand;
import cc.isotopestudio.evolution.listener.PlayerListener;
import cc.isotopestudio.evolution.sql.SqlManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Evolution extends JavaPlugin {

    public static Evolution plugin;

    private static final String pluginName = "Evolution";
    public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("系统").append("]").append(ChatColor.RED).toString();

    @Override
    public void onEnable() {
        plugin = this;

        SqlManager.init();

        getCommand("evoadmin").setExecutor(new AdminCommand());

        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);

        getLogger().info(pluginName + "成功加载!");
        getLogger().info(pluginName + "由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "成功卸载!");
    }

}
