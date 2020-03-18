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

    private abstract int value();
    public Suit suit(){ return suit; }

    // someone takes the card
    public booelan isAvailiable{ return available;}
    public void markUnavailiable { available = false ;}
    public void markAvailiable { available = true;}
}
```

- Hand
```
public class Hand <T extends Card> {
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score(){
        int score = 0;
        for(T card : cards){
            score+= card.value();
        }
        return score;
    }

    public void addCard (T card){
        cards.add(card);
    }
}
```
In the above code, we have implemented Deck with generics but restricted the type of T to Card. We have also implemented Card as an abstract class, since methods like value() do not make mush sense without a specific game attached to them (You could make a compelling argment that they should be implemented anyway, by defaulting to standard poker rules.)

Now, let's say we are building a blackjack game, so we need to know the value of the cards. Face cards are 10 and an ace is 11(most of the time, but that is the job of the Hand class, not the following class)

- BlackJackHand
```
public class BlackJackHand extends Hand<BlackJackCard>{

    public int score(){
        ArrayList<Integer> scores = possibleScorces();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for(int score:scores){
            if(score> 21 && scpre> maxUnder) minOver = score;
            else if (score <=21 && score > maxUnder) maxUnder = score;
        }
        return maxUnder == Integer.MIN_VALUE?minOver:maxUnder;
    }

    private ArrayList<Integer> possibleScores(){ ... }

    public boolean busted(){ return score()> 21; }
    public boolean is21() { return score() == 21; }
    public boolean isBlackJack(){ ... }
}
```

- BlackJackCard
```
public class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s){ super(c, s); }
    public int value(){
        if(isAce()) return 1;
        else if (faceValue>= 11 && faceValue <= 13) return 10;
        else return faceValue;
    }

    public int minValue(){
        if(isAce()) return 1;
        else return value();
    }
    public int maxValue(){
        if(isAce()) return 11;
        else return value();
    }
    public booelan isAce(){
        return faceValue == 1;
    }

    public boolean isFaceCard(){
        return faceValue >=11 && faceValue <=13;
    }
}
```

