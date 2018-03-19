
public class Player extends Person {
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public static Player getPlayer(){
        return new Player();
    }

    @Override
    public String toString() {
        return "Player{"+super.getName()+"}  " + card;
    }
}
