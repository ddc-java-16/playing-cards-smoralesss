package edu.cnm.deepdive.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private final List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank: Rank.values()) {
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  @Override
  public String toString() {
    return cards.toString();
  }
}
