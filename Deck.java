
/**
 *  Deck represents a deck of playing cards and contains 52 regular cards.
 */
public class Deck {

    private Card[] deck;  // an array of 52 cards.  
    private int number;  //the number of cards that have been dealt from the deck

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  
     */
    public Deck() {
        //VOTRE CODE VIENT ICI
        deck = new Card[52];
        number = 0;
        int index = 0;
        for (int color = 0; color < 4; color++) { // Boucle pour initialiser toutes les cartes du paquet

            for (int value = 1; value <= 13; value++) {
                deck[index++] = new Card(value, color);
            }
        }
 }


    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        //VOTRE CODE VIENT ICI
        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1)); // Mélanger les cartes de manière aléatoire 
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        number = 0;
    }

    /**
     * Returns the number of cards left in the deck.  
     */
    public int numberLeft() {
        //VOTRE CODE VIENT ICI
        return deck.length - number;

    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the numberLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card take() {
        //VOTRE CODE VIENT ICI
        if (number >= deck.length) {
            throw new IllegalStateException("Plus de cartes disponibles");
        }
        return deck[number++];
    }

} // end class Deck
