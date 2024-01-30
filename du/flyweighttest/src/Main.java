import flyweight.GameObject;
import flyweight.GameObjectFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GameObjectFactory gameObjectFactory = new GameObjectFactory();

        // Simulate rendering game objects for multiple players
        String[] players = {"Player 1", "Player 2", "Player 3"};

        for (String player : players) {
            GameObject tree = gameObjectFactory.getGameObject("Tree");
            tree.render(player);
        }
    }
}
