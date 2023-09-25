package edu.cnm.deepdive.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Deck implements Iterable<Card> {

  private final List<Card> cards;

  private Iterator<Card> dealer;

  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank: Rank.values()) {
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
    dealer = iterator();
  }

  public void shuffle() {
    Collections.shuffle(cards);
    dealer = iterator();
  }

  public Card draw() throws NoSuchElementException {
    return dealer.next();
  }

  public boolean isEmpty() {
    return !dealer.hasNext();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  @SuppressWarnings("NullableProblems")
  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }
}
