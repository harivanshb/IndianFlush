package com.cs5308.indian_flush.database;

import com.cs5308.indian_flush.database.abstractfactory.GameDaoAbstractFactory;
import com.cs5308.indian_flush.database.interfaces.IGameDao;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/* @Author: Harivansh Bhatia */
class IGameDaoImplTest {

    @Test
    void testClassGameDao() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.cs5308.indian_flush.database.IGameDaoImpl");
        assertNotNull(aClass);
    }

    @Test
    void insertPlayerDataToWallet() throws SQLException {
        String playerId = "a4xc";
        Double balance = 100.00;
        IGameDao gameDao = GameDaoAbstractFactory.instance().createDao();
        gameDao.insertPlayerDataToWallet(playerId, balance);
    }

    @Test
    void testGetWalletBalancePlayer() throws SQLException {
        String playerId = "test";
        IGameDao gameDao = GameDaoAbstractFactory.instance().createDao();
        assertEquals(1000, gameDao.getWalletBalancePlayer(playerId));
    }

    @Test
    void testInsertPlayerDataToWallet() throws SQLException {
        IGameDao gameDao = GameDaoAbstractFactory.instance().createDao();
        ArrayList<Player> players = new ArrayList<>();
        Player pi = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        players.add(pi);
        Player pi1 = PlayerAbstractFactory.instance().createUserPlayer("2", "Amit", 1000.0);
        players.add(pi1);
        gameDao.insertPlayerDataToWallet(players);
    }
}