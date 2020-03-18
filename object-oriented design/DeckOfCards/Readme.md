# Deck of Cards
Design the data structure for a feneric deck of cards. Explain how you would subclass the data structures to implement blackjack.

## Solution
First, we need to recognize that a "generic" deck of cards can mean many things. Generic could mean a standard deck of cards that can play a poker-like game, or it coule even stretch to Uno or baseball cards. It is important to ask your interviewer what she means by generic.
Let's assume that your interviewer clarifies that the deck is a standard 52-card set, like you might see used in a balckjack or poker game. If so, the design might look like this:

Generic card
```
public enum Suit{
    Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;
    private Suit(int v){ value = v;}
    public int getValue()(return value;)
    public static Suit getSuitFromVaule(int value){ ... }
}
```

- Deck 
```
public class Deck <T extends Card>{
    private ArrayList<T> cards; //all card, dealt or not
    private int dealItIndex = 0; //mark first undealt card

    public void setDeckOfCard(ArrayList<T> deckOfCards){ ... }

    public void shuffle() { ... }

    public int remainingCards(){ return cards.size() - dealtIndex; }

    public T[] dealHand(int number){ ... }

    public T dealCard(){ ... }
}
```

- Card
```
public abstaract class Card {
    private boolean available = true;

    protected in faceValue;
    protected Suit suit;
    public Card(int c , Suit s){
        faceValue = c;
        suit = s;
    }

    private avstract int value();
    public Suit suit(){ return suit; }

    // someone takes the card
    public booelan isAvailiable{ return available;}
    public void markUnavailiable { available = false ;}
    public void markAvailiable { available = true;}
}
```