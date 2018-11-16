public class FSMImpl extends FiniteStateMachine implements ContainsInfoAboutJamesBondParser {

    protected FSMImpl() {
        super(0, 3);
    }

    public boolean containsInfo(String msg) {
        return this.matches(msg);
    }

   protected int nextState(int state, char c) {
        switch (state) {
            case 0:
                return c == '0'
                        ? 1
                        : 0;
            case 1:
                return c == '0'
                        ? 2
                        : 0;
            case 2:
                return c == '7'
                        ? 3
                        : 0;
            case 3:
                return 3;
            default:
                return -1;
        }
    }

}
