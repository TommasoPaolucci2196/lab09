package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My first java graphical interface");

    private SimpleGUIWithFileChooser(final Controller ctrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        final JPanel panel1 = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JTextField textField = new JTextField(ctrl.getCurrentFilePath());
        final JButton button = new JButton("Save");
        final JButton browse = new JButton("Browse...");
        panel.setLayout(new BorderLayout());
        panel1.setLayout(new BorderLayout());


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

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final JFileChooser fc = new JFileChooser("Choose where to save");
                fc.setSelectedFile(ctrl.getCurrentFile());
                final int result = fc.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        final File dest = fc.getSelectedFile();
                        ctrl.setDestination(dest);
                        textField.setText(dest.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame,result,"Meh",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(button,BorderLayout.SOUTH);
        panel.add(textArea,BorderLayout.CENTER);
        panel1.add(textField,BorderLayout.CENTER);
        panel1.add(browse,BorderLayout.LINE_END);
        panel.add(panel1,BorderLayout.NORTH);

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
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }
}
