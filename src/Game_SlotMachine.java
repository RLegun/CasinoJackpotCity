import java.util.*;

public class Game_SlotMachine implements Game {
    private Scanner scanner = new Scanner(System.in);
    private final String name = "Game_SlotMachine";
    private Random r = new Random();
    private int bet;
    private boolean win = false;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void startGame() {
        if (Casino.getPlayersList().getPlayer().getCard().getBalance() > 0) {
            makeBet();
            win = false;
            List<String> list = Arrays.asList("♏", "♒", "♒", "♋");
            Set<String> z = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                String item = list.get(r.nextInt(4));
                z.clear();
                for (int j = 0; j < 4; j++) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(item + "   ");
                    z.add(item);
                    item = list.get(r.nextInt(4));
                }
                if (z.size() == 1) {
                    System.out.print("  <-- линія зіграла");
                    win = true;
                }
                System.out.println("\n");
            }
            System.out.println("=================");
            if (win) System.out.println("Ви виграли ☺");
            if (!win) System.out.println("Ви програли \uD83D\uDE15");
            getResult();
            getProfit();
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("зіграти ще раз '1'");
            System.out.println("головне меню '0'");
        } else System.out.println("Недостатньо коштів на балансі...");
    }

    @Override
    public void makeBet() {
        System.out.print("Робіть ставку: ");
        bet = scanner.nextInt();
        if (Casino.getPlayersList().getPlayer().getCard().getBalance() >= bet) {
            System.out.println("Ставка прийнята...");
            System.out.println("=================");
        } else {
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
            } else if (choice == 2) makeBet();
            else if (choice == 0) Menu.RegistrationMenu();
        }
    }

    public void getResult() {
        int coefficient = 5;
        if (win) {
            Casino.getPlayersList().getPlayer().getCard().setBalance(bet * coefficient);
            Casino.getBank().setBalance(-bet*coefficient);
        }
        if (!win) {
            Casino.getPlayersList().getPlayer().getCard().setBalance(-bet);
            Casino.getBank().setBalance(bet);
        }
    }

    public void getProfit() {
        Casino.getPlayersList().getPlayer().getCard().setProfit(Casino.getPlayersList().getPlayer().getCard().getBalance()
                - Casino.getPlayersList().getPlayer().getCard().getDeposit());
    }


    public static Game_SlotMachine getSlotMachine() {
        return new Game_SlotMachine();
    }

    @Override
    public String toString() {
        return name;
    }
}
