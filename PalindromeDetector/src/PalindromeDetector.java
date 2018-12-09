enum Q {
    RECORDING_START_OF_WORD,
    READ_ZERO,
    CONFIRMING_END_OF_WORD,
    IS_PALINDROME,
    SINK,
}

enum Sigma {
    a("a"),
    b("b"),
    ZERO("0");

    private String value;

    public String getValue() {
        return this.value;
    }

    Sigma(String action) {
        this.value = action;
    }
}

enum Gamma {
    A,
    B,
    BOTTOM
}

public class PalindromeDetector extends DeterministicPushDownAutomaton<Q, Sigma, Gamma> {

    @Override
    Q getInitialState() {
        return Q.RECORDING_START_OF_WORD;
    }

    @Override
    Gamma getIntialStackElement() {
        return Gamma.BOTTOM;
    }

    @Override
    boolean isValidEndState(Q s) {
        return s == Q.IS_PALINDROME;
    }

    @Override
    Transition<Q, Gamma> nextState(Q currentState, Gamma stackTop, Sigma input) {
        if (input == null) {
            boolean isValidPalindrome = currentState == Q.CONFIRMING_END_OF_WORD && stackTop == Gamma.BOTTOM;
            return isValidPalindrome
                ? new Transition<Q, Gamma>(Q.IS_PALINDROME, stackTop)
                : new Transition<Q, Gamma>(Q.SINK, stackTop);
        }

        switch (currentState) {
            case RECORDING_START_OF_WORD:
                switch (input) {
                    case ZERO:
                        return new Transition<Q, Gamma>(Q.READ_ZERO, stackTop);
                    case a:
                        return new Transition<Q, Gamma>(Q.RECORDING_START_OF_WORD, stackTop, Gamma.A);
                    case b:
                        return new Transition<Q, Gamma>(Q.RECORDING_START_OF_WORD, stackTop, Gamma.B);
                }
            case READ_ZERO:
            case CONFIRMING_END_OF_WORD:
                switch (input) {
                    case a:
                        return stackTop == Gamma.A
                          ? new Transition<Q, Gamma>(Q.CONFIRMING_END_OF_WORD)
                          : new Transition<Q, Gamma>(Q.SINK, stackTop);
                    case b:
                        return stackTop == Gamma.B
                          ? new Transition<Q, Gamma>(Q.CONFIRMING_END_OF_WORD)
                          : new Transition<Q, Gamma>(Q.SINK, stackTop);
                    case ZERO:
                        return new Transition<Q, Gamma>(Q.SINK, stackTop);
                }
            case SINK:
                return new Transition<Q, Gamma>(Q.SINK, stackTop);
            default:
                return null;
        }
    }

}
