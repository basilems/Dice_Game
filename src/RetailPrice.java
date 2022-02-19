import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetailPrice extends JFrame {
    private JPanel pricePanel;
    private JPanel buttonPanel;
    private JLabel wholesale;
    private JTextField wsPrice;
    private JLabel markup;
    private JTextField muPercentage;
    private JButton btn;


    /**This is the constructor of the window, we give it a title, size, and we
     * add all components to build the application.
     */
    public RetailPrice(){
        setTitle("Retail Price Generator");
        setSize(800,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildPanels();
        add(pricePanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);


//        pack();
        setVisible(true);
    }

    /**This is a method that build the panel for the window, it
     * also builds the texts and text fields.
     */
    public void buildPanels(){
        pricePanel = new JPanel();
        buttonPanel = new JPanel();

        //pricePanel
        wholesale = new JLabel("Wholesale Price: ");
        wsPrice = new JTextField(10);

        markup = new JLabel("Markup Percentage: ");
        muPercentage = new JTextField(10);

        pricePanel.add(wholesale);
        pricePanel.add(wsPrice);
        pricePanel.add(markup);
        pricePanel.add(muPercentage);

        //buttonPanel
        btn = new JButton("Generate");
        btn.addActionListener(new GenerateButtonListener());
        buttonPanel.add(btn,BorderLayout.CENTER);
    }

    //Creates an event for the button click to generate the retail price
    private class GenerateButtonListener implements ActionListener{
        private double total;
        @Override
        /*This is a method that calculates the retail price from the wholesale price and markup percentage.

         */
        public void actionPerformed(ActionEvent e) {
            int startPrice = Integer.parseInt(wsPrice.getText());
            double percentage = Double.parseDouble(muPercentage.getText());
            total = startPrice* (1 + percentage/100); //Retail price is wholesale price + wholesale*markup%
            JOptionPane.showMessageDialog(null,"Wholesale price is "+ wsPrice.getText() + "$\n" +
                    "Markup percentage is " + muPercentage.getText()+"%\n\n" +
                    "Retail price is " + total + "$");
        }
    }

    //This is how we launch the GUI
    public static void main(String [] args){
        new RetailPrice();
    }
}
