package org.bookmap.file;

import java.io.IOException;

public interface ReadableFile extends AutoCloseable {
    String readLine() throws IOException;
    String[] getSplitLine() throws IOException;
}
