import javax.swing.*; // We import swing to get the GUI features of Java
import java.awt.*; // AWT is imported to set position of an object

public class PlayersPanel extends JPanel{
    private JPanel player1Panel;
    private JPanel player2Panel;
    private JLabel player1;
    private JLabel Image1;
    private JLabel p1Wins;
    private int counter1=0;
    private JLabel player2;
    private JLabel Image2;
    private JLabel p2Wins;
    private int counter2=0;
    private Die die;

    /**This is the constructor of the panels, it is tied to the same die that
     * rolls the random numbers to display the same value as an image for each
     * player.
     * @param die : die rolled in the main class
     */
    public PlayersPanel(Die die){
        setLayout(new GridLayout(1,2)); /*Setting layout as a grid
        to display both player on each side of the window.*/
        this.die = die;

        // Creating panel for each player
        player1Panel = new JPanel();
        player2Panel = new JPanel();

        // Creating player info panels with player name, dice image area and score counter
        player1 = new JLabel("Player 1"); // Setting default names for players
        player2 = new JLabel("Player 2");
        Image1 = new JLabel(); // Preparing space for dice images
        Image2 = new JLabel();
        p1Wins = new JLabel(counter1+ ""); // Setting scores for players
        p2Wins = new JLabel(counter2+ "");

        // Populating main player panels with their respective infos
        player1Panel.setLayout(new GridLayout(3,1)); // There are 3 informations to display
        player1Panel.add(player1,BorderLayout.NORTH);  // Appending block to the player panel
        player1.setHorizontalAlignment(JLabel.CENTER); // Centering each block on the player panel
        player1Panel.add(Image1,BorderLayout.SOUTH);
        Image1.setHorizontalAlignment(JLabel.CENTER);
        player1Panel.add(p1Wins,BorderLayout.SOUTH);
        p1Wins.setHorizontalAlignment(JLabel.CENTER);
        p1Wins.setFont(new Font("Arial",Font.PLAIN,26)); //Changing font of scores for better visibility

        player2Panel.setLayout(new GridLayout(3,1));
        player2Panel.add(player2,BorderLayout.NORTH);
        player2.setHorizontalAlignment(JLabel.CENTER);
        player2Panel.add(Image2,BorderLayout.SOUTH);
        Image2.setHorizontalAlignment(JLabel.CENTER);
        player2Panel.add(p2Wins,BorderLayout.SOUTH);
        p2Wins.setHorizontalAlignment(JLabel.CENTER);
        p2Wins.setFont(new Font("Arial",Font.PLAIN,26));

        add(player1Panel); //Adding the 2 player panels to the window
        add(player2Panel);

        Image1.setIcon(die.rolled(0)); // Initializing player die value as 1
        Image2.setIcon(die.rolled(0)); // for display reasons
    }

    /**
     * The pRoll method uses the 2 values to display the image of the dice
     * corresponding to each value for each player.
     * @param value1 Die value of player 1
     * @param value2 Die value of player 2
     */
    public void pRoll(int value1, int value2){
            Image1.setIcon(die.rolled(value1));
            Image2.setIcon(die.rolled(value2));
            if (value1>value2){
                counter1++;
                p1Wins.setText(player1.getText()+" Wins! " +counter1);
                p2Wins.setText(counter2+"");
            }
            else if (value1<value2){
                counter2++;
                p2Wins.setText(player2.getText()+" Wins! " +counter2);
                p1Wins.setText(counter1+"");
            }
            else{
                p2Wins.setText("It's a draw! " +counter2);
                p1Wins.setText("It's a draw! " +counter1);
                //JOptionPane.showMessageDialog(null,"It's a tie for this round!");
            }
    }

    /**Getter for player1's name
     * @return name of the first player
     */
    public String getPlayer1(){
        return player1.getText();
    }

    /**Getter for player2's name
     * @return name of the second player
     */
    public String getPlayer2(){
        return player2.getText();
    }

    /**Setter for player1's name
     * @param name : New name for the first player
     */
    public void setPlayer1(String name){
        if(name!=null){
            player1.setText(name);
        }
    }

    /**Setter for player2's name
     * @param name : New name for the second player
     */
    public void setPlayer2(String name){
        if(name!=null){
            player2.setText(name);
        }
    }

    /**This method is used to reset scores for the game,
     * It only resets the counter and displays the new scores.
     */
    public void resetScores(){
        counter1=0;
        counter2=0;
        p1Wins.setText(counter1+"");
        p2Wins.setText(counter2+"");
    }
}
