package model;

import utils.Result;
import java.util.Optional;

public interface ChoiceType {

    Optional<Result> compareMoves(ChoiceEnum choiceEnum);
}
