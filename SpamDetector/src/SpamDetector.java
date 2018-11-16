public class SpamDetector extends FiniteStateMachine {

    public SpamDetector() {
        super(0, 6);
    }

    @Override
    protected int nextState(int currentState, char c) {
        switch(currentState) {
            case 0:
                return c == 'v'
                        ? 1
                        : 0;
            case 1:
                return c == 'i'
                        ? 2
                        : 0;
            case 2:
                return c == 'a'
                        ? 3
                        : 0;
            case 3:
                return c == 'g'
                        ? 4
                        : 0;
            case 4:
                return c == 'r'
                        ? 5
                        : 0;
            case 5:
                return c == 'a'
                        ? 6
                        : 0;
            case 6:
                return 6;
        }
        return 0;
    }
}
