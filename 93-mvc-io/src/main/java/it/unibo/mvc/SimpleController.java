package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {

    private final List<String> strings = new LinkedList<>();
    private String nextString;
    /**It sets the next string to print.
     * 
     * @param nextstring
     */
    @Override
    public void setNextStringPrint(String nextstring) {
        this.nextString = Objects.requireNonNull(nextstring, "This string cannot be null");
    }

    /**It gets the next string to print.
     * 
     * @return string to print
     */
    @Override
    public String getNextStringPrint() {
        return this.nextString;
    }

    /**It returns the history of the printed strings.
     * 
     * @return the history of the printed strings
     */
    @Override
    public List<String> getPrintedStringHistory() {
        return Collections.unmodifiableList(strings);
    }

    /**It prints the current string.
     * 
     * 
     */
    @Override
    public void PrintCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("String cannot be null");
        }
        strings.add(nextString);
        System.out.println(nextString);
    }

}
