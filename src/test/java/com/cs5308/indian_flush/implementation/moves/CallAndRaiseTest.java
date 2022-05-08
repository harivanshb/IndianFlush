package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.ICallAndRaise;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/* @Author: Harivansh Bhatia */
class CallAndRaiseTest {

    @Test
    void testClassCallAndRaiseCheck() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.cs5308.indian_flush.implementation.moves.CallAndRaise");
        assertNotNull(aClass);
    }

    @Test
    void testCallAndRaise() throws Exception {
        double raisedAmount = 10;
        ArrayList<Player> players = new ArrayList<>();
        ICallAndRaise callAndRaise = MovesAbstractFactory.instance().callAndRaise();
        Player player = PlayerAbstractFactory.instance().createUserPlayer("1", "HB", 1000.0);
        players.add(player);
        Game gi = (Game) GameAbstractFactory.instance().createGame(players);
        gi.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        gi = callAndRaise.callAndRaise(player, gi, raisedAmount);
        assertEquals(10, gi.getCurrentBetAmount());
    }

    @Test
    void testCallAndRaiseLowBalance() throws Exception {
        double raisedAmount = 10000;
        ArrayList<Player> players = new ArrayList<>();
        ICallAndRaise callAndRaise = MovesAbstractFactory.instance().callAndRaise();
        Player player = PlayerAbstractFactory.instance().createUserPlayer("1", "HB", 1000);
        players.add(player);
        Game gi = (Game) GameAbstractFactory.instance().createGame(players);
        gi.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
        gi = callAndRaise.callAndRaise(player, gi, raisedAmount);
        assertEquals(false, gi.isMoveToNextPlayer());
    }
}