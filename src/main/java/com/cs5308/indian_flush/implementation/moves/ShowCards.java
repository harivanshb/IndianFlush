/* @Author: Harivansh Bhatia*/
package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.display.interfaces.IDisplayShowCards;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.moves.interfaces.IShowCards;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ShowCards implements IShowCards {
    private static final int LIMIT = 2;
    HashMap<String, ArrayList<Card>> hands = new HashMap<>();

    @Override
    public void showCards(ArrayList<Player> players, Game game) {
        IDeclareWinner winner = WinnerDeclarationAbstractFactory.instance().declareWinner();
        IDisplayShowCards display = DisplayAbstractFactory.instance().createDisplay();

        if (players.size() == LIMIT) {
            List<Player> activePlayers = players.stream().filter(player -> player.hasPlayerNotPackedCardsMapping())
                    .collect(Collectors.toList());
            for (Player player : activePlayers) {
                hands.put(player.getPlayerId(), player.getHands());
            }
            game.setGameEnd(true);
            winner.declareWinner(game);
        } else {
            game.setMoveToNextPlayer(false);
            display.showCardsErrorMessage();
        }
    }
}
