package com.cs5308.indian_flush.database.abstractfactory;

import com.cs5308.indian_flush.database.IGameDaoImpl;
import com.cs5308.indian_flush.database.interfaces.IGameDao;

/* @Author: Harivansh Bhatia*/
public class GameDaoFactory extends GameDaoAbstractFactory {
@Override
    public IGameDao createDao() {
        return new IGameDaoImpl();
    }

}
