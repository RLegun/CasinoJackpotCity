import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game_BlackJack implements Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private final String name = "GAME_BlackJack";
    private int sumPointsPlayer = 0;
    private int sumPointsCroupier = 0;
    private int bet;

    @Override
    public void startGame() {
        if (Casino.getPlayersList().getPlayer().getCard().getBalance() > 0) {
            int rnd = random.nextInt(35);
            int counter = 0;
            int playerChoice;
            if (sumPointsPlayer == 0) {
                makeBet();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Щоб потягти карту нажимайте '1'   'stop game' нажимайте '0'");
            }
            playerChoice = scanner.nextInt();
            PlayingCards cards = PlayingCards.getPlayingCards();
            cards.setCards();
            Set<String> nameCard = cards.getCards().keySet();
            Iterator<String> iterator = nameCard.iterator();
            while (counter != rnd) {
                iterator.next();
                counter++;
            }
            String myCard = iterator.next();
            String croupierCard = iterator.next();
            if (playerChoice != 0) {
                sumPointsPlayer += cards.getCards().get(myCard);
                sumPointsCroupier += cards.getCards().get(croupierCard);
                System.out.println("~~~~~~~~~~~~");
                System.out.println(myCard);
            }
            if (sumPointsPlayer == 21) {
                System.out.println("~~~~~~~~~~~~");
                System.out.println("Ви набрали 21 очко - це ПЕРЕМОГА!");
                System.out.println("__________________________");
                restartGame();
            }
            if (sumPointsPlayer > 21) {
                System.out.println("~~~~~~~~~~~~");
                System.out.println("Перебір очок - ви програли!");
                System.out.println("__________________________");
                restartGame();
            }
            if (playerChoice == 0) {
                System.out.println("__________________________");
                System.out.println("Ви набрали " + sumPointsPlayer + " очок");
                System.out.println("Круп'є набрав " + sumPointsCroupier + " очок");
                if (sumPointsPlayer > sumPointsCroupier) System.out.println("Ви перемогли ☺");
                else if (sumPointsPlayer == sumPointsCroupier) System.out.println("Нічия ☺");
                else if (sumPointsPlayer < sumPointsCroupier)System.out.println("Ви програли \uD83D\uDE15 ");
                System.out.println("__________________________");
                restartGame();
            }
            if (sumPointsPlayer < 21 && playerChoice != 0) startGame();
        } else System.out.println("Недостатньо коштів на балансі...");
    }

    public void restartGame() {
        getResult();
        getProfit();
        sumPointsPlayer = 0;
        sumPointsCroupier = 0;
        System.out.println("зіграти ще раз '1'");
        System.out.println("головне меню '0'");
        if (scanner.nextInt() == 1)startGame();
        else Menu.PlayerMenu();
    }

    public void getResult() {

        if (sumPointsPlayer > 21){
            Casino.getPlayersList().getPlayer().getCard().setBalance(-bet);
            Casino.getBank().setBalance(bet);
        }else if (sumPointsPlayer == 21){
            Casino.getPlayersList().getPlayer().getCard().setBalance(bet);
            Casino.getBank().setBalance(-bet);
        }else if (sumPointsPlayer > sumPointsCroupier){
            Casino.getPlayersList().getPlayer().getCard().setBalance(bet);
            Casino.getBank().setBalance(-bet);
        }else if (sumPointsPlayer < sumPointsCroupier){
            Casino.getPlayersList().getPlayer().getCard().setBalance(-bet);
            Casino.getBank().setBalance(bet);
        }
    }

    public void getProfit() {
        Casino.getPlayersList().getPlayer().getCard().setProfit(Casino.getPlayersList().getPlayer().getCard().getBalance()
                - Casino.getPlayersList().getPlayer().getCard().getDeposit());
    }

    @Override
    public void makeBet() {
        System.out.print("Робіть ставку: ");
        bet = scanner.nextInt();
        if (Casino.getPlayersList().getPlayer().getCard().getBalance() >= bet) {
            System.out.println("Ставка прийнята...");
            System.out.println("___________________");
        }
        else {
            System.out.println("~~~~~~~~~~~~");
            System.out.println("Недостатньо коштів!!!");
            System.out.println("У вас на балансі всьго " + Casino.getPlayersList().getPlayer().getCard().getBalance());
            System.out.println("~~~~~~~~~~~~");
            System.out.println("Поповнити та продовжити '1'");
            System.out.println("Зробити іншу ставку '2'");
            System.out.println("Вийти '0'");
            int choice = scanner.nextInt();
            if (choice == 1) {
                Casino.getPlayersList().replenishBalance();
                makeBet();
            }
            if (choice == 2)makeBet();
            if (choice == 0)Menu.RegistrationMenu();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Game_BlackJack getBlackJack() {
        return new Game_BlackJack();
    }
}
