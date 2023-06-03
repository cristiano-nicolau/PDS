import startypes.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarFactory extends StarType{
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;

    static Map <Character, StarType> starTypes = new HashMap<>();

    public static StarType getStarType (char type){
        StarType star = starTypes.get(type);

        if (star == null) {
            int x = random(0, CANVAS_SIZE);
            int y = random(0, CANVAS_SIZE);

            switch (type) {
                case 'O':
                    star = new OStar(x, y);
                    break;
                case 'A':
                    star = new AStar(x, y);
                    break;
                case 'B':
                    star = new BStar(x, y);
                    break;
                case 'F':
                    star = new FStar(x, y);
                    break;
                case 'G':
                    star = new GStar(x, y);
                    break;
                case 'K':
                    star = new KStar(x, y);
                    break;
                case 'M':
                    star = new MStar(x, y);
                    break;

            }
            starTypes.put(type, star);
            }
        return star;
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));    }
    
}