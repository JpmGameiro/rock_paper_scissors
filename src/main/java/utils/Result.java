package utils;

public enum Result {

    WIN {
        @Override
        public String resultMessage() {
            return "Congratulations, YOU WON!!!";
        }
    },
    TIE {
        @Override
        public String resultMessage() {
            return "It's a Tie, keep trying!!!";
        }
    },
    LOSE {
        @Override
        public String resultMessage() {
            return "No luck, you lost...";
        }
    };

    public abstract String resultMessage();
}
