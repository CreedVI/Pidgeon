package pidgeon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static pidgeon.Pidgeon.*;

class spanish extends JFrame implements KeyListener {
    
    JButton B1;
    JButton B2;
    JTextField T1;
    JLabel L1;
    JTextArea displayArea;
    int r; //row counter
    boolean match=false;
    
    Font fontt;
    Font fonttt;
    
    String pro[] = arrays.spanishPro;
    
    String list[][] = arrays.spanishList;
    
    public spanish(){
       
        fontt = font.deriveFont(16f);
        fonttt = font.deriveFont(12.49f);
        
        
        setTitle("Pidgeon for Spanish");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360,360);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new FlowLayout());
        B1=new JButton("Conjugate");
        B1.setFont(fonttt);
        T1=new JTextField("Conjugate verb",10);
        T1.setFont(fontt);
        L1=new JLabel("");
        L1.setFont(fonttt);
        displayArea=new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(340,245));
        initUI();
        add(T1);
        add(B1);
        add(L1);
        add(scrollPane);
        PBactionListener handler=new PBactionListener();
        B1.addActionListener(handler);
        T1.addKeyListener((KeyListener) this);
        T1.requestFocus();
        T1.selectAll();
    }
    
    @Override
    public void keyReleased(KeyEvent e){
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==10){
            B1.doClick();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e){
    }
    
    private class PBactionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            displayArea.setText(null);
            String input = T1.getText().toLowerCase();
            if (input.startsWith("to ")) {
                input = input.substring(3);
            }
            for(String[] aSpanishList : list){
                if(input.equalsIgnoreCase(aSpanishList[1])||input.equalsIgnoreCase(aSpanishList[2])){
                  displayArea.append(aSpanishList[0]+" "+aSpanishList[1]+" -- "+aSpanishList[2]+" -- "+aSpanishList[3]+"\n\n"+
                          pro[0]+"\t\t"+aSpanishList[4]+"\n"+
                          pro[1]+"\t\t"+aSpanishList[5]+"\n"+
                          pro[2]+"\t\t"+aSpanishList[6]+"\n"+
                          pro[3]+"\t\t"+aSpanishList[6]+"\n"+
                          pro[4]+"\t"+aSpanishList[7]+"\n"+
                          pro[5]+"\t\t"+aSpanishList[8]+"\n"+
                          pro[6]+"\t\t"+aSpanishList[8]+"\n\n");
                    match=true;
                }
            }
            if(!match){
                switch (T1.getText().toLowerCase()) {
                    case "verbs":
                    case "verb":
                        displayArea.append("Conjugation chart\n\n"
                                + "Yo\t\t[stem]+e\n"
                                + "Tu\t\t[stem]+st\n"
                                + "El\t\t[stem]+t\n"
                                + "Ella\t\t[stem]+t\n"
                                + "Nosotros\t[stem]+t\n"
                                + "Ellos\t\t[stem]+t\n");
                        match=true;
                        break;
                    case "pronouns":
                    case "pronoun":
                        displayArea.append("Regular conjugation chart\n\n"
                                + "Yo\t\tI\n"
                                + "Tu\t\tYou\n"
                                + "El\t\tHim\n"
                                + "Ella\t\tHer\n"
                                + "Nosotros\tWe\n"
                        + "Ellos\t\tThey\n");
                        match = true;
                        break; 
                }
            }
            if(!match) {
                L1.setText("Sorry, I don't know that word.");   
            }
            
            else if(match){
                L1.setText(null);
            }
        match=false;
        T1.requestFocus();
        T1.selectAll();
        }
    }
    
    private void initUI() {
        
        JMenuBar menu = new JMenuBar();
        
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        JMenu about = new JMenu("About");
        about.setMnemonic(KeyEvent.VK_A);
        
        JMenu sel = new JMenu("Language select");
        sel.setMnemonic(KeyEvent.VK_S);
        sel.setToolTipText("Select new language.");
        
        JMenuItem bout = new JMenuItem("Info");
        bout.setMnemonic(KeyEvent.VK_W);
        bout.setToolTipText("About the programme.");
        bout.addActionListener((ActionEvent event) -> {
            about g = new about();
        });
        
        JMenuItem wd = new JMenuItem("Word List");
        wd.setMnemonic(KeyEvent.VK_L);
        wd.setToolTipText("Open the list of known words.");
        wd.addActionListener((ActionEvent event) -> {
            spanishWords f = new spanishWords();
        });
        
        JMenuItem ger = new JMenuItem("German");
        ger.setMnemonic(KeyEvent.VK_G);
        ger.setToolTipText("Switch To German.");
        ger.addActionListener((ActionEvent event) -> {
            pidgy g = new pidgy();
            dispose();
        });
        
        JMenuItem dut = new JMenuItem("Dutch");
        dut.setMnemonic(KeyEvent.VK_D);
        dut.setToolTipText("Switch To Dutch.");
        dut.addActionListener((ActionEvent event) -> {
            Dutch d = new Dutch();
            dispose();
        });
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Exit the application.");
        exit.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        file.setFont(fonttt);
        about.setFont(fonttt);
        sel.setFont(fonttt);
        bout.setFont(fonttt);
        wd.setFont(fonttt);
        ger.setFont(fonttt);
        exit.setFont(fonttt);
        
        about.add(wd);
        about.add(bout);
        
        sel.add(dut);
        sel.add(ger);
        
        file.add(sel);
        file.add(exit);
        
        menu.add(file);
        menu.add(about);
        
        setJMenuBar(menu);
    }
}