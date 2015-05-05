package pidgeon;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class Pidgeon {
     
    static BufferedImage myImg;
    final static String imagePath = "images/icon.png";
    final static String fontPath = "fonts/Raleway-Regular.ttf";
    
    static Font font;
    static Font fontt;
    static Font fonttt;
    
    static BufferedInputStream Raleway;
    
    public static void main(String[] args){
        
        //IMPOT FONT
        try {
            Raleway = new BufferedInputStream(new FileInputStream(fontPath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, Raleway);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //IMPORT ICON   
        try {
        Pidgeon.myImg = ImageIO.read(new FileInputStream(imagePath));
        } catch (IOException ex) {
            Logger.getLogger(Pidgeon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SynthLookAndFeel laf = new SynthLookAndFeel();

        //SET DESIGN
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }

        Select window=new Select();
        window.setBackground(Color.WHITE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(185,320);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setIconImage(myImg);
    } 
}

/*
programme coded by:
Calvin
Arin
Tristian
Michelle
*/