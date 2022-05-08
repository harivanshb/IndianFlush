/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.IPlayBlind;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayBlindTest {
    @Test
    void testClassPlayBlindCheck() {
        IPlayBlind playBlind = MovesAbstractFactory.instance().playBlind();
        assertNotNull(playBlind);
    }

    @Test
    void testPlayBlindPassTest(){
        ArrayList<Player> players = new ArrayList<>();
        IPlayBlind playBlind = MovesAbstractFactory.instance().playBlind();
        Player player = PlayerAbstractFactory.instance().createUserPlayer("1", "Tanvi", 1000.0);
        players.add(player);
        players.forEach(setPlayer -> setPlayer.setPlayersIsBlindMapping(true));
        Game game = (Game) GameAbstractFactory.instance().createGame(players);
        game.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        playBlind.setPlayersBlind(player,game);
        assertEquals(true, player.getPlayersIsBlindMapping());
    }

    @Test
    void testPlayBlindFailTest(){
        ArrayList<Player> players = new ArrayList<>();
        MovesAbstractFactory movesAbstractFactory = MovesAbstractFactory.instance();
        Player player = PlayerAbstractFactory.instance().createUserPlayer("1", "Tanvi", 1000.0);
        players.add(player);
        players.forEach(setPlayer -> setPlayer.setPlayersIsBlindMapping(true));
        Game game = (Game) GameAbstractFactory.instance().createGame(players);
        game.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        GameAbstractFactory.instance().createCardDistributor().distributeCards(players, game);
        movesAbstractFactory.seeCards().seeCards(player,game);
        movesAbstractFactory.playBlind().setPlayersBlind(player,game);
        assertEquals(false, player.getPlayersIsBlindMapping());
    }
}
