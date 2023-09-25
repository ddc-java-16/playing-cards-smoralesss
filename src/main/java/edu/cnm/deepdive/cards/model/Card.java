package edu.cnm.deepdive.cards.model;

import java.util.Objects;

public class Card {

  private final Rank rank;
  private final Suit suit;
  private final int hash;
  private final String representation;

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }
  public boolean isFaceUp() {
    return faceUp;
  }

  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  private boolean faceUp;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
    hash = Objects.hash(rank, suit);
    representation = rank.getSymbol() + suit.getSymbol();
  }

  @Override
  public String toString() {
    return representation;
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {
      result = true;
    } else if (obj instanceof Card other) {
      result = (rank == other.rank && suit == other.suit);
    } else {
      result = false;
    }
    return result;
  }
}
