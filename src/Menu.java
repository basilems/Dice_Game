import javax.swing.*; // We import swing to get the GUI features of Java
import java.awt.event.ActionEvent; // ActionEvent is the class to trigger an event
import java.awt.event.ActionListener; // ActionListener is the class to create an event

public class Menu extends JMenuBar {
    private JMenu help;
    private JMenu game;
    private JMenu themes;
    private JMenuItem def,red;
    private JMenuItem reset, changeName1, changeName2, rules,features,about;
    private PlayersPanel gameInfo;
    private Die die;

    /**Constructor for the Menu class
     * @param panel : Panels containing the players' infos
     * @param die : Same die as the main method
     */
    public Menu(PlayersPanel panel,Die die){
        game = new JMenu("Game"); // Creates each tab on the menu
        help = new JMenu("Help");
        themes = new JMenu("Themes");
        gameInfo = panel; // Linking the player panels to get the players' info
        this.die = die;

        reset = new JMenuItem("Reset Game"); // Creating the reset menu item
        reset.addActionListener(new ResetListener()); // Associating the reset button to an ActionListener
        changeName1 = new JMenuItem("Change Player1 name");
        changeName1.addActionListener(new Player1NameListener());
        changeName2 = new JMenuItem("Change Player2 name");
        changeName2.addActionListener(new Player2NameListener());

        def = new JMenuItem("Default theme");
        def.addActionListener(new DefaultThemeListener());
        red = new JMenuItem("Red theme");
        red.addActionListener(new RedThemeListener());
        themes.add(def); // Adding def button to the themes menu tab
        themes.add(red);

        features = new JMenuItem("More info features");
        rules = new JMenuItem("Show rules");
        about = new JMenuItem("About");

        rules.addActionListener(new HelpListener());
        features.addActionListener(new FeaturesListener());
        game.add(reset);
        game.add(changeName1);
        game.add(changeName2);
        help.add(features);
        help.add(rules);
        add(game); // Adding the menu tabs to the window
        add(themes);
        add(help);
    }

    //Creating an event for the rules button
    private class HelpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, """
                    Welcome to our dice game!
                    The aim of the game is simple : get a better score
                    than the other player. If you both roll the same\s
                    number, it's a draw and no one wins the round.
                    Enjoy the game!
                    
                    To play the game just click on \"Roll the dice\"""");
        }
    }

    //Creating an event for the more info button
    private class FeaturesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, """
                    Here is a comprehensive guide on the features of the game:
                    Game -> Reset Game: Resets the score of both player so you can play again
                         -> Change Player X Name : Change your name by putting in a new nickname.
                                                    Press Enter to confirm or Cancel to go back.
                    
                    Themes : You can also change the theme of the dice by choosing between 2 themes.
                         -> Default : Just the default dice with black dots
                         -> Red : Dice with red dots                                
                    
                    Help : You are already here ;)
                    """);
        }
    }

    //Creating an event for the Reset button
    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameInfo.resetScores(); // Resetting scores
        }
    }

    //Creating an event for the Player1 Name Change button
    private class Player1NameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // We ask the user to input a new name for player 1
            String p1Name = JOptionPane.showInputDialog(gameInfo.getPlayer1()+", please put what name you want to have");
            gameInfo.setPlayer1(p1Name); // Setting new name as the active name
        }
    }

    //Creating an event for the Player2 Name Change button
    private class Player2NameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // We ask the user to input a new name for player 2
            String p2Name = JOptionPane.showInputDialog(gameInfo.getPlayer2()+", please put what name you want to have");
            gameInfo.setPlayer2(p2Name); // Setting new name as the active name
        }
    }

    //Creating an event for the Default theme button
    private class DefaultThemeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            die.loadDefault(); // Loading theme into active dice images
            System.out.println("Default loaded"); // We notify of the successful change
        }
    }

    //Creating an event for the Red theme button
    private class RedThemeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            die.loadRed(); // Loading theme into active dice images
            System.out.println("Red loaded"); // We notify of the successful change
        }
    }
}
