public class Casino {

    private static Bank bank = Bank.getBank();
    private static GameList gamesList = GameList.getGamesList();
    private static PlayerList playersList = PlayerList.getPlayersList();
    private static Administrator administrator = Administrator.getAdministrator();

    public static PlayerList getPlayersList() {
        return playersList;
    }

    public static Bank getBank() {
        return bank;
    }

    public static GameList getGamesList() {
        return gamesList;
    }

    public static Administrator getAdministrator() {

        return administrator;
    }
}
