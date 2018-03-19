import java.util.ArrayList;
import java.util.Scanner;

public class GameList {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Game> games = new ArrayList<>();

    public void addGame() {
        games.add(Game_SlotMachine.getSlotMachine());
        games.add(Game_BlackJack.getBlackJack());
        games.add(Game_Roulette.getRoulette());

    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void showAllGames() {
        int n = 0;
        games.clear();
        addGame();
        System.out.println("Всі доступні ігри:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        for (Game game : games) System.out.println((++n) + " - " + game);
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Виберіть гру: ");
        Menu.gameMenu(scanner.nextInt()-1);
    }

    public static GameList getGamesList() {
        return new GameList();
    }
}
