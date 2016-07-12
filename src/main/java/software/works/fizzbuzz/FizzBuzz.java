package software.works.fizzbuzz;

public class FizzBuzz {

    private Player player;

    public FizzBuzz() {
        player = new Player();
    }

    public String of(int value) {
        return player.playAtFizzBuzz(value);
    }

    public FizzBuzzRange from(int start) {
        return new FizzBuzzRange(player).from(start);
    }
}