/* @Author: Tanvi Pruthi */

package com.cs5308.indian_flush.implementation.moves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.IMoves;
import com.cs5308.indian_flush.implementation.player.Player;

public class Moves implements IMoves {

    public Boolean playerMove(Game game, Player player, ArrayList<Player> players,
                              HashMap<String, ArrayList<Card>> hands, Scanner scanner) {
        MovesAbstractFactory movesAbstractFactory = MovesAbstractFactory.instance();
        DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();
        DisplayAbstractFactory.instance().displayMoves().displayMoves();
        int move = scanner.nextInt();

        try {
            if (move == 1) {
                movesAbstractFactory.packCards().packCards(game, players, player, hands);
                nextActivePlayer(players, game);
            } else if (move == 2) {
                displayAbstractFactory.displayCallAndRaiseInitialMessage().displayPreviousBetAmount(game);
                displayAbstractFactory.displayCallAndRaiseInitialMessage().callAndRaiseAmountMessage();
                double raisedAmount = scanner.nextDouble();
                movesAbstractFactory.callAndRaise().callAndRaise(player, game, raisedAmount);
                displayAbstractFactory.displayCallAndRaiseInitialMessage().displayBalance(player);
                nextActivePlayer(players, game);
            } else if (move == 3) {
                movesAbstractFactory.sideShow().sideShow(player.getPlayerId(), players, hands, game);
                nextActivePlayer(players, game);
            } else if (move == 4) {
                movesAbstractFactory.playBlind().setPlayersBlind(player, game);
                nextActivePlayer(players, game);
            } else if (move == 5) {
                movesAbstractFactory.seeCards().seeCards(player, game);
                game.setMoveToNextPlayer(false);
                nextActivePlayer(players, game);
            } else if (move == 6) {
                movesAbstractFactory.showCards().showCards(players, game);
                nextActivePlayer(players, game);
            } else {
                DisplayAbstractFactory.instance().displayInvalidMoves().displayInvalidMoves();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void botMove(String move, Game game, Player player, ArrayList<Player> players,
                        HashMap<String, ArrayList<Card>> hands) {
        MovesAbstractFactory movesAbstractFactory = MovesAbstractFactory.instance();

        DisplayAbstractFactory.instance().displayMoves().displayBotMove(player.getPlayerName(), move);

        try {
            if (move.equalsIgnoreCase("Pack")) {
                movesAbstractFactory.packCards().packCards(game, players, player, hands);
                nextActivePlayer(players, game);
            } else if (move.equalsIgnoreCase("Bet")) {
                movesAbstractFactory.callAndRaise().callAndRaise(player, game, game.getCurrentBetAmount());
                nextActivePlayer(players, game);
            } else if (move.equalsIgnoreCase("Bet Double")) {
                movesAbstractFactory.callAndRaise().callAndRaise(player, game, game.getCurrentBetAmount() * 2);
                nextActivePlayer(players, game);
            } else if (move.equalsIgnoreCase("Sideshow")) {
                movesAbstractFactory.sideShow().sideShow(player.getPlayerId(), players, hands, game);
                nextActivePlayer(players, game);
            } else if (move.equalsIgnoreCase("Player Blind")) {
                movesAbstractFactory.playBlind().setPlayersBlind(player, game);
                nextActivePlayer(players, game);
            } else if (move.equalsIgnoreCase("See Cards")) {
                movesAbstractFactory.seeCards().seeCards(player, game);
                nextActivePlayer(players, game);
            } else if (move.equalsIgnoreCase("Show")) {
                movesAbstractFactory.showCards().showCards(players, game);
                nextActivePlayer(players, game);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void nextActivePlayer(ArrayList<Player> players, Game game) {
        if (game.isMoveToNextPlayer() != null && game.isMoveToNextPlayer()) {
            int nextPlayerIndex = (game.getActivePlayerIndex() + 1) % players.size();
            game.setActivePlayer(players.get(nextPlayerIndex));
            game.setActivePlayerIndex(nextPlayerIndex);
        } else {
            int currentPlayerIndex = game.getActivePlayerIndex() % players.size();
            game.setActivePlayer(players.get(currentPlayerIndex));
            game.setActivePlayerIndex(currentPlayerIndex);
        }
    }
}
