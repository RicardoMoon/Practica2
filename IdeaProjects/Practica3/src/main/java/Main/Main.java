package Main;

import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by Adolfo on 10/6/2017.
 */
public class Main {
    public static void main(String[] args) {
        staticFiles.location("/publico");

        enableDebugScreen();


    }
}
