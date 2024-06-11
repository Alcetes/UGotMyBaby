package app.components.custom;
import javax.swing.*;
import java.awt.*;

public class CustomTitleBarColor {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set custom title bar color
        frame.getContentPane().setBackground(Color.BLUE);

        // Remove the default title bar
        frame.setUndecorated(true);

        // Set the frame visible
        frame.setVisible(true);
    }
}