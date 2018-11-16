public class ProceduralImpl implements ContainsInfoAboutJamesBondParser {

    public boolean containsInfo(String msg) {

        for (int i = 0; i < msg.length() - 2; i++) {
            String threeChars = msg.substring(i, i + 3);
            if (threeChars.equals("007")) {
                return true;
            }
        }

        return false;
    }

}
