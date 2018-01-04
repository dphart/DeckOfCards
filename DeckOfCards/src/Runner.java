/**
 * Basic java class to run the code. It makes a new deck, shuffles it and then prints out each card when drawn
 */
public class Runner {
    public static void main(String [] args){
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i<53; i++) {
            Card currentCard = deck.dealOneCard();
            if (currentCard != null) {
                System.out.println(currentCard.getValue().name() + " OF " + currentCard.getSuit().name());
            } else {
                System.out.println("No cards left");
            }
        }
    }
}
