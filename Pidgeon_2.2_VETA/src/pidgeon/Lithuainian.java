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

class Lithuanian extends JFrame implements KeyListener {
    
    JButton B1;
    JTextField T1;
    JLabel L1;
    JTextArea displayArea;
    int r;
    boolean match=false;
    
    Font fontt;
    Font fonttt;
    
    String pro[] = arrays.lithuanianPro;
    
    String list[][] = arrays.lithuanianList;

/*
    future word ref
*/
    
    public Lithuanian(){
       
        fontt = font.deriveFont(16f);
        fonttt = font.deriveFont(12.49f);
        
        setTitle("Pidgeon for Lithuanian");
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
        String input = T1.getText().toLowerCase();
        if(input.startsWith("to ")){
            input = input.substring(3);
        }
            displayArea.setText(null);
            for(r=0;r<list.length;r++){
                if(input.equals(list[r][1].toLowerCase())){
                    displayArea.append(list[r][0]+" "+list[r][1]+" -- "+list[r][2]+" -- "+list[r][3]+"\n\n"+
                            pro[0]+"\t\t"+list[r][4]+"\n"+
                            pro[1]+"\t\t"+list[r][5]+"\n"+
                            pro[2]+"\t\t"+list[r][6]+"\n"+
                            pro[3]+"\t\t"+list[r][6]+"\n"+
                            pro[4]+"\t\t"+list[r][6]+"\n"+
                            pro[5]+"\t\t"+list[r][6]+"\n"+
                            pro[6]+"\t\t"+list[r][7]+"\n"+
                            pro[7]+"\t\t"+list[r][8]+"\n");
                    match=true;
                }
                else if(input.equals(list[r][2].toLowerCase())){
                    displayArea.append(list[r][0]+" "+list[r][1]+" -- "+list[r][2]+" -- "+list[r][3]+"\n\n"+
                            pro[0]+"\t\t"+list[r][4]+"\n"+
                            pro[1]+"\t\t"+list[r][5]+"\n"+
                            pro[2]+"\t\t"+list[r][6]+"\n"+
                            pro[3]+"\t\t"+list[r][6]+"\n"+
                            pro[4]+"\t\t"+list[r][6]+"\n"+
                            pro[5]+"\t\t"+list[r][6]+"\n"+
                            pro[6]+"\t\t"+list[r][7]+"\n"+
                            pro[7]+"\t\t"+list[r][8]+"\n");
                    match=true;
                }
            }
            if(!match){
                if(T1.getText().toLowerCase().equals("verb")||T1.getText().toLowerCase().equals("verbs")){
                    displayArea.append("Regular Conjugation Chart:\n\n"
                        + "Ich\t[stem]+e\n"
                        + "Du\t[stem]+st\n"
                        + "Er\t[stem]+t\n"
                        + "Sie\t[stem]+t\n"
                        + "Es\t[stem]+t\n"
                        + "Wir\t[stem]+en\n"
                        + "Ihr\t[stem]+t\n"
                        + "Sie\t[stem]+en\n"
                        + "sie\t[stem]+en\n");
                match=true;
                }
                
                if(T1.getText().toLowerCase().equals("pronouns")||T1.getText().toLowerCase().equals("pronoun")){
                    displayArea.append("List of Pronouns:\n\n"
                        + "I\t\tIch\n"
                        + "You\t\tDu\n"
                        + "He\t\tEr\n"
                        + "She\t\tSie\n"
                        + "It\t\tEs\n"
                        + "We\t\tWir\n"
                        + "You(plural)\tIhr\n"
                        + "You(formal)\tSie\n"
                        + "They\t\tsie\n"); 
                match = true;
                }
                
            else{
                L1.setText("Sorry, I don't know that word.");
            }
        }
            
        if(match){
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
        bout.setSize(30,30);
        bout.addActionListener((ActionEvent event) -> {
            about win=new about();
        });
        
        
        JMenuItem wd = new JMenuItem("Word List");
        wd.setMnemonic(KeyEvent.VK_L);
        wd.setToolTipText("Open the list of known words.");
        wd.addActionListener((ActionEvent event) -> {
            lithWords j = new lithWords();
        });
        
        
        JMenuItem spn = new JMenuItem("Spanish");
        spn.setMnemonic(KeyEvent.VK_S);
        spn.setToolTipText("Switch To Spanish.");
        spn.addActionListener((ActionEvent event) -> {
            spanish g = new spanish();
            dispose();
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
        dut.setFont(fonttt);
        exit.setFont(fonttt);
        
        about.add(wd);
        about.add(bout);
        
        sel.add(dut);
        sel.add(ger);
        sel.add(spn);
        
        file.add(sel);
        file.add(exit);
        
        menu.add(file);
        menu.add(about);
        
        setJMenuBar(menu);
    }
}