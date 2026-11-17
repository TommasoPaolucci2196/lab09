package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first java graphical interface");

    private SimpleGUI(final Controller ctrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton button = new JButton("Save");
        panel.setLayout(new BorderLayout());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    ctrl.inputStringFile(textArea.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(button,BorderLayout.SOUTH);
        panel.add(textArea,BorderLayout.CENTER);
        frame.setContentPane(panel);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw/2,sh/2);
        frame.setLocationByPlatform(true);
    }


    /**
     * With the Main, launches the application
     */
    private void display() {
        frame.setVisible(true);
    }

    public static void main() {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
