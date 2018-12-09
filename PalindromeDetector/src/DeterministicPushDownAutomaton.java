import java.util.Stack;

public abstract class DeterministicPushDownAutomaton<Q extends Enum<Q>, Sigma extends Enum<Sigma>, Gamma extends Enum<Gamma>> {

    public boolean validate(Stack<Sigma> input) {
        final Stack<Gamma> stack = new Stack<>();
        stack.push(this.getIntialStackElement());

        Q currentState = this.getInitialState();

        for (Sigma c : input) {
            Gamma topOfStack = stack.pop();
            Transition<Q, Gamma> result = this.nextState(currentState, topOfStack, c);
            for (Gamma v : result.getNewStack()) {
                stack.push(v);
            }

            currentState = result.getNewState();
        }

        Transition<Q, Gamma> lastResult = this.nextState(currentState, stack.pop(), null);
        for (Gamma v : lastResult.getNewStack()) {
            stack.push(v);
        }

        currentState = lastResult.getNewState();

        return this.isValidEndState(currentState);
    }

    abstract Q getInitialState();
    abstract Gamma getIntialStackElement();
    abstract boolean isValidEndState(Q s);

    abstract Transition<Q, Gamma> nextState(Q currentState, Gamma stackTop, Sigma input);

    class Transition<Q extends Enum<Q>, Gamma extends Enum<Gamma>> {

        final Q newState;
        final Gamma[] newStack;

        /**
         * Transition
         * @param newState
         * @param newStack from bottom to top
         */
        public Transition(Q newState, Gamma... newStack) {
            this.newState = newState;
            this.newStack = newStack;
        }

        public Q getNewState() {
            return newState;
        }

        public Gamma[] getNewStack() {
            return newStack;
        }
    }

}
