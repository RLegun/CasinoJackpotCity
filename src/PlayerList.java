import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PlayerList {
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> playersList = new ArrayList<>();
    private int indexOfPlayer;
    private String password;

    public String getPassword() {
        return password;
    }

    public Player getPlayer(){
        return playersList.get(indexOfPlayer-1);
    }

    public void setPlayersList(Player player) {
        playersList.add(player);
    }

    public boolean verifyPlayers() {
        indexOfPlayer = 0;
        System.out.print("Введіть ваш логін: ");
        String login = scanner.next();
        System.out.print("Введіть ваш пароль: ");
        password = scanner.next();
        for (int i = 0; i < playersList.size(); i++) {
            if (Objects.equals(playersList.get(indexOfPlayer).getName(), login)
                    && Objects.equals(playersList.get(indexOfPlayer++).getCard().getPassword(), password)) {
                return true;
            }
        }
        return false;
    }

    public void showAllPlayers(){
        int n = 0;
        System.out.println("Всі доступні ігри:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        for (Player player : playersList) System.out.println((++n) + " - " + player);
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }

    public void replenishBalance(){
        System.out.print("На яку суму бажаєте поповнити депозит: ");
        getPlayer().getCard().setDeposit(scanner.nextDouble());
        System.out.println("Депозит поповнено...");
    }

    public int getSize(){
        return playersList.size();
    }

    public static PlayerList getPlayersList(){
        return new PlayerList();
    }
}
