package it.unibo.mvc;

import java.util.List;
/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**It sets the next string to print.
     * 
     * @param nextstring
     */
    void setNextStringPrint(String nextstring);

    /**It gets the next string to print.
     * 
     * @return string to print
     */
    String getNextStringPrint();

    /**It returns the history of the printed strings.
     * 
     * @return the history of the printed strings
     */
    List<String> getPrintedStringHistory();

    /**It prints the current string.
     * 
     * 
     */
    void PrintCurrentString();


}
