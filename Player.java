/**
 *The Player class should be able to represent the set of cards a player has in hand.
 * The player class must allow to take a card from the deck and put it in the hand, 
 * count the points of the cards in hand...
 **/
import java.util.ArrayList;

public class Player {
     private ArrayList<Card>  hand;   // The cards in the plyaer's hand.
 
     /*Constructor*/
 Player(){
       //VOTRE CODE VIENT ICI
       hand = new ArrayList<>();

    }  
 
 /*Accessor*/
 public ArrayList<Card> getHand() {
        //VOTRE CODE VIENT ICI
        return hand;

    }
 
 /**
     * Remove all cards from the hand, leaving it empty.
  */
    public void clear() {
       //VOTRE CODE VIENT ICI
       hand.clear();

    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */
    public void add(Card card) {
        //VOTRE CODE VIENT ICI
        if (card == null) {
            throw new NullPointerException("La carte ne peut pas être nulle.");
        }
        hand.add(card);
    }

    /**
     * Remove a card from the hand, if present.
     * @param card the card to be removed.  If card is null or if the card is not in 
     * the hand, then nothing is done.
     */
    public void remove(Card card) {
        //VOTRE CODE VIENT ICI
        hand.remove(card);


    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        //VOTRE CODE VIENT ICI
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("Position invalide.");
        }
        hand.remove(position);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int totalCards() {
        //VOTRE CODE VIENT ICI
        return hand.size();

    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        //VOTRE CODE VIENT ICI
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("Position invalide.");
        }
        return hand.get(position);
    }

   /**
     * Computes and returns the total value of this hand in the game
     */
    public int getHandTotal () {

        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            int value = card.getValue();
            if (value > 10) {
                value = 10;
            } else if (value == 1) {
                aceCount++;
                value = 1;
            }
            total += value;
        }
        while (aceCount > 0 && total + 10 <= 21) {
            total += 10;
            aceCount--;
        }
        return total;
    }
    
    
    /**
     * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        //VOTRE CODE VIENT ICI
        hand.sort((card1, card2) -> {
            // On compare les couleurs des deux cartes
            return Integer.compare(card1.getColor(), card2.getColor());
        });
        
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        //VOTRE CODE VIENT ICI
        hand.sort((card1, card2) -> {
            int valueComparison = Integer.compare(card1.getValue(), card2.getValue());
            if (valueComparison == 0) {
                // Si les valeurs sont égales, on trie par couleur
                return Integer.compare(card1.getColor(), card2.getColor());
            }
            return valueComparison;
        });

    }
} 