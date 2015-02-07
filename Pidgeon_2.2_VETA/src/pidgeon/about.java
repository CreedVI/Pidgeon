package pidgeon;


import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static pidgeon.Pidgeon.*;


public class about extends JFrame {
    JTextArea T;
    JScrollPane s;
    
    static Font fontt;
    static Font fonttt;
    
    public about(){
        
        fontt = font.deriveFont(16f);
        fonttt = font.deriveFont(12.49f);
        
        setTitle("Pidgeon Information");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(305,305);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        T = new JTextArea();
        s = new JScrollPane(T);
        T.setEditable(false);
        T.setFont(fonttt);
        T.setText("Pidgeon Verb Conjugator v2.0 by the Pidgeon\nTeam\n"
                + "\n"
                + "This version of Pidgeon supports Dutch, German,\n and Spanish.\n\n"
                + "How to use:\n"
                + "Type the verb (English or German/Spanish) in\n "
                + "the text field and hit the \"enter\" key, or click the\n"
                + "\"Conjugate\" button.\n\n"
                + "To change the selected tense open the\"Tense\"\n"
                + "dropdown and select the desired option. Check \nthe text off to the"
                + "right of the menu to confirm the\n"
                + "desired change has been made.\n\n"
                + "To view the charts type \"verbs\" (sans quotes) for\n"
                + "the regular verb conjugation, and to view the list\n"
                + "of pronouns and their English counterparts type\n"
                + "\"pronouns\" (sans quotes).\n\n"
                + "Report any errors to cdayvi@gmail.com");
        add(T);
    }
}