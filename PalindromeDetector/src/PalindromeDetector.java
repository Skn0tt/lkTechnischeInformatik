enum Q {
    q0,
    q2,
    q3
}

enum Sigma {
    a,
    b
}

enum Gamma {
    A,
    B,
    BOTTOM
}

public class PalindromeDetector extends DeterministicPushDownAutomata<Q, Sigma, Gamma> {

    @Override
    Q getInitialState() {
        return Q.q0;
    }

    @Override
    Gamma getIntialStackElement() {
        return Gamma.BOTTOM;
    }

    @Override
    boolean isValidEndState(Q s) {
        return s == Q.q3;
    }

    @Override
    Transition<Q, Gamma> nextState(Q currentState, Gamma stackTop, Sigma input) {
        switch (currentState) {
            case q0:
                switch (input) {
                    case a:
                        switch (stackTop) {
                            case A:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.A, Gamma.A);
                            case B:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.A, Gamma.B);
                            case BOTTOM:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.A, Gamma.BOTTOM);
                        }
                    case b:
                        switch (stackTop) {
                            case A:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.B, Gamma.A);
                            case B:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.B, Gamma.B);
                            case BOTTOM:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.B, Gamma.BOTTOM);

                        }
                }
            case q2:
                switch (input) {
                    case a:
                        switch (stackTop) {
                            case A:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.A, Gamma.A);
                            case B:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.A, Gamma.B);
                            case BOTTOM:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.A, Gamma.BOTTOM);
                        }
                    case b:
                        switch (stackTop) {
                            case A:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.B, Gamma.A);
                            case B:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.B, Gamma.B);
                            case BOTTOM:
                                return new Transition<Q, Gamma>(Q.q0, Gamma.B, Gamma.BOTTOM);

                        }
                }
        }
    }

}
