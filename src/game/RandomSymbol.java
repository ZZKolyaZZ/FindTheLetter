package game;

import java.util.Random;

public class RandomSymbol {

    private final static String lvls = "А МОИВЛКШПРЕГСБУГЫДФЖЧТЙХЯЬЦЩЮЗЭЪ";

    private Random rnd;
    private String vals;

    public RandomSymbol(int level){
        rnd = new Random();
        vals = lvls.substring(0, level);
    }

    public String nextChar() {
        int position = (int) (rnd.nextDouble() * vals.length());
        return Character.toString(vals.charAt(position));
    }

    public static int max_lvl() {
        return lvls.length();
    }
}
