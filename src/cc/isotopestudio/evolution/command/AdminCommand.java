package cc.isotopestudio.evolution.command;
/*
 * Created by Mars Tan on 3/2/2017.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.evolution.data.PlayerData;
import cc.isotopestudio.evolution.type.Attribution;
import cc.isotopestudio.evolution.util.S;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("evoadmin")) {
            Player player = (Player) sender;
            if (!player.hasPermission("evo.admin")) {
                player.sendMessage(S.toPrefixRed("你没有权限"));
                return true;
            }
            if (args.length < 1) {
                return true;
            }
            if (args[0].equalsIgnoreCase("set") && args.length >= 3) {
                Player infoP = Bukkit.getPlayer(args[1]);
                if (infoP == null) return true;
                Attribution attri = Attribution.valueOf(args[2]);
                PlayerData.setAttribution(infoP.getName(), attri, Integer.parseInt(args[3]));
                player.sendMessage(S.toPrefixGreen("好！b（￣▽￣）d　"));
                return true;
            }
            if (args[0].equalsIgnoreCase("info") && args.length >= 2) {
                Player infoP = Bukkit.getPlayer(args[1]);
                if (infoP == null) return true;
                player.sendMessage(S.toPrefixGreen(infoP.getDisplayName()));
                for (Attribution attri : Attribution.values()) {
                    player.sendMessage(S.toYellow(attri.getChinese() + ": "
                            + PlayerData.getAttribution(infoP.getName(), attri)));
                }
                return true;
            }

            return true;
        }
        return false;
    }
}
