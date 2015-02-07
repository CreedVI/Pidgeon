package pidgeon;


import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static pidgeon.Pidgeon.*;

public class dutchWords extends JFrame {
    
    JScrollPane s;
    JTextArea T;
    
    
    public dutchWords(){
        
        Font fonttt = font.deriveFont(12.49f);
        
        String dutch[][] = arrays.Dutch;
        String irr[][] = arrays.DutchIrr;
        
        setTitle("Dutch Word List");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(310,310);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        T = new JTextArea();
        s = new JScrollPane(T);
        s.setSize(275,310);
        T.setEditable(false);
        T.setLineWrap(false);
        T.setFont(fonttt);
        for ( String[] aIrr : irr){
            switch(aIrr[0]){
                case "":
                    T.append(aIrr[1]+"\t\t"+aIrr[2]+"\n");
                    break;
                    
                case "To":
                    T.append(aIrr[0]+" "+aIrr[1]+"\t\t"+aIrr[2]+"\n");
                    break;
            }
        }
        for (String[] aDutch : dutch) {
            T.append(aDutch[0]+" "+aDutch[1]+"\t\t"+aDutch[2]+"\n");
        }
        add(s);
    }
}
