/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.game.cards.model.Rank;
import com.cs5308.indian_flush.implementation.game.cards.model.Suit;
import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.IPairCardShowRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PairCardShowRuleTest {
    @Test
    void testClassPairCardShowRuleCheck(){
        IPairCardShowRule pairCard = RulesAbstractFactory.instance().checkPairCardShowRule();
        assertNotNull(pairCard);
    }
    @Test
    void testRulePairMatchCheck() {
        ArrayList<Card> hands = new ArrayList<>();
        hands.add(0,new Card(Rank.values()[0], Suit.values()[0]));
        hands.add(1,new Card(Rank.values()[1],Suit.values()[0]));
        hands.add(2,new Card(Rank.values()[1],Suit.values()[0]));
        Assertions.assertEquals(13, RulesAbstractFactory.instance().checkPairCardShowRule().pairCardShowRule(hands));
    }

    @Test
    void testRulePairNoMatchCheck() {
        ArrayList<Card> hands = new ArrayList<>();
        hands.add(0,new Card(Rank.values()[0],Suit.values()[0]));
        hands.add(1,new Card(Rank.values()[1], Suit.values()[1]));
        hands.add(2,new Card(Rank.values()[2],Suit.values()[0]));
        Assertions.assertEquals(0, RulesAbstractFactory.instance().checkPairCardShowRule().pairCardShowRule(hands));
    }
}
