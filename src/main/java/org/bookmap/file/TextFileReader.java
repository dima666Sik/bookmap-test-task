package org.bookmap.file;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class TextFileReader implements ReadableFile{
    private final BufferedReader bufferedReader;

    public TextFileReader(Reader reader) {
        this.bufferedReader = new BufferedReader(reader);
    }

    public TextFileReader(String filename) throws FileNotFoundException {
        this(new FileReader(filename));
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    public String[] getSplitLine() throws IOException {
        return readLine().split(" ");
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
