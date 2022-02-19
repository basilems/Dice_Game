import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Die {
    private ImageIcon [] dieSide; // Table used to display the dice value
    private BufferedImage die1, die2, die3, die4, die5, die6; // Image of each side of the die

    /**Constructor of the Die
     *
     */
    public Die(){
        onlineLoadDefault();//Loading the default theme
    }

    /**The rolled method is created to display the image corresponding to the same value given as a parameter
     *
     * @param randomValue : the result of the dice roll
     * @return Die side corresponding the randomValue
     */
    public ImageIcon rolled(int randomValue){
        return dieSide[randomValue];
    }

    /**The loadDefault method is created to load the default theme of a die.
     *
     */
    public void loadDefault(){
        resetImages();
        // We must use a try catch method because we are reading files
        try {
            die1 = ImageIO.read(new File("images/Die1.png")); //Die side images must be one the src folder
            die2 = ImageIO.read(new File("images/Die2.png"));
            die3 = ImageIO.read(new File("images/Die3.png"));
            die4 = ImageIO.read(new File("images/Die4.png"));
            die5 = ImageIO.read(new File("images/Die5.png"));
            die6 = ImageIO.read(new File("images/Die6.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        resetDieSide();
    }

    /**The onlineLoadDefault method is created to load the default theme of a die using images online.
     *
     */
    public void onlineLoadDefault(){
        resetImages();
        // We must use a try catch method because we are reading files
        try {
            die1 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Die_face_1b.svg/240px-Die_face_1b.svg.png"));
            die2 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Die_face_2b.svg/240px-Die_face_2b.svg.png"));
            die3 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Die_face_3b.svg/240px-Die_face_3b.svg.png"));
            die4 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Die_face_4b.svg/240px-Die_face_4b.svg.png"));
            die5 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Die_face_5b.svg/240px-Die_face_5b.svg.png"));
            die6 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Die_face_6b.svg/240px-Die_face_6b.svg.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        resetDieSide();
    }

    /**The loadRed method is created to load the Red theme of a die.
     *
     */
    public void loadRed(){
        resetImages();
        // We must use a try catch method because we are reading files
        try {
            die1 = ImageIO.read(new File("images/Die1r.png")); //Die side images must be one the src folder
            die2 = ImageIO.read(new File("images/Die2r.png"));
            die3 = ImageIO.read(new File("images/Die3r.png"));
            die4 = ImageIO.read(new File("images/Die4r.png"));
            die5 = ImageIO.read(new File("images/Die5r.png"));
            die6 = ImageIO.read(new File("images/Die6r.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        resetDieSide();
    }

    /**The onlineLoadRed method is created to load the Red theme of a die using images online.
     *
     */
    public void onlineLoadRed(){
        resetImages();
        // We must use a try catch method because we are reading files
        try {
            die1 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Dice-1.svg/240px-Dice-1.svg.png")); //Die side images must be one the src folder
            die2 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Dice-2.svg/240px-Dice-2.svg.png"));
            die3 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Dice-3.svg/240px-Dice-3.svg.png"));
            die4 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Dice-4.svg/240px-Dice-4.svg.png"));
            die5 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Dice-5.svg/240px-Dice-5.svg.png"));
            die6 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Dice-6.svg/240px-Dice-6.svg.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        resetDieSide();
    }

    /**The resetImages method unloads current images stored in Die1 to Die6
     *
     */
    private void resetImages(){
        // Setting each die image to null to give previous values to the garbage collector
        die1 =null;
        die2 =null;
        die3 =null;
        die4 =null;
        die5 =null;
        die6 =null;
    }

    /**The resetDieSide method is used to change the theme of the game
     *
     */
    private void resetDieSide(){
        // Giving the previous DieSide to the garbage collector
        dieSide = null;
        // Giving the Die value to their corresponding value in the DieSide index as in ImageIcon type
        dieSide = new ImageIcon[]{new ImageIcon(die1), new ImageIcon(die2),new ImageIcon(die3),
                new ImageIcon(die4), new ImageIcon(die5), new ImageIcon(die6)};
    }
}
