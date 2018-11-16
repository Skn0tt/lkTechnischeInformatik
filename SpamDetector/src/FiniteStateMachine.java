public abstract class FiniteStateMachine {

    final int beginningState;
    final int[] endStates;

    protected FiniteStateMachine(int beginningState, int... endStates) {
        this.beginningState = beginningState;
        this.endStates = endStates;
    }

    public boolean matches(String msg) {
        int state = beginningState;

        for (char c : msg.toCharArray()) {
            state = nextState(state, c);
        }

        return isValidEndState(state);
    }

    private boolean isValidEndState(int s) {
        for (int i : endStates) {
            if (i == s) {
                return true;
            }
        }

        return false;
    }

    abstract protected int nextState(int currentState, char c);

}
