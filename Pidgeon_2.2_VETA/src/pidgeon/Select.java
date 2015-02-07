package pidgeon;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import static pidgeon.Pidgeon.*;

public class Select extends JFrame {
    
    JList lang;
    
    JPanel pan;
    
    JLabel txt;
    JLabel y;
    
    JButton ger;
    JButton span;
    JButton dut;
    JButton lit;
    
    Dimension dim = new Dimension(100,22);
    
    static Font fontt;
    static Font fonttt;
    
    public Select(){
        super("Pidgeon");
        
        AL h = new AL();
        
        fontt = font.deriveFont(16f);
        fonttt = font.deriveFont(12.49f);
        
        dut = new JButton("Dutch");
        dut.setPreferredSize(dim);
        dut.setFont(fonttt);
        dut.addActionListener(h);
        
        ger = new JButton("German");
        ger.setPreferredSize(dim);
        ger.setFont(fonttt);
        ger.addActionListener(h);
        
        lit = new JButton("Lithuanian");
        lit.setPreferredSize(dim);
        lit.setFont(fonttt);
        lit.addActionListener(h);
        
        span = new JButton("Spanish");
        span.setPreferredSize(dim);
        span.setFont(fonttt);
        span.addActionListener(h);
        
        txt = new JLabel();
        txt.setFont(fontt);
        txt.setText("Select a language:");
        setLayout(new FlowLayout());
        
        lang = new JList();
        
        y = new JLabel();
        y.setFont(fontt);
        y.setText("More coming soon!");
        
        add(txt);
        add(dut);
        add(ger);
        //add(lit);
        add(span); 
        add(y);
    } 
    
    private class AL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource().equals(ger)){
                pidgy j = new pidgy();
                dispose();
            }
            else if(event.getSource().equals(dut)){
                Dutch p = new Dutch();
                dispose();
            }
//            else if(event.getSource().equals(lit)){
//                Lithuanian l = new Lithuanian();
//                dispose();
//            }
            else if(event.getSource().equals(span)){
                spanish h = new spanish();
                dispose();
            }
        }
    }
}