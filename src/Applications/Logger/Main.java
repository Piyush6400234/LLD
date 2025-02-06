package Applications.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.error("error in file 1");
        logger.debug("debugging file 4");
    }
}
