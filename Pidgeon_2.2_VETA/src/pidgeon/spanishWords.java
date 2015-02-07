package pidgeon;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static pidgeon.Pidgeon.*;

public class spanishWords extends JFrame {
    
    JTextArea T;
    JScrollPane s;
    
    Font fonttt;

    public spanishWords(){
        
        fonttt = font.deriveFont(12.49f);
        
        String list[][] = arrays.spanishList;
        
        setTitle("Spanish Word List");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(275,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        T = new JTextArea();
        s = new JScrollPane(T);
        T.setEditable(false);
        T.setLineWrap(true);
        T.setFont(fonttt);
        for (String[] aSpanish : list) {
            switch (aSpanish[1]) {
                case "get in a vehicle":
                    T.append(aSpanish[0]+" get in a\n vehicle"+"\t\t"+aSpanish[2]+"\n");
                    break;
                case "congratulate":
                    T.append(aSpanish[0]+" "+aSpanish[1]+"\t"+aSpanish[2]+"\n");
                    break;
                case "put makeup on":
                    T.append(aSpanish[0]+" "+aSpanish[1]+"\t"+aSpanish[2]+"\n");
                    break;
                default:
                    T.append(aSpanish[0]+" "+aSpanish[1]+"\t\t"+aSpanish[2]+"\n");
                    break;
            }
        }
        add(s);
    }
}
