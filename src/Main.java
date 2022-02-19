import javax.swing.*; // We import swing to get the GUI features of Java
import java.awt.*; // AWT is imported to set position of an object
import java.awt.event.ActionEvent; // ActionEvent is the class to trigger an event
import java.awt.event.ActionListener; // ActionListener is the class to create an event
import java.util.Random; // Random is imported to create the

public class Main extends JFrame{
    private PlayersPanel players;
    private Menu menuOptions;
    private JButton btn;
    private Die die;
    private Random randomRoll;

    /**Constructor for the main GUI app that will create the window and initialize all its features/aspects
     *
     */
    public Main(){
        randomRoll = new Random(); // randomRoll will let us draw random numbers for the dice
        die = new Die(); // We initialize a die to roll
        Container cp = getContentPane();
        // cp is the current window pane in which we add all the other panels/buttons/menu tabs

        players = new PlayersPanel(die); // Initializing the players' panels
        menuOptions = new Menu(players,die); // Initializing the menu tabs
        cp.add(menuOptions,BorderLayout.NORTH); // Adding them the current window
        cp.add(players);

        btn = new JButton("Roll the dice"); //Creating the button to roll the dice
        btn.addActionListener(new TestButtonListener()); // Associating the button to an ActionListener
        cp.add(btn,BorderLayout.SOUTH); // Adding it to the bottom of the window

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the app to close the program on exit
        setTitle("2 Player Dice Game"); // Setting the title of the window

        pack(); // Creating a compact layout containing every panel
        setLocationRelativeTo(null); // Set the app to launch in the center of the screen
        setVisible(true); // Displaying the window
    }

    // Creating an event for the Test Button
    private class TestButtonListener implements ActionListener{
        private int playerRoll1;
        private int playerRoll2;
        @Override
        public void actionPerformed(ActionEvent e) {
            playerRoll1 = randomRoll.nextInt(6); // Rolling de die for player1
            playerRoll2 = randomRoll.nextInt(6); // Rolling de die for player2
            System.out.println(playerRoll1 + " - " + playerRoll2); // Displaying rolls on console
            players.pRoll(playerRoll1,playerRoll2); // Displaying rolls on the GUI
        }
    }

    public static void main(String [] args){
                new Main(); // Let the constructor do the job
    }
}

