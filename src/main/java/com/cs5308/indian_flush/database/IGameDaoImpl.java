package com.cs5308.indian_flush.database;

import com.cs5308.indian_flush.database.interfaces.IGameDao;
import com.cs5308.indian_flush.implementation.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class IGameDaoImpl implements IGameDao {

	protected static final Logger LOGGER = LoggerFactory.getLogger(IGameDaoImpl.class);
	Connection connection = Database.instance();

	@Override
	public void test() throws SQLException {
		PreparedStatement statement = connection.prepareStatement("select * from test");
		statement.executeQuery("select * from test");
	}

	/* @Author: Harivansh Bhatia */
	@Override
	public void insertPlayerDataToWallet(String playerId, Double walletBalance) throws SQLException {
		String query = "insert into wallet(player_id,balance) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, playerId);
		statement.setDouble(2, walletBalance);
		statement.execute();
	}

	/* @Author: Harivansh Bhatia */
	@Override
	public Double getWalletBalancePlayer(String playerId) throws SQLException {
		Double balance = null;
		String query = "select balance from wallet where player_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, playerId);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			balance = Double.valueOf(resultSet.getString("balance"));
		}
		return balance;
	}

	/* @Author: Harivansh Bhatia */
	@Override
	public void insertPlayerDataToWallet(ArrayList<Player> players) throws SQLException {
		String query = "insert into wallet(player_id,balance) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		for (Player player : players) {
			statement.setString(1, player.getPlayerId());
			statement.setDouble(2, player.getWalletAmount());
			statement.execute();
		}
	}

	@Override
	public void updatePlayerWalletBalance(String playerId, Double balance) throws SQLException {
		String query = "update wallet set balance = ? where player_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setDouble(1, balance);
		statement.setString(2, playerId);
		statement.executeUpdate();
	}
}
