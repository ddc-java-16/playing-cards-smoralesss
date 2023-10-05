package edu.cnm.deepdive.cards.view;

import edu.cnm.deepdive.cards.model.Card;
import edu.cnm.deepdive.cards.model.Suit;
import edu.cnm.deepdive.cards.model.Suit.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PileView {

  public static final Comparator<Card> COLOR_SUIT_RANK_COMPARATOR =
     Comparator.comparing((Card card) -> card.getSuit(), Comparator.comparing(
             suit -> suit.getColor()))
         .thenComparing(card -> card.getSuit())
         .thenComparing(card -> card.getRank());



  public String render(List<Card> cards, Color color) {
    List<Card> sortedCards = new ArrayList<>(cards);
    sortedCards.sort(COLOR_SUIT_RANK_COMPARATOR);
    int colorCount = 0;
    for (Card card : sortedCards) {
      if (card.getSuit().getColor() == color) {
        colorCount++;
      }
    }
    return String.format("%1$s pile: %2$s; %1$s count = %3$d", color, sortedCards, colorCount);
  }

}
