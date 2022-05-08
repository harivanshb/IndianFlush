/* @Author: Harivansh Bhatia */

package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.display.interfaces.IDisplayPackCards;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.moves.interfaces.IPackCards;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;

import java.util.ArrayList;
import java.util.HashMap;

public class PackCards implements IPackCards {
    private static final int LIMIT = 1;

    public Game packCards(Game game, ArrayList<Player> players, Player player, HashMap<String, ArrayList<Card>> hands) {
        int currentPlayerIndex = game.getActivePlayerIndex();
        IDeclareWinner declareWinner = WinnerDeclarationAbstractFactory.instance().declareWinner();
        IDisplayPackCards packCards = DisplayAbstractFactory.instance().displayPackCards();
        player.setPlayerPackCardsMapping(true);
        players.remove(currentPlayerIndex);
        long count = players.stream().filter(playerIndex -> playerIndex.hasPlayerNotPackedCardsMapping()).count();
        if (count > LIMIT) {
            game.setGameEnd(false);
            game.setMoveToNextPlayer(false);
            return game;
        }
        packCards.packCardsMessage();
        game.setGameEnd(true);
        declareWinner.declareWinner(game);
        return game;
    }

}
