
public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.writeLog("INFO", "lol");
        logger.writeLog("DEBUG", "not lol");
        logger.readLog();
        logger.readLog("INFO");
        logger.readLog("DEBUG");
    }

}
