package com.cs5308.indian_flush.database.interfaces;

import com.cs5308.indian_flush.implementation.player.Player;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IGameDao {

    public void test() throws Exception;

    /* @Author: Harivansh Bhatia*/
    void insertPlayerDataToWallet(String playerId, Double walletBalance) throws SQLException;

    /* @Author: Harivansh Bhatia*/
    Double getWalletBalancePlayer(String playerId) throws SQLException;

    /* @Author: Harivansh Bhatia*/
    void insertPlayerDataToWallet(ArrayList<Player> players) throws SQLException;

    /* @Author: Harivansh Bhatia*/
    void updatePlayerWalletBalance(String playerId, Double balance) throws SQLException;

}
