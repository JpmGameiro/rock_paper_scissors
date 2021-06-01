package model.domain;

import model.ChoiceEnum;
import utils.Result;
import model.ChoiceType;
import java.util.Optional;

public class Rock implements ChoiceType {

    @Override
    public Optional<Result> compareMoves(ChoiceEnum choiceEnum) {
        switch (choiceEnum) {
            case SCISSORS: return Optional.of(Result.WIN);
            case ROCK: return Optional.of(Result.TIE);
            case PAPER: return Optional.of(Result.LOSE);
            default: return Optional.empty();
        }
    }
}
