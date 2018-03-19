import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public static void RegistrationMenu() {

        showGuestsMenu();

        do {
            System.out.print("--> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Casino.getAdministrator().newRegistration();
                    break;
                case 2:
                    PlayerMenu();
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Not the right choice!");
            }

        } while (choice != 0);
        System.exit(0);
    }

    public static void PlayerMenu() {

        if (Casino.getPlayersList().verifyPlayers()) {
            showPlayerMenu();

            do {
                System.out.print("--> ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Casino.getGamesList().showAllGames();
                        break;
                    case 2:
                        Casino.getPlayersList().replenishBalance();
                        break;
                    case 3:

                        break;
                    case 4:
                        //Session.getCasino().getAdministrator().replenishBalance();
                        break;
                    case 0:
                        RegistrationMenu();
                        break;
                    default:
                        System.out.println("Not the right choice!");
                }

            } while (true);
        } else if (Casino.getAdministrator().checkAdminPassword()) administratorMenu();
        else {
            showGuestsMenu();
            System.out.println("Не вірний пароль! Вам потрібно зареєструватися!");
        }
    }

    public static void gameMenu(int ind) {

        showGameMenu(ind);

        do {
            System.out.print("--> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Casino.getGamesList().getGames().get(ind).startGame();
                    break;
                case 2:
                    Casino.getGamesList().showAllGames();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    PlayerMenu();
                    break;
                default:
                    System.out.println("Not the right choice!");
            }

        } while (true);
    }

    public static void administratorMenu() {

        showAdministratorMenu();

        do {
            System.out.print("--> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Casino.getBank().showBalance();
                    break;
                case 2:
                    Casino.getPlayersList().showAllPlayers();
                    break;
                case 3:

                    break;
                case 0:
                    RegistrationMenu();
                    break;
                default:
                    System.out.println("Not the right choice!");
            }

        } while (true);
    }

    public static void showGuestsMenu() {
        System.out.println(" ▂▃▅▇█▓▒░۩۞۩((①))۩۞۩░▒▓█▇▅▃▂");
        System.out.println("     ✯✯✯ CASINO JACKPOT CITY ✯✯✯    ");
        System.out.println("    ▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫   ");
        System.out.println("    ░       ~ REGISTRATION ~     ░   ");
        System.out.println("    ░  1. Sign up                ░   ");
        System.out.println("    ░  2. Sign in                ░   ");
        System.out.println("    ░  0. Exit                   ░   ");
        System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
    }

    public static void showAdministratorMenu() {
        System.out.println(" ▂▃▅▇█▓▒░۩۞۩((①))۩۞۩░▒▓█▇▅▃▂");
        System.out.println("     ✯✯✯ CASINO JACKPOT CITY ✯✯✯    ");
        System.out.println("    ▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫   ");
        System.out.println("    ░      ~ ADMINISTRATOR ~     ░   ");
        System.out.println("    ░  1. balance of the casino  ░   ");
        System.out.println("    ░  2. check the player card  ░   ");
        System.out.println("    ░  3. -- -- -- -- -- -- -- - ░   ");
        System.out.println("    ░  0. Exit                   ░   ");
        System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
    }

    public static void showGameMenu(int ind) {
        System.out.println(" ▂▃▅▇█▓▒░۩۞۩((①))۩۞۩░▒▓█▇▅▃▂");
        System.out.println("     ✯✯✯ CASINO JACKPOT CITY ✯✯✯    ");
        System.out.println("    ▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫   ");
        System.out.println("            " + Casino.getGamesList().getGames().get(ind).getName());
        System.out.println("    ░                            ░         Welcome:" + " " + Casino.getPlayersList().getPlayer().getName());
        System.out.println("    ░  1. start game             ░        ✵✵✵✵✵✵✵✵✵✵✵✵");
        System.out.println("    ░  2. change game            ░         balance:" + " " + Casino.getPlayersList().getPlayer().getCard().getBalance());
        System.out.println("    ░  -- -- -- -- -- -- -- -- - ░         deposit:" + " " + Casino.getPlayersList().getPlayer().getCard().getDeposit());
        System.out.println("    ░  0. exit                   ░         profit:" + "  " + Casino.getPlayersList().getPlayer().getCard().getProfit());
        System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
    }

    public static void showPlayerMenu() {
        System.out.println(" ▂▃▅▇█▓▒░۩۞۩((①))۩۞۩░▒▓█▇▅▃▂");
        System.out.println("     ✯✯✯ CASINO JACKPOT CITY ✯✯✯    ");
        System.out.println("    ▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫▪ ▫   ");
        System.out.println("    ░          ~ MENU ~          ░   ");
        System.out.println("    ░                            ░          Welcome:" + " " + Casino.getPlayersList().getPlayer().getName());
        System.out.println("    ░  1. show all games         ░         ✵✵✵✵✵✵✵✵✵✵✵✵");
        System.out.println("    ░  2. replenish the balance  ░          balance:" + " " + Casino.getPlayersList().getPlayer().getCard().getBalance());
        System.out.println("    ░  -- -- -- -- -- -- -- -- - ░          deposit:" + " " + Casino.getPlayersList().getPlayer().getCard().getDeposit());
        System.out.println("    ░  0. Exit                   ░          profit:" + "  " + Casino.getPlayersList().getPlayer().getCard().getProfit());
        System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
    }
}

