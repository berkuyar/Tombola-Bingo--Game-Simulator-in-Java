
public class _22010310073_Card {
    private String name;
    private int[] numbers;
    private boolean[] marked;

    public _22010310073_Card(String name, int[] numbers) {
        this.name = name;
        this.numbers = numbers;
        this.marked = new boolean[numbers.length];
    }

    public String getName() {
        return name;
    }

    public boolean markNumber(int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number && !marked[i]) {
                marked[i] = true;
                return true;
            }
        }
        return false;
    }

    public boolean isCompleted() {
        for (boolean mark : marked) {
            if (!mark) return false;
        }
        return true;
    }

    public String displayCard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(marked[i] ? "#" : "").append(" ");
        }
        return sb.toString().trim();
    }
}
