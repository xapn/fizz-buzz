package software.works.fizzbuzz;

public class FizzBuzzRange {

    private Player player;
    private int start;

    FizzBuzzRange(Player player) {
        this.player = player;
    }

    FizzBuzzRange from(int start) {
        this.start = start;
        return this;
    }

    public String to(int end) {
        StringBuilder result = new StringBuilder();

        for (int value = start; value <= end; value++) {
            result.append(player.playAtFizzBuzz(value)).append(" ");
        }

        return result.substring(0, result.length() - 1).toString();
    }
}