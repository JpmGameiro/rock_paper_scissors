import model.ChoiceEnum;
import model.ChoiceType;
import org.junit.jupiter.api.Test;
import utils.Mapper;
import utils.Result;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RPSTest {

    private final Mapper mapper;

    private RPSTest() {
        this.mapper = new Mapper();
    }

    @Test
    void testPlayerWin() {

        Optional<ChoiceType> playerChoice = mapper.getMoveFromType(ChoiceEnum.PAPER);
        ChoiceEnum computerChoice = ChoiceEnum.ROCK;

        if(playerChoice.isPresent()) {
            Optional<Result> result = playerChoice.get().compareMoves(computerChoice);
            assertTrue(result.isPresent());
            assertEquals(result.get().resultMessage(), Result.WIN.resultMessage());
        }
    }

    @Test
    void testTie() {

        Optional<ChoiceType> playerChoice = mapper.getMoveFromType(ChoiceEnum.ROCK);
        ChoiceEnum computerChoice = ChoiceEnum.ROCK;

        if(playerChoice.isPresent()) {
            Optional<Result> result = playerChoice.get().compareMoves(computerChoice);
            assertTrue(result.isPresent());
            assertEquals(result.get().resultMessage(), Result.TIE.resultMessage());
        }
    }

    @Test
    void testPlayerLost() {

        Optional<ChoiceType> playerChoice = mapper.getMoveFromType(ChoiceEnum.SCISSORS);
        ChoiceEnum computerChoice = ChoiceEnum.ROCK;

        if(playerChoice.isPresent()) {
            Optional<Result> result = playerChoice.get().compareMoves(computerChoice);
            assertTrue(result.isPresent());
            assertEquals(result.get().resultMessage(), Result.LOSE.resultMessage());
        }
    }

    @Test
    void testInvalidInput() {

        Optional<ChoiceEnum> choiceEnum = ChoiceEnum.fromValue("invalid input");
        assertTrue(choiceEnum.isEmpty());
    }
}
