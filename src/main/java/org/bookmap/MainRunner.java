package org.bookmap;

import org.bookmap.logic.FileDataProcessor;
import org.bookmap.util.ProcessingConsumer;


public class MainRunner {
    public static void main(String[] args) {
        printTimeExecution(() -> {
            FileDataProcessor fileDataProcessor = new FileDataProcessor();
            fileDataProcessor.processResultMatchDetermination();
        });
    }

    private static void printTimeExecution(ProcessingConsumer consumer) {
        long startTime = System.nanoTime();
        consumer.acceptAndProcessing();
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.printf("The time execution: %.6f seconds\n", durationInSeconds);
    }
}
