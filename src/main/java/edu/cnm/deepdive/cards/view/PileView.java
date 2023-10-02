package edu.cnm.deepdive.cards.view;

import edu.cnm.deepdive.cards.model.Card;
import edu.cnm.deepdive.cards.model.Suit;
import edu.cnm.deepdive.cards.model.Suit.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PileView {

  public static final Comparator<Card> COLOR_SUIT_RANK_COMPARATOR = new Comparator<Card>() {
    public int compare(Card card1, Card card2) {
      Suit suit1 = card1.getSuit();
      Suit suit2 = card2.getSuit();
      int comparison = suit1.getColor().compareTo(suit2.getColor());
      if (comparison == 0) {
        comparison = suit1.compareTo(suit2);
        if (comparison == 0) {
          comparison = card1.getRank().compareTo(card2.getRank());
        }
      }

      return comparison;
    }
  };


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
