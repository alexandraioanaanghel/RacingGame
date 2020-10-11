package org.alexandraanghel.persistence;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileRankingRepository  implements RankingsRepository{

    private String filePath = "target/rankings_" + System.currentTimeMillis();
    private BufferedWriter bufferWriter;

    public FileRankingRepository() {
        try {
            bufferWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            throw  new RuntimeException("Failed to oepn file: " + filePath);
        }
    }

    @Override
    public void addRankingItem(int rank, String competitorName, double totalDistance) {

        String rankingItem = rank + ". " + competitorName + ": " + totalDistance + " km";
        try {
            bufferWriter.write(rankingItem);
            bufferWriter.newLine();
        } catch (IOException e) {
            throw  new RuntimeException("Failed to write content to file");
        }
    }

    public void close()
    {
        try {
            bufferWriter.flush();
            bufferWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file");
        }
    }

}
