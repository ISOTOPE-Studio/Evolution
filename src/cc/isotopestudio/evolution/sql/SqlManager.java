package cc.isotopestudio.evolution.sql;
/*
 * Created by Mars Tan on 3/2/2017.
 * Copyright ISOTOPE Studio
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static cc.isotopestudio.evolution.Evolution.plugin;

public abstract class SqlManager {

    public static Connection c;
    public static Statement statement;

    public static void init() {
        SQLite db = new SQLite(plugin.getDataFolder().getPath(), "players.db");
        try {
            c = db.openConnection();
            statement = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS players " +
                    "(NAME  CHAR(20) PRIMARY KEY  NOT NULL," +
                    " STR   INT      NOT NULL," +
                    " SPD   INT      NOT NULL," +
                    " CON   INT      NOT NULL," +
                    " WIT   INT      NOT NULL," +
                    " MEN   INT      NOT NULL)";
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
