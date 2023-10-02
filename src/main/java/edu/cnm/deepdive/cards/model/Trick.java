package edu.cnm.deepdive.cards.model;

import edu.cnm.deepdive.cards.model.Card;
import edu.cnm.deepdive.cards.model.Deck;
import edu.cnm.deepdive.cards.model.Suit.Color;
import edu.cnm.deepdive.cards.view.PileView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Trick {

  private final List<Card> blackPile = new ArrayList<>();
  private final List<Card> redPile = new ArrayList<>();

  public void perform() {
    Deck deck = createDeck(true);
    split(deck);
    System.out.println();
    shuffle();
    Random rng = new Random();
    swap(rng.nextInt(1 + Math.min(blackPile.size(), redPile.size())));
    PileView view = new PileView();
    System.out.println(view.render(blackPile, Color.BLACK));
    System.out.println(view.render(redPile, Color.RED));
    //TODO Print verification.

  }

  private Deck createDeck(boolean shuffle) {
    Deck deck = new Deck();
    if (shuffle) {
      deck.shuffle();
    }
    return deck;
  }

  private void split(Deck deck) {
    while (!deck.isEmpty()) {
      Card oracle = deck.draw();
      Card card = deck.draw();
      if (oracle.getSuit().getColor().equals(Color.BLACK)) {
        blackPile.add(card);

      } else {
        redPile.add(card);
      }
    }
  }

  private void shuffle() {
    Collections.shuffle(blackPile);
    Collections.shuffle(redPile);
  }

  /**
   *
   * @param count
   * @throws IllegalArgumentException If count is larger than the size of the smaller of the two piles
   */

  private void swap(int count) throws IllegalArgumentException {
    if (count > Math.min(blackPile.size(), redPile.size())) {
      throw new IllegalArgumentException("Invalid count: Must be no longer than the smaller of the two piles."); //FIXME Extract constant.
    }
    for (int i = 0; i < count; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

}
