import controller.RPSController;
import utils.Mapper;

public class RPSGame {

    public static void main(String[] args) {
        System.out.println("Welcome To Rock, Paper, Scissors!");
        RPSController rpsController = new RPSController(new Mapper());
        rpsController.play();
    }

}
