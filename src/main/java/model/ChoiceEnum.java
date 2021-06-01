package model;

import java.util.Optional;
import java.util.Random;
import static java.util.Arrays.stream;

public enum ChoiceEnum {
    ROCK("ROCK"), PAPER("PAPER"), SCISSORS("SCISSORS");

    private static final Random random = new Random();

    ChoiceEnum(String choice) {}

    public static Optional<ChoiceEnum> fromValue(String value) {
        return stream(values())
                .filter(choice -> choice.name().equalsIgnoreCase(value))
                .findFirst();
    }

    public static Optional<ChoiceEnum> randomValue() {
        return Optional.of(ChoiceEnum.values()[random.nextInt(ChoiceEnum.values().length)]);
    }

    @Override
    public String toString() {
        return this.name();
    }

}