
import java.io.*;

public class Logger {

    private final File logFile = new File("log.log");

    public void writeLog(String level, String message) {
        try (FileWriter writer = new FileWriter(logFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(level + ": " + message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            writeLog("DEBUG", e.getMessage());
            e.printStackTrace();
        }
    }

    public void readLog() {
        System.out.println("\nReading");
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            writeLog("DEBUG", e.getMessage());
            e.printStackTrace();
        }
    }

    public void readLog(String level) {
        System.out.println("\nReading only with the prefix " + level);
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(level)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            writeLog("DEBUG", e.getMessage());
            e.printStackTrace();
        }
    }

}
