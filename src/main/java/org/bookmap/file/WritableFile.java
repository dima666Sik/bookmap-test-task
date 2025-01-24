package org.bookmap.file;

import java.io.IOException;

public interface WritableFile extends AutoCloseable {
    void writeLine(String value) throws IOException;
}
