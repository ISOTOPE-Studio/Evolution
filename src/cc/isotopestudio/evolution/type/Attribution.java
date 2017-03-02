package cc.isotopestudio.evolution.type;
/*
 * Created by Mars Tan on 3/2/2017.
 * Copyright ISOTOPE Studio
 */

public enum Attribution {

    STR("力量"),
    SPD("速度"),
    CON("體力"),
    WIT("智慧"),
    MEN("精神");

    final String name;

    Attribution(String name) {
        this.name = name;
    }


    public String getChinese() {
        return name;
    }
}
