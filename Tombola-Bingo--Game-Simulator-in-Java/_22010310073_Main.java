
import java.io.*;
import java.util.*;

public class _22010310073_Main {
    public static void main(String[] args) throws InterruptedException {
        List<_22010310073_Player> players = new ArrayList<>();
        Map<String, _22010310073_Card> cards = new HashMap<>();
        
        // Load data from file
        try (BufferedReader br = new BufferedReader(new FileReader("Bilgiler.txt"))) {
            String line;
            boolean readingPlayers = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("Kişiler ve Seçtikleri Kart")) continue;
                if (line.startsWith("Oyun Kartları:")) {
                    readingPlayers = false;
                    continue;
                }
                if (readingPlayers) {
                    String[] parts = line.split(" ");
                    players.add(new _22010310073_Player(parts[0], null));
                } else {
                    String[] parts = line.split(" ");
                    String cardName = parts[0];
                    int[] numbers = Arrays.stream(parts, 1, parts.length).mapToInt(Integer::parseInt).toArray();
                    cards.put(cardName, new _22010310073_Card(cardName, numbers));
                }
            }

            // Assign cards to players
            for (_22010310073_Player player : players) {
                player.getCard().getName();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Play the game
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) numbers.add(i);
        Collections.shuffle(numbers);

        System.out.println("Game Started!");
        for (int number : numbers) {
            System.out.println("Drawn number: " + number);
            for (_22010310073_Player player : players) {
                if (player.getCard().markNumber(number)) {
                    System.out.println(player.displayStatus());
                }
            }
            System.out.println("------------------------------");
            Thread.sleep(500);

            for (_22010310073_Player player : players) {
                if (player.getCard().isCompleted()) {
                    System.out.println("Game Over. Winner: " + player.getName());
                    return;
                }
            }
        }
    }
}
