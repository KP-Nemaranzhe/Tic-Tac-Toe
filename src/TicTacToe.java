// first we have to import the essential tools we will need for development
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

// Create the game class
public class TicTacToe{
    //define the viriable for the size of the game window
    int boardWidth = 600;
    int boardHeight = 650; //50px will be for the text panel on top
    
    //Create the game window
    JFrame frame = new JFrame();

    //Add Panel for the text
    JLabel textLabel = new JLabel(); //text
    JPanel textPanel = new JPanel();

    //constructor
    public TicTacToe() {
        //Game Window

        frame.setVisible(true); //make frame visible
        frame.setSize(boardWidth,boardHeight); // this will set the size of our window
        frame.setLocationRelativeTo(null); //this will open our window at the center of the screen
        frame.setResizable(false); //The user should not be able to resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //For user to close the game
        frame.setLayout(new BorderLayout());

        //TEXT LABEL
        textLabel.setBackground(Color.darkGray); //this set the background of the label
        textLabel.setForeground(Color.white); //change the text color to white
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER); //This will center the text instead of starting from left
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

    }
    
}