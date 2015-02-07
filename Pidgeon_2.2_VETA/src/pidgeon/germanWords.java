package pidgeon;


import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static pidgeon.Pidgeon.*;

public class germanWords extends JFrame {
    
    JScrollPane s;
    JTextArea T;
    
    
    public germanWords(){
        
        Font fonttt = font.deriveFont(12.49f);
        
        String german[][] = arrays.germanList;
        
        setTitle("German Word List");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(280,310);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        T = new JTextArea();
        s = new JScrollPane(T);
        s.setSize(275,310);
        s.getHorizontalScrollBarPolicy();
        T.setEditable(false);
        T.setLineWrap(false);
        T.setFont(fonttt);
        for (String[] aGerman : german) {
            if(aGerman[1].equals("have an opinion")){
                T.append(aGerman[0]+" have an\nopinion\t\t"+aGerman[2]+"\n");
            }
            else{
                T.append(aGerman[0]+" "+aGerman[1]+"\t\t"+aGerman[2]+"\n");
            }
        }
        add(s);
    }
}
