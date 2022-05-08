/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.game.cards.model.Rank;
import com.cs5308.indian_flush.implementation.game.cards.model.Suit;
import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.IColorCardShowRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorCardShowRuleTest {
    @Test
    void testClassColorCardShowRuleCheck(){
        IColorCardShowRule colorCardShowRule = RulesAbstractFactory.instance().checkColorCardShowRule();
        assertNotNull(colorCardShowRule);
    }
    @Test
    void testRuleColorCard1Check() {
        ArrayList<Card> hands = new ArrayList<>();
        hands.add(0,new Card(Rank.values()[0], Suit.values()[0]));
        hands.add(1,new Card(Rank.values()[1],Suit.values()[1]));
        hands.add(2,new Card(Rank.values()[2],Suit.values()[0]));
        Assertions.assertEquals(0, RulesAbstractFactory.instance().checkColorCardShowRule().checkColorCardShowRule(hands));
    }
    @Test
    void testRuleColorCard2Check() {
        ArrayList<Card> hands = new ArrayList<>();
        hands.add(0,new Card(Rank.values()[0], Suit.values()[0]));
        hands.add(1,new Card(Rank.values()[1],Suit.values()[0]));
        hands.add(2,new Card(Rank.values()[1],Suit.values()[0]));
        Assertions.assertEquals(40, RulesAbstractFactory.instance().checkColorCardShowRule().checkColorCardShowRule(hands));
    }
}
