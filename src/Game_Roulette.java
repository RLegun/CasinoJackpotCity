import java.util.*;

public class Game_Roulette implements Game {
    private final String name = "Game_Roulette";
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private int userNumber;
    private int searchNumber;
    private int bet;

    public String getName() {
        return name;
    }

    @Override
    public void startGame() {
        if (Casino.getPlayersList().getPlayer().getCard().getBalance() > 0) {
            makeBet();
            List<Integer> N = new ArrayList<>();
            for (int i = 0; i < 5; i++) N.add(random.nextInt(99));
            searchNumber = N.get(random.nextInt(N.size() - 1));
            System.out.println("Вгадайте яке число вичеркне комп'ютер:");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
            for (Integer x : N) System.out.print(x + " ⋆ ");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
            userNumber = scanner.nextInt();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
            for (Integer aN : N) {
                if (searchNumber != aN) System.out.print(aN + " ⋆ ");
                else System.out.print("✖" + " ⋆ ");
            }
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
            if (userNumber == searchNumber) System.out.println("Ви перемогли ☺");
            else System.out.println("Ви програли \uD83D\uDE15");
            restartGame();
        } else System.out.println("Недостатньо коштів на балансі...");

    }

    public void restartGame() {
        getResult();
        getProfit();
        userNumber = 0;
        searchNumber = 0;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("зіграти ще раз '1'");
        System.out.println("головне меню '0'");
        if (scanner.nextInt() == 1)startGame();
        else Menu.PlayerMenu();
    }

    public void getResult() {
        int coefficient = 5;
        if (userNumber == searchNumber){
            Casino.getPlayersList().getPlayer().getCard().setBalance(bet*coefficient);
            Casino.getBank().setBalance(-bet*coefficient);
        }
        else {
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
            System.out.println("~~~~~~~~~~~~");
            int choice = scanner.nextInt();
            if (choice == 1) {
                Casino.getPlayersList().replenishBalance();
                makeBet();
            }
            if (choice == 2)makeBet();
            if (choice == 0)Menu.RegistrationMenu();
        }
    }

    public static Game_Roulette getRoulette() {
        return new Game_Roulette();
    }

    @Override
    public String toString() {
        return name;
    }
}
