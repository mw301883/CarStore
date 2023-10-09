/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package michal.wieczorek.carstore;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Michał
 */
public class CarStore {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Swing App");
        JButton button = new JButton("Click me");

        button.addActionListener(e -> System.out.println("Button clicked!"));

        frame.getContentPane().add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
