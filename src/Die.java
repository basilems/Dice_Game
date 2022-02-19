import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
//            Die1 = ImageIO.read(new File("src/Die1.png")); //Die side images must be one the src folder
            Die1 = new ImageIcon(IMC.class.getResource("src/Die1.jpg"));
            Die2 = ImageIO.read(new File("src/Die2.png"));
            Die3 = ImageIO.read(new File("src/Die3.png"));
            Die4 = ImageIO.read(new File("src/Die4.png"));
            Die5 = ImageIO.read(new File("src/Die5.png"));
            Die6 = ImageIO.read(new File("src/Die6.png"));
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
            Die1 = ImageIO.read(new File("src/Die1r.png")); //Die side images must be one the src folder
            Die2 = ImageIO.read(new File("src/Die2r.png"));
            Die3 = ImageIO.read(new File("src/Die3r.png"));
            Die4 = ImageIO.read(new File("src/Die4r.png"));
            Die5 = ImageIO.read(new File("src/Die5r.png"));
            Die6 = ImageIO.read(new File("src/Die6r.png"));
        } catch (IOException e) { // In case there is an error reading the files we give an IOException
            e.printStackTrace();
        }
        // Giving the Die value to their corresponding value in the DieSide index as in ImageIcon type
        DieSide = new ImageIcon[]{new ImageIcon(Die1), new ImageIcon(Die2),new ImageIcon(Die3),
                new ImageIcon(Die4), new ImageIcon(Die5), new ImageIcon(Die6)};
    }
}
