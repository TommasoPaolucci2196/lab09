package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.text";
    private File file = new File(HOME + File.separator + DEFAULT_FILE);

    /**
     * Returns the current file.
     * 
     * @return the current file
     */
    public File getCurrentFile() {
        return file;
    }

    /**
     * Returns the current file path.
     * 
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return file.getPath();
    }

    /**
     * Saves text on the file.
     * 
     * @param text
     * @throws IOException
     */
    public void inputStringFile(final String text) throws IOException {
        try (PrintStream write = new PrintStream(file, StandardCharsets.UTF_8)){
            write.println(text);
        }
    }

    /**
     * Sets a new destination file.
     *
     * @param file
     *
     */
    public void setDestination(final File newfile) {
        final File parent = newfile.getParentFile();
        if (parent.exists()) {
            file = newfile;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }

    /**
     * Sets a new destination file.
     *
     * @param file
     *
     */
    public void setDestination(final String newfile) {
        setDestination(new File(newfile));
    }
}
