/* @Author: Harivansh Bhatia */

package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.database.abstractfactory.GameDaoAbstractFactory;
import com.cs5308.indian_flush.database.interfaces.IGameDao;
import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.display.interfaces.IDisplayCallAndRaise;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.moves.interfaces.ICallAndRaise;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;

public class CallAndRaise implements ICallAndRaise {
    private static final int LIMIT = 0;
    private static final int BET_AMOUNT_FACTOR = 2;

    public Game callAndRaise(Player player, Game game, double raisedAmount) throws Exception {
        IGameDao gameDaoAbstractFactory = GameDaoAbstractFactory.instance().createDao();
        IDisplayCallAndRaise display = DisplayAbstractFactory.instance().displayCallAndRaiseInitialMessage();
        IDeclareWinner declareWinner = WinnerDeclarationAbstractFactory.instance().declareWinner();
        double currentBetAmount = game.getCurrentBetAmount();
        double walletAmount = gameDaoAbstractFactory.getWalletBalancePlayer(player.getPlayerId());
        double differenceCalculated = walletAmount - raisedAmount;

        if (differenceCalculated < LIMIT) {
            display.lowBalanceMessage();
            game.setMoveToNextPlayer(false);
            return game;
        } else if (raisedAmount == currentBetAmount || raisedAmount == (BET_AMOUNT_FACTOR * currentBetAmount)) {
            currentBetAmount = raisedAmount;
            game.setCurrentBetAmount(currentBetAmount);
            game.setChipsOnTable(game.getChipsOnTable() + currentBetAmount);
            player.setWalletAmount(differenceCalculated);
            display.raisedAmountMessage(game.getCurrentBetAmount());
            gameDaoAbstractFactory.updatePlayerWalletBalance(player.getPlayerId(), differenceCalculated);
            game.setMoveToNextPlayer(true);

            if (game.getChipsOnTable() >= game.getPotLimit()) {
                display.displayMaxBetLimitReached();
                game.setGameEnd(true);
                declareWinner.declareWinner(game);
            }

        } else {
            display.invalidInputEnteredMessage();
            throw new Exception();
        }
        return game;
    }

}
