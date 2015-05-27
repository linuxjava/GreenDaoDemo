package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
    public static void main(String[] args) {
        //第二个参数是实体输出包路径
        Schema schema = new Schema(1, "com.guochang.greendaodemo.db.entity");
        //GreenDao管理类输出路径
        schema.setDefaultJavaPackageDao("com.guochang.greendaodemo.db.dao");
        //要打开代码保持段开关
        schema.enableKeepSectionsByDefault();

        Entity property = schema.addEntity("AppProperty");
        property.setTableName("app_property");
        //property.addIdProperty().autoincrement();
        property.addStringProperty("propertyKey").notNull().unique();
        property.addStringProperty("propertyValue");

        Entity gameLevel = schema.addEntity("GameLevel");
        gameLevel.setTableName("game_level");
        gameLevel.addIdProperty().autoincrement();
        gameLevel.addIntProperty("gameType").notNull();
        gameLevel.addIntProperty("level").notNull();
        gameLevel.addIntProperty("sumCount");
        gameLevel.addIntProperty("rightCount");
        gameLevel.addStringProperty("reserve");

        try {
            //指定输出目录
            new DaoGenerator().generateAll(schema, "./app/src/main/java/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
