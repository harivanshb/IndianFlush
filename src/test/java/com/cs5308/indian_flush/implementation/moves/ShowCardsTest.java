package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/* @Author: Harivansh Bhatia */
class ShowCardsTest {
    @Test
    void testClassShowCardsCheck() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.cs5308.indian_flush.implementation.moves.ShowCards");
        assertNotNull(aClass);
    }

    @Test
    void testShowCardsTwoPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Player pi = PlayerAbstractFactory.instance().createBotPlayer("1", "HB", 1000.0);
        players.add(pi);
        Player pi1 = PlayerAbstractFactory.instance().createUserPlayer("2", "Amit", 1000.0);
        players.add(pi1);
        players.forEach(player -> player.setPlayerPackCardsMapping(false));
        Game game = (Game) GameAbstractFactory.instance().createGame(players);
        game.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        GameAbstractFactory.instance().createCardDistributor().distributeCards(players, game);
        MovesAbstractFactory.instance().showCards().showCards(players, game);
        assertEquals(true, game.isGameEnd());
    }

    @Test
    void testShowCardsMoreThanTwoPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Player pi = PlayerAbstractFactory.instance().createBotPlayer("1", "HB", 1000.0);
        players.add(pi);
        Player pi1 = PlayerAbstractFactory.instance().createUserPlayer("2", "Bot1", 1000.0);
        players.add(pi1);
        Player pi2 = PlayerAbstractFactory.instance().createUserPlayer("3", "Ram", 1000.0);
        players.add(pi2);
        players.forEach(player -> player.setPlayerPackCardsMapping(false));
        Game game = (Game) GameAbstractFactory.instance().createGame(players);
        game.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        GameAbstractFactory.instance().createCardDistributor().distributeCards(players, game);
        MovesAbstractFactory.instance().showCards().showCards(players, game);
        assertEquals(false, game.isGameEnd());
    }
}