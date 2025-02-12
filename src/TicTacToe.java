// first we have to import the essential tools we will need for development
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Create the game class
public class TicTacToe{
    //define the viriable for the size of the game window
    int boardWidth = 600;
    int boardHeight = 650; //50px will be for the text panel on top
    
    //Create the game window
    JFrame frame = new JFrame("Tic-Tac-Toe"); //this create the frame and name of the frame object

    //Add Panel for the text
    JLabel textLabel = new JLabel(); //creates the label object
    JPanel textPanel = new JPanel(); //creates the panel object
    JPanel boardPanel = new JPanel(); //create the panel that we'll use as the board for the game
    
    //Create a button to play the game
    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX; //used to track the user who is playing
    
    boolean gameOver = false;
    int turns = 0;
    
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

        //Panel

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel); //adds the text to the panel
        frame.add(textPanel,BorderLayout.NORTH); //adds the panel to the frame

        //BoardPanel
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.BLACK);
        frame.add(boardPanel);

        //Button
        for(int r=0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                //add properties
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                //tile.setText(currentPlayer);

                tile.addActionListener(new ActionListener() {
                    //create function
                    public void actionPerformed(ActionEvent e){
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == ""){
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();

                            if(!gameOver){
                               currentPlayer = currentPlayer == playerX ? playerO : playerX;
                               textLabel.setText(currentPlayer + "'s turn.");
                            }

                        }


                    }
                });

            }
        }
        
    }

    //Method definition

    void checkWinner(){
        //horizontal
        for(int r = 0; r < 3; r++){
            if(board[r][0].getText() == "") continue;

            if(board[r][0].getText() == board[r][1].getText() && 
                board[r][1].getText() == board[r][2].getText()) {
                for (int i = 0; i < 3; i++){
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        //Vertical
        for (int c = 0;c < 3; c++){
            if (board[0][c].getText() == "") continue;

            if (board[0][c].getText() == board[1][c].getText() &&
                board[1][c].getText() == board[2][c].getText()) {
                    for (int i = 0; i < 3; i++){
                        setWinner(board[i][c]);
                    }
                    gameOver = true;
                    return;
                }   
        }

        //Diagonally

        if(board[0][0].getText() == board[1][1].getText() &&
           board[1][1].getText() == board[2][2].getText() &&
           board[0][0].getText() != ""){
                for(int i = 0; i < 3; i++){
                    setWinner(board[i][i]);
                }
                gameOver = true;
                return;
           }
        
        //Anti-diagonally
        if(board[0][2].getText() == board[1][1].getText() &&
        board[1][1].getText() == board[2][0].getText() &&
        board[0][2].getText() != ""){
             setWinner(board[0][2]);
             setWinner(board[1][1]);
             setWinner(board[2][0]);
             gameOver = true;
             return;
        }

        if(turns == 9){
            for(int r= 0; r < 3 ; r++){
                //change all the color of the tiles
                for(int c = 0; c < 3; c++){
                    setTie(board[r][c]);
                }
                gameOver = true;
                return;
            }
        }
    }

    void setWinner(JButton tile){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the Winner!");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.ORANGE);
        tile.setBackground(Color.gray);
        textLabel.setText("Its a Tie!"); 
    }
    
    
}

