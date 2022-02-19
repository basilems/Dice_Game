import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Die {
    private ImageIcon [] DieSide; // Table used to display the dice value
    private BufferedImage Die1,Die2,Die3,Die4,Die5,Die6; // Image of each side of the die

    /**Constructor of the Die
     *
     */
    public Die(){
        loadDefault();//Loading the default theme
    }

    /**The rolled method is created to display the image corresponding to the same value given as a parameter
     *
     * @param randomValue : the result of the dice roll
     * @return Die side corresponding the randomValue
     */
    public ImageIcon rolled(int randomValue){
        return DieSide[randomValue];
    }

    /**The loadDefault method is created to load the default theme of a die.
     *
     */
    public void loadDefault(){
        // Setting each die image to null to give previous values to the garbage collector
        Die1=null;Die2=null;Die3=null;Die4=null;Die5=null;Die6=null;
        // We must use a try catch method because we are reading files
        try {
            Die1 = ImageIO.read(new File("images/Die1.png")); //Die side images must be one the src folder
            Die2 = ImageIO.read(new File("images/Die2.png"));
            Die3 = ImageIO.read(new File("images/Die3.png"));
            Die4 = ImageIO.read(new File("images/Die4.png"));
            Die5 = ImageIO.read(new File("images/Die5.png"));
            Die6 = ImageIO.read(new File("images/Die6.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        // Giving the Die value to their corresponding value in the DieSide index as in ImageIcon type
        DieSide = new ImageIcon[]{new ImageIcon(Die1), new ImageIcon(Die2),new ImageIcon(Die3),
                new ImageIcon(Die4), new ImageIcon(Die5), new ImageIcon(Die6)};
    }

    /**The onlineLoadDefault method is created to load the default theme of a die using images online.
     *
     */
    public void onlineLoadDefault(){
        // Setting each die image to null to give previous values to the garbage collector
        Die1=null;Die2=null;Die3=null;Die4=null;Die5=null;Die6=null;
        // We must use a try catch method because we are reading files
        try {
            Die1 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Die_face_1b.svg/240px-Die_face_1b.svg.png"));
            Die2 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Die_face_2b.svg/240px-Die_face_2b.svg.png"));
            Die3 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Die_face_3b.svg/240px-Die_face_3b.svg.png"));
            Die4 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Die_face_4b.svg/240px-Die_face_4b.svg.png"));
            Die5 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Die_face_5b.svg/240px-Die_face_5b.svg.png"));
            Die6 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Die_face_6b.svg/240px-Die_face_6b.svg.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        // Giving the Die value to their corresponding value in the DieSide index as in ImageIcon type
        DieSide = new ImageIcon[]{new ImageIcon(Die1), new ImageIcon(Die2),new ImageIcon(Die3),
                new ImageIcon(Die4), new ImageIcon(Die5), new ImageIcon(Die6)};
    }

    /**The loadRed method is created to load the Red theme of a die.
     *
     */
    public void loadRed(){
        // Setting each die image to null to give previous values to the garbage collector
        Die1=null;Die2=null;Die3=null;Die4=null;Die5=null;Die6=null;
        // We must use a try catch method because we are reading files
        try {
            Die1 = ImageIO.read(new File("images/Die1r.png")); //Die side images must be one the src folder
            Die2 = ImageIO.read(new File("images/Die2r.png"));
            Die3 = ImageIO.read(new File("images/Die3r.png"));
            Die4 = ImageIO.read(new File("images/Die4r.png"));
            Die5 = ImageIO.read(new File("images/Die5r.png"));
            Die6 = ImageIO.read(new File("images/Die6r.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        // Giving the Die value to their corresponding value in the DieSide index as in ImageIcon type
        DieSide = new ImageIcon[]{new ImageIcon(Die1), new ImageIcon(Die2),new ImageIcon(Die3),
                new ImageIcon(Die4), new ImageIcon(Die5), new ImageIcon(Die6)};
    }

    /**The onlineLoadRed method is created to load the Red theme of a die using images online.
     *
     */
    public void onlineLoadRed(){
        // Setting each die image to null to give previous values to the garbage collector
        Die1=null;Die2=null;Die3=null;Die4=null;Die5=null;Die6=null;
        // We must use a try catch method because we are reading files
        try {
            Die1 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Dice-1.svg/240px-Dice-1.svg.png")); //Die side images must be one the src folder
            Die2 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Dice-2.svg/240px-Dice-2.svg.png"));
            Die3 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Dice-3.svg/240px-Dice-3.svg.png"));
            Die4 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Dice-4.svg/240px-Dice-4.svg.png"));
            Die5 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Dice-5.svg/240px-Dice-5.svg.png"));
            Die6 = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Dice-6.svg/240px-Dice-6.svg.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        // Giving the Die value to their corresponding value in the DieSide index as in ImageIcon type
        DieSide = new ImageIcon[]{new ImageIcon(Die1), new ImageIcon(Die2),new ImageIcon(Die3),
                new ImageIcon(Die4), new ImageIcon(Die5), new ImageIcon(Die6)};
    }

    /**The method resetImages unloads current images stored in Die1 to Die6
     *
     */
    private void resetImages(){
        Die1=null;Die2=null;Die3=null;Die4=null;Die5=null;Die6=null;
    }
}
