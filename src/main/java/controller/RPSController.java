package controller;

import utils.Mapper;
import utils.Result;
import model.ChoiceType;
import model.ChoiceEnum;
import java.util.Optional;
import java.util.Scanner;

public class RPSController {

    private boolean keepPlaying;
    private final Scanner playerInput;
    private final Mapper mapper;

    public RPSController(Mapper mapper) {
        this.mapper = mapper;
        this.playerInput = new Scanner(System.in);
        this.keepPlaying = true;
    }

    public void play() {

        while (keepPlaying) {
            System.out.print("Pick your move: ROCK, PAPER, SCISSORS -> ");

            Optional<ChoiceEnum> playerChoiceType = ChoiceEnum.fromValue(playerInput.next());

            if(playerChoiceType.isPresent()) {
                Optional<ChoiceEnum> computerMove = ChoiceEnum.randomValue();
                assert computerMove.isPresent();

                System.out.println("Computer move: " + computerMove.get().name());

                Optional<ChoiceType> move = mapper.getMoveFromType(playerChoiceType.get());
                assert move.isPresent();
                Optional<Result> result = move.get().compareMoves(computerMove.get());

                result.ifPresent(res -> System.out.println(res.resultMessage()));
            } else {
                System.out.println("Please provide a valid input...");
            }

            playAgain();
        }

    }

    private void playAgain() {
        System.out.println("If you want to quit type NO/no/n. Press any other key to continue...");
        String keepOrQuit = playerInput.next();

        if((keepOrQuit.equalsIgnoreCase("n") || keepOrQuit.equalsIgnoreCase("no"))) {
            keepPlaying = false;
        }
    }
}
