package cc.isotopestudio.evolution.data;
/*
 * Created by Mars Tan on 3/2/2017.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.evolution.type.Attribution;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static cc.isotopestudio.evolution.sql.SqlManager.c;

public abstract class PlayerData {

    public static void addPlayer(String playerName) {
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM players WHERE name = ?;");
            ps.setString(1, playerName);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                ps = c.prepareStatement("INSERT INTO players VALUES (?,?,?,?,?,?);");
                ps.setString(1, playerName);
                for (int i = 2; i <= 6; i++) {
                    ps.setString(i, String.valueOf(0));
                }
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setAttribution(String playerName, Attribution attri, int value) {
        try {
            String sql = "UPDATE players SET " + attri.name() + " = ? WHERE name = ?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, String.valueOf(value));
            ps.setString(2, playerName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getAttribution(String playerName, Attribution attri) {
        try {
            String sql = "SELECT * FROM players WHERE name = ?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, playerName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(attri.name());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
