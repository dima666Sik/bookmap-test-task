package org.bookmap.logic;

import org.bookmap.exception_handler.FileProcessingException;
import org.bookmap.file.ReadableFile;
import org.bookmap.file.TextFileReader;
import org.bookmap.file.TextFileWriter;
import org.bookmap.file.WritableFile;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;

public class FileDataProcessor {
    private static final String FILE_NAME = "input.txt";

    private boolean isValidStringLength(String str, int length) {
        return length == str.length();
    }

    private boolean isStringHaveOnlyAB(String str) {
        return str.matches("[AB]+");
    }

    private boolean isValidIndexDataSubstring(int l, int r) {
        return l <= r;
    }

    private boolean isValidSearchingSymbol(int l, int r, int k){
        return k <= r - l + 1;
    }

    private static int findIndex(int[] arr, int value) {
        int index = Arrays.binarySearch(arr, value);
        return index >= 0 ? index : -1;
    }

    private int processQuery(int l, int r, int k, String str) {
        String subStr = str.substring(l - 1, r);

        int n = subStr.length();

        int[] arrCounterA = new int[n];
        int[] arrCounterB = new int[n];

        // Precomputing counts of A and B symbols (s)
        for (int i = 0; i < n; i++) {
            arrCounterA[i] = (i == 0 ? 0 : arrCounterA[i - 1]) + (subStr.charAt(i) == 'A' ? 1 : 0);
            arrCounterB[i] = (i == 0 ? 0 : arrCounterB[i - 1]) + (subStr.charAt(i) == 'B' ? 1 : 0);
        }

        boolean isA = false;
        int countOccurrences = (isA = subStr.charAt(k - 1) == 'A') ? arrCounterA[k - 1] : arrCounterB[k - 1];

        int result = isA ? findIndex(arrCounterB, countOccurrences) : findIndex(arrCounterA, countOccurrences);

        return result >= 0 ? result + 1 : result;
    }

    public void processResultMatchDetermination() {
        try (ReadableFile readableFile = new TextFileReader(FILE_NAME);
             WritableFile writableFile = new TextFileWriter(new FileWriter("output.txt"))) {
            String[] symbols = readableFile.getSplitLine();
            int n = Integer.parseInt(symbols[0]);
            int q = Integer.parseInt(symbols[1]);

            String str = readableFile.readLine();

            if (!isValidStringLength(str, n)) throw new IllegalArgumentException("String length must be equals!");
            if (!isStringHaveOnlyAB(str)) throw new IllegalArgumentException("String must have only characters A or B");

            // Processing queries (q)
            for (int i = 0; i < q; i++) {
                String[] query = readableFile.getSplitLine();
                int l = Integer.parseInt(query[0]);
                int r = Integer.parseInt(query[1]);
                int k = Integer.parseInt(query[2]);

                if (!isValidIndexDataSubstring(l, r)) throw new IllegalArgumentException("Invalid index of start and end of substring");
                if (!isValidSearchingSymbol(l, r, k)) throw new IllegalArgumentException("Invalid index of the searched symbol");

                int resFindingMatch = processQuery(l, r, k, str);
                writableFile.writeLine(String.valueOf(resFindingMatch));
            }

        } catch (FileNotFoundException e) {
            throw new FileProcessingException("File not found", e);
        } catch (Exception e) {
            throw new FileProcessingException("Error processing file", e);
        }
    }
}
