package pidgeon;


import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static pidgeon.Pidgeon.*;

public class lithWords extends JFrame {
    
    JScrollPane s;
    JTextArea T;
    
    
    public lithWords(){
        
        Font fonttt = font.deriveFont(12.49f);
        
        String lith[][] = arrays.lithuanianList;
        
        setTitle("Lithuanian Word List");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(280,310);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        T = new JTextArea();
        s = new JScrollPane(T);
        s.setSize(275,310);
        T.setEditable(false);
        T.setLineWrap(false);
        T.setFont(fonttt);
        
        for (String[] aLith : lith) {
            T.append(aLith[0]+" "+aLith[1]+"\t\t"+aLith[2]+"\n");
        }
        
        add(s);
    }
}
