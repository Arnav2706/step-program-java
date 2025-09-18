import java.util.Objects;

class Game {
    protected String title;

    public Game(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game: " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game g = (Game) obj;
        return Objects.equals(title, g.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

public class CardGame extends Game {
    private int numberOfCards;

    public CardGame(String title, int numberOfCards) {
        super(title);
        this.numberOfCards = numberOfCards;
    }

    @Override
    public String toString() {
        return super.toString() + ", CardGame with " + numberOfCards + " cards";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CardGame)) return false;
        CardGame cg = (CardGame) obj;
        return numberOfCards == cg.numberOfCards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfCards);
    }

    public static void main(String[] args) {
        CardGame cg1 = new CardGame("Poker", 52);
        CardGame cg2 = new CardGame("Poker", 52);
        CardGame cg3 = new CardGame("Rummy", 54);

        System.out.println(cg1);
        System.out.println(cg2);
        System.out.println("cg1 equals cg2? " + cg1.equals(cg2));
        System.out.println("cg1 equals cg3? " + cg1.equals(cg3));
    }
}
