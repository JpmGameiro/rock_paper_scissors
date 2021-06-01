package utils;

import model.ChoiceEnum;
import model.ChoiceType;
import model.domain.Paper;
import model.domain.Rock;
import model.domain.Scissors;
import java.util.Optional;

public class Mapper {

    private final Rock rock;
    private final Paper paper;
    private final Scissors scissors;

    public Mapper() {
        this.rock = new Rock();
        this.paper = new Paper();
        this.scissors = new Scissors();
    }

    public Optional<ChoiceType> getMoveFromType(ChoiceEnum choiceEnum) {
        switch (choiceEnum) {
            case ROCK: return Optional.of(rock);
            case PAPER: return Optional.of(paper);
            case SCISSORS: return Optional.of(scissors);
            default: return Optional.empty();
        }
    }

}
