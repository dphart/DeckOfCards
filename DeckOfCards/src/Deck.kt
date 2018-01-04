/**
 * Contains a deck of 52 cards, allowing a user to shuffle or dealOneCard.
 */
class Deck {
    //ArrayList was easier to work with for the shuffle operation, otherwise could have used a stack/queue
    private var deck : MutableList<Card> = initDeck()

    /**
     * This will shuffle the deck, with the number of times a card is randomly moved to the back of the deck being = deck.size. This is not guarnteed to shuffle each card,
     * one could be moved multiple times but should still meet the definition of shuffled. We could potentially multiply
     * deck.indices * multiplier to ensure it's more shuffled.
     */
    fun shuffle(){
        for(size in deck.indices){
            val cardNum = (Math.random() * deck.size).toInt()
            val temp = deck[cardNum]
            deck.removeAt(cardNum)
            deck.add(temp)
        }
    }

    /**
     * Returns the "Top" Card of the deck,
     * Returns null if the deck is empty
     */
    fun dealOneCard():Card? {
        if (deck.size > 0) {
            val card = deck.get(0)
            deck.removeAt(0)
            return card
        }
        return null
    }

    /**
     * Populates the deck of cards with 52 cards, one of each value for each of the four suits.
     */
    private fun initDeck() : MutableList<Card>{
        val deck:MutableList<Card> = ArrayList(52)
        for (suit in Suit.values()){
            for(values in CardValue.values()){
                deck.add(Card(values, suit))
            }
        }
        return deck
    }

    enum class CardValue {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    enum class Suit{
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }

}
