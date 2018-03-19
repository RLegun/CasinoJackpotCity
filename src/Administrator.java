import java.util.Objects;
import java.util.Scanner;

public class Administrator extends Employee {
    private static  Scanner scanner = new Scanner(System.in);
    private static final String password = "0000";

    public  boolean checkAdminPassword() {
        if (Objects.equals(Casino.getPlayersList().getPassword(), password))return true;
        else return false;
    }

    public  void newRegistration() {
        int cardId = Casino.getPlayersList().getSize();
        Player player = Player.getPlayer();
        player.setCard(Card.getCard());
        player.getCard().setId(++cardId);
        System.out.print("Введіть ваш логін: ");
        String userName = scanner.next();
        player.setName(userName);
        System.out.print("Введіть ваш пароль: ");
        String userPassword = scanner.next();
        player.getCard().setPassword(userPassword);
        Casino.getPlayersList().setPlayersList(player);
        System.out.println("Ви зареєстровані...");
        DataBase.writeToDatabase(userName, userPassword);
        System.out.println(Casino.getPlayersList().getSize());

    }

    public static Administrator getAdministrator() {
        return new Administrator();
    }
}
