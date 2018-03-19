import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayingCards {
    private Random random = new Random();
    private Map<String, Integer> cards;

    public void setCards() {
        cards = new HashMap<>();
        cards.put("Шістка ♦", 6);
        cards.put("Шістка ♤", 6);
        cards.put("Шістка ♧", 6);
        cards.put("Шістка ♥", 6);
        cards.put("Сімка ♦", 7);
        cards.put("Сімка ♤", 7);
        cards.put("Сімка ♧", 7);
        cards.put("Сімка ♥", 7);
        cards.put("Вісімка ♦", 8);
        cards.put("Вісімка ♤", 8);
        cards.put("Вісімка ♧", 8);
        cards.put("Вісімка ♥", 8);
        cards.put("Дев'ятка ♦", 9);
        cards.put("Дев'ятка ♤", 9);
        cards.put("Дев'ятка ♧", 9);
        cards.put("Дев'ятка ♥", 9);
        cards.put("Десятка ♦", 10);
        cards.put("Десятка ♤", 10);
        cards.put("Десятка ♧", 10);
        cards.put("Десятка ♥", 10);
        cards.put("Валет ♦", 10);
        cards.put("Валет ♤", 10);
        cards.put("Валет ♧", 10);
        cards.put("Валет ♥", 10);
        cards.put("Дама ♦", 10);
        cards.put("Дама ♤", 10);
        cards.put("Дама ♧", 10);
        cards.put("Дама ♥", 10);
        cards.put("Король ♦", 10);
        cards.put("Король ♤", 10);
        cards.put("Король ♧", 10);
        cards.put("Король ♥", 10);
        cards.put("Туз ♦", 11);
        cards.put("Туз ♤", 11);
        cards.put("Туз ♧", 11);
        cards.put("Туз ♥", 11);
    }

    public Map<String, Integer> getCards() {
        return cards;
    }

    public static PlayingCards getPlayingCards(){
        return new PlayingCards();
    }
}
