package com.cs5308.indian_flush.database.abstractfactory;

import com.cs5308.indian_flush.database.interfaces.IGameDao;

/* @Author: Harivansh Bhatia*/
public abstract class GameDaoAbstractFactory {

    private static GameDaoAbstractFactory gameDaoAbstractFactory;

    public static GameDaoAbstractFactory instance() {
        if (gameDaoAbstractFactory == null) {
            gameDaoAbstractFactory = new GameDaoFactory();
        }
        return gameDaoAbstractFactory;
    }

    public abstract IGameDao createDao();
}
