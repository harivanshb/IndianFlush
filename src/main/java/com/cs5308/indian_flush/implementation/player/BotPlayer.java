package com.cs5308.indian_flush.implementation.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;

/* @Author: Vikram, Meshwa*/
public class BotPlayer extends Bot {

    /* @Author: Vikram, Meshwa*/
    public String decidePlayerAction(String playerId, HashMap<String, ArrayList<Card>> hands) {

        float WINNING_THRESHOLD = 0.25f;
        float NEUTRAL_THRESHOLD = 0.50f;
        float LOSING_THRESHOLD = 0.75f;
        int rankOfCurrentPlayer;
        float currentPlayerScore;
        List<String> ACTIONS_OF_WINNER = Arrays.asList("Bet", "Bet Double", "Sideshow", "Show", "See Cards");
        List<String> ACTIONS_OF_MAYBE_WINNER = Arrays.asList("Bet", "Bet Double", "See Cards");
        List<String> ACTIONS_OF_MAYBE_LOSER = Arrays.asList("Bet", "Pack", "See Cards");
        List<String> ACTIONS_OF_LOSER = Arrays.asList("Pack", "See");
        HashMap<String, Integer> playerRanking;

        IWinnerDeclarationCheck winnerDeclaration = WinnerDeclarationAbstractFactory.instance()
                .winnerDeclarationCheck();
        playerRanking = winnerDeclaration.rankHandsAndDecideWinner(hands);

        rankOfCurrentPlayer = playerRanking.get(this.playerId);

        currentPlayerScore = (rankOfCurrentPlayer) / (float) hands.size();

        if (currentPlayerScore <= WINNING_THRESHOLD) {
            return getRandomElement(ACTIONS_OF_WINNER);
        } else if (currentPlayerScore <= NEUTRAL_THRESHOLD) {
            return getRandomElement(ACTIONS_OF_MAYBE_WINNER);
        } else if (currentPlayerScore <= LOSING_THRESHOLD) {
            return getRandomElement(ACTIONS_OF_MAYBE_LOSER);
        } else {
            return getRandomElement(ACTIONS_OF_LOSER);
        }
    }

    public String getRandomElement(List<String> listOfActions) {
        Random random = new Random();
        String randomElement = listOfActions.get(random.nextInt(listOfActions.size()));
        return randomElement;
    }

    BotPlayer(String playerId, String name, double walletAmount) {
        this.playerId = playerId;
        this.playerName = name;
        this.walletAmount = walletAmount;
        this.isBot = true;
    }

    BotPlayer() {
    }

    public static Player instance() {
        return new BotPlayer();
    }

    public static Player instance(String playerID, String name, double walletAmount) {
        return new BotPlayer(playerID, name, walletAmount);
    }

}
