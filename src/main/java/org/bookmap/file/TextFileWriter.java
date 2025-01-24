package org.bookmap.file;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class TextFileWriter implements WritableFile{
    private final BufferedWriter bufferedWriter;
    public TextFileWriter(Writer writer) {
        this.bufferedWriter = new BufferedWriter(writer);
    }
    public void writeLine(String value) throws IOException {
        bufferedWriter.write(value);
        bufferedWriter.newLine();
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
    }
}
