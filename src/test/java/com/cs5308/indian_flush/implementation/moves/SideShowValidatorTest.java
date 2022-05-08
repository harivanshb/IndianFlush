package com.cs5308.indian_flush.implementation.moves;


import java.util.ArrayList;
import java.util.List;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* @Author: Meshwa*/
public class SideShowValidatorTest {

    @Test
        void testSideShowValidatorCheck() throws ClassNotFoundException {
        Class<?> sideShowValidatorClass = Class.forName("com.cs5308.indian_flush.implementation.moves.SideShowValidator");
        assertNotNull(sideShowValidatorClass);
    }

    @Test
    void testBlindSideShowRequest(){
        List<String> activePlayers = new ArrayList<>();
        activePlayers.add("1");
        activePlayers.add("2");
        activePlayers.add("3");
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertFalse(sideShowValidator.validateSideShow(true, activePlayers));
    }
    @Test
    void testInvalidPlayersSideShowRequest(){
        List<String> activePlayers = new ArrayList<>();
        activePlayers.add("1");
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertFalse(sideShowValidator.validateSideShow(true, activePlayers));
    }
    @Test
    void testValidSideShowRequest(){
        List<String> activePlayers = new ArrayList<>();
        activePlayers.add("1");
        activePlayers.add("2");
        activePlayers.add("3");
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertTrue(sideShowValidator.validateSideShow(false, activePlayers));
    }

    @Test
    void testCurrentPlayerBlind(){
        Player currentPlayer = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        currentPlayer.setPlayersIsBlindMapping(true);
        Player previousPlayer = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        previousPlayer.setPlayersIsBlindMapping(false);
        ArrayList<Player> activePlayers = new ArrayList<>();
        activePlayers.add(previousPlayer);
        activePlayers.add(currentPlayer);
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertTrue(sideShowValidator.isCurrentOrPreviousPlayerBlind(currentPlayer.getPlayerId(),previousPlayer.getPlayerId(),activePlayers));
    }

    @Test
    void testPreviousPlayerBlind(){
        Player currentPlayer = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        currentPlayer.setPlayersIsBlindMapping(false);
        Player previousPlayer = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        previousPlayer.setPlayersIsBlindMapping(true);
        ArrayList<Player> activePlayers = new ArrayList<>();
        activePlayers.add(previousPlayer);
        activePlayers.add(currentPlayer);
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertTrue(sideShowValidator.isCurrentOrPreviousPlayerBlind(currentPlayer.getPlayerId(),previousPlayer.getPlayerId(),activePlayers));
    }
    @Test
    void testBothPlayersBlind(){
        Player currentPlayer = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        currentPlayer.setPlayersIsBlindMapping(true);
        Player previousPlayer = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        previousPlayer.setPlayersIsBlindMapping(true);
        ArrayList<Player> activePlayers = new ArrayList<>();
        activePlayers.add(previousPlayer);
        activePlayers.add(currentPlayer);
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertTrue(sideShowValidator.isCurrentOrPreviousPlayerBlind(currentPlayer.getPlayerId(),previousPlayer.getPlayerId(),activePlayers));
    }
    @Test
    void testBothPlayersSeen(){
        Player currentPlayer = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        currentPlayer.setPlayersIsBlindMapping(false);
        Player previousPlayer = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        previousPlayer.setPlayersIsBlindMapping(false);
        ArrayList<Player> activePlayers = new ArrayList<>();
        activePlayers.add(previousPlayer);
        activePlayers.add(currentPlayer);
        SideShowValidator sideShowValidator = new SideShowValidator();
        assertFalse(sideShowValidator.isCurrentOrPreviousPlayerBlind(currentPlayer.getPlayerId(),previousPlayer.getPlayerId(),activePlayers));
    }
    @Test
    void testNotBlindPlayerList1(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        player1.setPlayersIsBlindMapping(false);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        player2.setPlayersIsBlindMapping(true);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        SideShowValidator sideShowValidator = new SideShowValidator();
        List<String> notBlindPlayerIds = new ArrayList<String>();
        notBlindPlayerIds.add("1");
        Assertions.assertEquals(notBlindPlayerIds, sideShowValidator.getNotBlindPlayersList(players));
    }


    @Test
    void testNotBlindPlayerList2(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        player1.setPlayersIsBlindMapping(false);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        player2.setPlayersIsBlindMapping(false);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        SideShowValidator sideShowValidator = new SideShowValidator();
        List<String> notBlindPlayerIds = new ArrayList<String>();
        notBlindPlayerIds.add("1");
        notBlindPlayerIds.add("2");
        Assertions.assertEquals(notBlindPlayerIds, sideShowValidator.getNotBlindPlayersList(players));
    }

    @Test
    void testNotBlindPlayerList3(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        player1.setPlayersIsBlindMapping(true);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        player2.setPlayersIsBlindMapping(true);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        SideShowValidator sideShowValidator = new SideShowValidator();
        List<String> notBlindPlayerIds = new ArrayList<String>();
        Assertions.assertEquals(notBlindPlayerIds, sideShowValidator.getNotBlindPlayersList(players));
    }
    @Test
    void testGetPreviousPlayerID1(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        Player player3 = PlayerAbstractFactory.instance().createBotPlayer("3", "Bot3", 1000.0);
        ArrayList<String> players = new ArrayList<>();
        players.add(player1.getPlayerId());
        players.add(player3.getPlayerId());
        SideShowValidator sideShowValidator=new SideShowValidator();
        Assertions.assertEquals(player1.getPlayerId(), sideShowValidator.getPreviousPlayerID(player3.getPlayerId(),players));
    }
    @Test
    void testGetPreviousPlayerID2(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        Player player3 = PlayerAbstractFactory.instance().createBotPlayer("3", "Bot3", 1000.0);
        ArrayList<String> players = new ArrayList<>();
        players.add(player2.getPlayerId());
        players.add(player3.getPlayerId());
        SideShowValidator sideShowValidator=new SideShowValidator();
        Assertions.assertEquals(player2.getPlayerId(), sideShowValidator.getPreviousPlayerID(player3.getPlayerId(),players));
    }
    @Test
    void testGetPreviousPlayerID3(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        Player player3 = PlayerAbstractFactory.instance().createBotPlayer("3", "Bot3", 1000.0);
        ArrayList<String> players = new ArrayList<>();
        players.add(player1.getPlayerId());
        players.add(player3.getPlayerId());
        SideShowValidator sideShowValidator=new SideShowValidator();
        Assertions.assertEquals(player3.getPlayerId(), sideShowValidator.getPreviousPlayerID(player1.getPlayerId(),players));
    }
    @Test
    void testGetActivePlayersList1(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        player1.setPlayersIsActiveMapping(true);
        player2.setPlayersIsActiveMapping(false);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        SideShowValidator sideShowValidator = new SideShowValidator();
        List<String> activePlayerIds = new ArrayList<String>();
        activePlayerIds.add("1");
        Assertions.assertEquals(activePlayerIds, sideShowValidator.getActivePlayersList(players));
    }


    @Test
    void testGetActivePlayersList2(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        player1.setPlayersIsActiveMapping(false);
        player2.setPlayersIsActiveMapping(false);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        SideShowValidator sideShowValidator = new SideShowValidator();
        List<String> activePlayerIds = new ArrayList<String>();
        Assertions.assertEquals(activePlayerIds, sideShowValidator.getActivePlayersList(players));
    }

    @Test
    void testGetActivePlayersList3(){
        Player player1 = PlayerAbstractFactory.instance().createBotPlayer("1", "Bot1", 1000.0);
        Player player2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot2", 1000.0);
        player1.setPlayersIsActiveMapping(true);
        player2.setPlayersIsActiveMapping(true);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        SideShowValidator sideShowValidator = new SideShowValidator();
        List<String> activePlayerIds = new ArrayList<String>();
        activePlayerIds.add("1");
        activePlayerIds.add("2");
        Assertions.assertEquals(activePlayerIds, sideShowValidator.getActivePlayersList(players));
    }

}
