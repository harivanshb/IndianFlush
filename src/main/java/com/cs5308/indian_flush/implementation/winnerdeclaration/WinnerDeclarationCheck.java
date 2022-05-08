/* @Author: Vikram*/
/* @Author: Tanvi Pruthi*/
package com.cs5308.indian_flush.implementation.winnerdeclaration;

import java.util.*;

import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IRankBuckets;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

public class WinnerDeclarationCheck implements IWinnerDeclarationCheck {

	RulesAbstractFactory rulesAbstractFactory = RulesAbstractFactory.instance();
	WinnerDeclarationAbstractFactory winnerDeclarationAbstractFactory = WinnerDeclarationAbstractFactory.instance();
	IRankBuckets rankBuckets = winnerDeclarationAbstractFactory.setRankBuckets();
	boolean tripletsValid;
	boolean pureSequenceValid;
	boolean straightSequenceValid;
	boolean colorValid;
	boolean pairValid;
	boolean highValid;
	int tripletsValue;
	int pureSequenceValue;
	int straightSequenceValue;
	int colorRuleValue;
	int pairValue;
	int highestRuleValue;

	HashMap<String, Integer> playerHandRanking;
	HashMap<String, GameResult> gameResult = new HashMap<>();

	/* @Author: Vikram */
	public WinnerDeclarationCheck() {
		super();
		this.playerHandRanking = new HashMap<>();
	}

	/* @Author: Vikram */
	public HashMap<String, Integer> rankHandsAndDecideWinner(HashMap<String, ArrayList<Card>> hands) {
		rankHands(hands);
		return playerHandRanking;
	}

	/* @Author: Tanvi Pruthi */
	void rankHands(HashMap<String, ArrayList<Card>> hands) {
		for (String player : hands.keySet()) {
			if (checkTripletsCriteria(hands, player)) {
				continue;
			}
			if (checkPureSequenceCriteria(hands, player)) {
				continue;
			}
			if (checkStraightSequenceCriteria(hands, player)) {
				continue;
			}
			if (checkColorCriteria(hands, player)) {
				continue;
			}
			if (checkPairCriteria(hands, player)) {
				continue;
			}
			if (checkHighCriteria(hands, player)) {
			}

		}
		decideWinner();
	}

	/* @Author: Vikram */
	boolean checkTripletsCriteria(HashMap<String, ArrayList<Card>> hands, String player) {
		tripletsValid = false;
		tripletsValue = rulesAbstractFactory.checkTripletsCardShowRule().tripletsCardShowRule(hands.get(player));
		if (tripletsValue != 0) {
			gameResult.put(player, (GameResult) winnerDeclarationAbstractFactory.setGameResult(tripletsValue));
			rankBuckets.getTriplets().add(player);
			tripletsValid = true;
		}
		return tripletsValid;
	}

	/* @Author: Vikram */
	boolean checkPureSequenceCriteria(HashMap<String, ArrayList<Card>> hands, String player) {
		pureSequenceValid = false;
		pureSequenceValue = rulesAbstractFactory.checkPureSequenceCardShowRule()
				.pureSequenceCardShowRule(hands.get(player));
		if (pureSequenceValue != 0) {
			gameResult.put(player, (GameResult) winnerDeclarationAbstractFactory.setGameResult(pureSequenceValue));
			rankBuckets.getPureSequence().add(player);
			pureSequenceValid = true;
		}
		return pureSequenceValid;
	}

	/* @Author: Vikram */
	boolean checkStraightSequenceCriteria(HashMap<String, ArrayList<Card>> hands, String player) {
		straightSequenceValid = false;
		straightSequenceValue = rulesAbstractFactory.checkStraightSequenceCardShowRule()
				.straightSequenceCardShowRule(hands.get(player));
		if (straightSequenceValue != 0) {
			gameResult.put(player, (GameResult) winnerDeclarationAbstractFactory.setGameResult(straightSequenceValue));
			rankBuckets.getSequence().add(player);
			straightSequenceValid = true;
		}
		return straightSequenceValid;
	}

	/* @Author: Tanvi Pruthi */
	boolean checkColorCriteria(HashMap<String, ArrayList<Card>> hands, String player) {
		colorValid = false;
		colorRuleValue = rulesAbstractFactory.checkColorCardShowRule().checkColorCardShowRule(hands.get(player));
		if (colorRuleValue != 0) {
			gameResult.put(player, (GameResult) winnerDeclarationAbstractFactory.setGameResult(colorRuleValue));
			rankBuckets.getColor().add(player);
			colorValid = true;
		}
		return colorValid;
	}

	/* @Author: Tanvi Pruthi */
	boolean checkPairCriteria(HashMap<String, ArrayList<Card>> hands, String player) {
		pairValid = false;
		pairValue = rulesAbstractFactory.checkPairCardShowRule().pairCardShowRule(hands.get(player));
		if (pairValue != 0) {
			gameResult.put(player, (GameResult) winnerDeclarationAbstractFactory.setGameResult(pairValue));
			rankBuckets.getPair().add(player);
			pairValid = true;
		}
		return pairValid;
	}

	/* @Author: Tanvi Pruthi */
	boolean checkHighCriteria(HashMap<String, ArrayList<Card>> hands, String player) {
		highValid = false;
		highestRuleValue = rulesAbstractFactory.checkHighCardShowRule().checkHighCardShowRule(hands.get(player));
		gameResult.put(player, (GameResult) winnerDeclarationAbstractFactory.setGameResult(highestRuleValue));
		rankBuckets.getHigh().add(player);
		highValid = true;
		return true;
	}

	/* @Author: Vikram */
	/* @Author: Tanvi Pruthi */
	void decideWinner() {
		int rank = 1;

		rankBuckets.getTriplets().sort(new PlayerCardsComparator(gameResult));
		rankBuckets.getPureSequence().sort(new PlayerCardsComparator(gameResult));
		rankBuckets.getSequence().sort(new PlayerCardsComparator(gameResult));
		rankBuckets.getColor().sort(new PlayerCardsComparator(gameResult));
		rankBuckets.getPair().sort(new PlayerCardsComparator(gameResult));
		rankBuckets.getHigh().sort(new PlayerCardsComparator(gameResult));

		for (int index = rankBuckets.getTriplets().size() - 1; index >= 0; index--) {
			playerHandRanking.put(rankBuckets.getTriplets().get(index), rank++);
		}
		for (int index = rankBuckets.getPureSequence().size() - 1; index >= 0; index--) {
			playerHandRanking.put(rankBuckets.getPureSequence().get(index), rank++);
		}
		for (int index = rankBuckets.getSequence().size() - 1; index >= 0; index--) {
			playerHandRanking.put(rankBuckets.getSequence().get(index), rank++);
		}
		for (int index = rankBuckets.getColor().size() - 1; index >= 0; index--) {
			playerHandRanking.put(rankBuckets.getColor().get(index), rank++);
		}
		for (int index = rankBuckets.getPair().size() - 1; index >= 0; index--) {
			playerHandRanking.put(rankBuckets.getPair().get(index), rank++);
		}
		for (int index = rankBuckets.getHigh().size() - 1; index >= 0; index--) {
			playerHandRanking.put(rankBuckets.getHigh().get(index), rank++);
		}
	}
}
