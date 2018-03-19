import java.io.*;

public class DataBase {

    public static void writeToDatabase(String name, String password) {
        File file;
        PrintWriter writer;
        file = new File("C:\\Users\\Роман\\Desktop\\write.txt");
        try {
            writer = new PrintWriter(new FileWriter(file, true));
            writer.println(name);
            writer.println(password);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromDataBase() {
        String line;
        Player player = null;
        BufferedReader readFile;
        int cardId = 0;
        int x = 2;
        try {
            readFile = new BufferedReader(new FileReader(
                    "C:\\Users\\Роман\\Desktop\\write.txt"));
            while ((line = readFile.readLine()) != null) {
                if (x % 2 == 0) {
                    player = Player.getPlayer();
                    player.setCard(Card.getCard());
                    player.getCard().setId(++cardId);
                    player.setName(line);
                }
                else {
                    player.getCard().setPassword(line);
                    Casino.getPlayersList().setPlayersList(player);
                }
                x++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
