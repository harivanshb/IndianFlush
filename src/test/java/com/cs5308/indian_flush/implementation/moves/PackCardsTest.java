package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.IPackCards;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/* @Author: Harivansh Bhatia */
class PackCardsTest {
    @Test
    void testClassPackCards() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.cs5308.indian_flush.implementation.moves.PackCards");
        assertNotNull(aClass);
    }

    @Test
    void testPackCards() {
        ArrayList<Player> players = new ArrayList<>();
        Player pi1 = PlayerAbstractFactory.instance().createUserPlayer("1", "HB", 1000.0);
        players.add(pi1);
        Player pi2 = PlayerAbstractFactory.instance().createBotPlayer("2", "Bot1", 1000.0);
        players.add(pi2);

        players.forEach(player -> player.setPlayerPackCardsMapping(false));

        GameAbstractFactory gi = GameAbstractFactory.instance();
        Game game = (Game) gi.createGame(players);

        IPackCards packCards = MovesAbstractFactory.instance().packCards();

        GameAbstractFactory.instance().createCardDistributor().distributeCards(players, game);

        game.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        packCards.packCards(game, players, pi1, game.getHands());
        assertEquals(true, game.isGameEnd());
        GameAbstractFactory.instance().disableGame();
    }
}