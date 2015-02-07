package pidgeon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Box;
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

class Dutch extends JFrame implements KeyListener {

    JButton B1;
    JTextField T1;
    JLabel L1;
    JLabel ten;
    JTextArea displayArea;
    int r;
    boolean match = false;
    boolean pastT = false;
    boolean future = false;
    boolean present = true;

    Font fontt;
    Font fonttt;

    String pro[] = arrays.dutchPro;

    String fut[] = arrays.dutchSimpleFuture;

    String list[][] = arrays.Dutch;

    public Dutch() {

        fontt = font.deriveFont(16f);
        fonttt = font.deriveFont(12.49f);

        setTitle("Pidgeon for Dutch");
        setIconImage(myImg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 360);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new FlowLayout());
        B1 = new JButton("Conjugate");
        B1.setFont(fonttt);
        T1 = new JTextField("Conjugate verb", 10);
        T1.setFont(fontt);
        L1 = new JLabel("");
        L1.setFont(fonttt);
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(340, 245));
        initUI();
        add(T1);
        add(B1);
        add(L1);
        add(scrollPane);
        PBactionListener handler = new PBactionListener();
        B1.addActionListener(handler);
        T1.addKeyListener((KeyListener) this);
        T1.requestFocus();
        T1.selectAll();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            B1.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    private class PBactionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = T1.getText().toLowerCase();
            if (input.startsWith("to ")) {
                input = input.substring(3);
            }
            displayArea.setText(null);
            if (future) {
                switch(input){
                    case "can":
                    case "kunnen":
                        displayArea.setText("Can -- Kunnen -- Irregular\n\n"
                            + pro[0] + "\t\t" + fut[0] + " " + "kan\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "kan/kunt\n"
                            + pro[2] + "\t\t" + fut[2] + " " + "kan\n"
                            + pro[3] + "\t\t" + fut[2] + " " + "kan\n"
                            + pro[4] + "\t\t" + fut[2] + " " + "kan\n"
                            + pro[5] + "\t\t" + fut[2] + " " + "kan\n"
                            + pro[6] + "\t\t" + fut[3] + " " + "kunnen\n"
                            + pro[7] + "\t\t" + fut[3] + " " + "kunnen\n"
                            + pro[8] + "\t\t" + fut[3] + " " + "kunnen");
                        match = true;
                        break;
                        
                    case "have":
                    case "hebben":
                        displayArea.setText("To have -- Hebben -- Irregular\n\n"
                            + pro[0] + "\t\t" + fut[0] + " " + "heb\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "hebt\n"
                            + pro[2] + "\t\t" + fut[2] + " " + "heeft\n"
                            + pro[3] + "\t\t" + fut[2] + " " + "heeft\n"
                            + pro[4] + "\t\t" + fut[2] + " " + "heeft\n"
                            + pro[5] + "\t\t" + fut[2] + " " + "heeft\n"
                            + pro[6] + "\t\t" + fut[3] + " " + "hebben\n"
                            + pro[7] + "\t\t" + fut[3] + " " + "hebben\n"
                            + pro[8] + "\t\t" + fut[3] + " " + "hebben");
                        match = true;
                        break;
                        
                    case "may":
                    case "mogen":
                        displayArea.setText("May -- Mogen -- Irregular\n\n"
                            + pro[0] + "\t\t" + fut[0] + " " + "mag\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "mag\n"
                            + pro[2] + "\t\t" + fut[2] + " " + "mag\n"
                            + pro[3] + "\t\t" + fut[2] + " " + "mag\n"
                            + pro[4] + "\t\t" + fut[2] + " " + "mag\n"
                            + pro[5] + "\t\t" + fut[2] + " " + "mag\n"
                            + pro[6] + "\t\t" + fut[3] + " " + "mogen\n"
                            + pro[7] + "\t\t" + fut[3] + " " + "mogen\n"
                            + pro[8] + "\t\t" + fut[3] + " " + "mogen");
                        match = true;
                        break;
                        
                    case "want":
                    case "willen":
                        displayArea.setText("To want -- Willen -- Irregular\n\n"
                            + pro[0] + "\t\t" + fut[0] + " " + "wil\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "wil/wilt\n"
                            + pro[2] + "\t\t" + fut[2] + " " + "wil\n"
                            + pro[3] + "\t\t" + fut[2] + " " + "wil\n"
                            + pro[4] + "\t\t" + fut[2] + " " + "wil\n"
                            + pro[5] + "\t\t" + fut[2] + " " + "wil\n"
                            + pro[6] + "\t\t" + fut[3] + " " + "willen\n"
                            + pro[7] + "\t\t" + fut[3] + " " + "willen\n"
                            + pro[8] + "\t\t" + fut[3] + " " + "willen");
                        match = true;
                        break;
                        
                    case "be":
                    case "zijn":
                        displayArea.setText("To be -- Zijn -- Irregular\n\n"
                            + pro[0] + "\t\t" + fut[0] + " " + "ben\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "bent\n"
                            + pro[2] + "\t\t" + fut[2] + " " + "is\n"
                            + pro[3] + "\t\t" + fut[2] + " " + "is\n"
                            + pro[4] + "\t\t" + fut[2] + " " + "is\n"
                            + pro[5] + "\t\t" + fut[2] + " " + "bent\n"
                            + pro[6] + "\t\t" + fut[3] + " " + "zijn\n"
                            + pro[7] + "\t\t" + fut[3] + " " + "zijn\n"
                            + pro[8] + "\t\t" + fut[3] + " " + "zijn");
                        match = true;
                        break;
                        
                    case "will":
                    case "zullen":
                        displayArea.setText("Will -- Zullen -- Irregular\n\n"
                            + pro[0] + "\t\t" + fut[0] + " " + "zal\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "zal/zult\n"
                            + pro[2] + "\t\t" + fut[2] + " " + "zal\n"
                            + pro[3] + "\t\t" + fut[2] + " " + "zal\n"
                            + pro[4] + "\t\t" + fut[2] + " " + "zal\n"
                            + pro[5] + "\t\t" + fut[2] + " " + "zal\n"
                            + pro[6] + "\t\t" + fut[3] + " " + "zullen\n"
                            + pro[7] + "\t\t" + fut[3] + " " + "zullen\n"
                            + pro[8] + "\t\t" + fut[3] + " " + "zullen");
                        match = true;
                        break;
                }
            }
            if (present) {
                for (String[] aDutchList : list) {
                    switch(input){
                    case "can":
                    case "kunnen":
                        displayArea.setText("Can -- Kunnen -- Irregular\n\n"
                            + pro[0] + "\t\t" + "kan\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "kan/kunt\n"
                            + pro[2] + "\t\t" + "kan\n"
                            + pro[3] + "\t\t" + "kan\n"
                            + pro[4] + "\t\t" + "kan\n"
                            + pro[5] + "\t\t" + "kan\n"
                            + pro[6] + "\t\t" + "kunnen\n"
                            + pro[7] + "\t\t" + "kunnen\n"
                            + pro[8] + "\t\t" + "kunnen");
                        match = true;
                        break;
                        
                    case "have":
                    case "hebben":
                        displayArea.setText("To have -- Hebben -- Irregular\n\n"
                            + pro[0] + "\t\t" + "heb\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "hebt\n"
                            + pro[2] + "\t\t" + "heeft\n"
                            + pro[3] + "\t\t" + "heeft\n"
                            + pro[4] + "\t\t" + "heeft\n"
                            + pro[5] + "\t\t" + "heeft\n"
                            + pro[6] + "\t\t" + "hebben\n"
                            + pro[7] + "\t\t" + "hebben\n"
                            + pro[8] + "\t\t" + "hebben");
                        match = true;
                        break;
                        
                    case "may":
                    case "mogen":
                        displayArea.setText("May -- Mogen -- Irregular\n\n"
                            + pro[0] + "\t\t" + "mag\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "mag\n"
                            + pro[2] + "\t\t" + "mag\n"
                            + pro[3] + "\t\t" + "mag\n"
                            + pro[4] + "\t\t" + "mag\n"
                            + pro[5] + "\t\t" + "mag\n"
                            + pro[6] + "\t\t" + "mogen\n"
                            + pro[7] + "\t\t" + "mogen\n"
                            + pro[8] + "\t\t" + "mogen");
                        match = true;
                        break;
                        
                    case "want":
                    case "willen":
                        displayArea.setText("To want -- Willen -- Irregular\n\n"
                            + pro[0] + "\t\t" + "wil\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "wil/wilt\n"
                            + pro[2] + "\t\t" + "wil\n"
                            + pro[3] + "\t\t" + "wil\n"
                            + pro[4] + "\t\t" + "wil\n"
                            + pro[5] + "\t\t" + "wil\n"
                            + pro[6] + "\t\t" + "willen\n"
                            + pro[7] + "\t\t" + "willen\n"
                            + pro[8] + "\t\t" + "willen");
                        match = true;
                        break;
                        
                    case "be":
                    case "zijn":
                        displayArea.setText("To be -- Zijn -- Irregular\n\n"
                            + pro[0] + "\t\t" + "ben\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "bent\n"
                            + pro[2] + "\t\t" + "is\n"
                            + pro[3] + "\t\t" + "is\n"
                            + pro[4] + "\t\t" + "is\n"
                            + pro[5] + "\t\t" + "bent\n"
                            + pro[6] + "\t\t" + "zijn\n"
                            + pro[7] + "\t\t" + "zijn\n"
                            + pro[8] + "\t\t" + "zijn");
                        match = true;
                        break;
                        
                    case "will":
                    case "zullen":
                        displayArea.setText("Will -- Zullen -- Irregular\n\n"
                            + pro[0] + "\t\t" + "zal\n"
                            + pro[1] + "\t\t" + fut[1] + " " + "zal/zult\n"
                            + pro[2] + "\t\t" + "zal\n"
                            + pro[3] + "\t\t" + "zal\n"
                            + pro[4] + "\t\t" + "zal\n"
                            + pro[5] + "\t\t" + "zal\n"
                            + pro[6] + "\t\t" + "zullen\n"
                            + pro[7] + "\t\t" + "zullen\n"
                            + pro[8] + "\t\t" + "zullen");
                        match = true;
                        break;
                }
                    if (!match) {
                        if (input.equalsIgnoreCase(aDutchList[1])||input.equalsIgnoreCase(aDutchList[2])) {
                            displayArea.append(aDutchList[0] + " " + aDutchList[1] + " -- " + aDutchList[2] + " -- " + aDutchList[3] + "\n\n"
                                    + pro[0] + "\t\t" + aDutchList[4] + "\n"
                                    + pro[1] + "\t\t" + aDutchList[5] + "\n"
                                    + pro[2] + "\t\t" + aDutchList[5] + "\n"
                                    + pro[3] + "\t\t" + aDutchList[5] + "\n"
                                    + pro[4] + "\t\t" + aDutchList[5] + "\n"
                                    + pro[5] + "\t\t" + aDutchList[5] + "\n"
                                    + pro[6] + "\t\t" + aDutchList[6] + "\n"
                                    + pro[7] + "\t\t" + aDutchList[6] + "\n"
                                    + pro[8] + "\t\t" + aDutchList[6] + "\n");
                            match = true;
                        }
                    }
                }
            } else if (future) {
                if (!match) {
                    for (String[] aDutchList : list) {
                        if (input.equalsIgnoreCase(aDutchList[1])||input.equalsIgnoreCase(aDutchList[2])) {
                            displayArea.append(aDutchList[0] + " " + aDutchList[1] + " -- " + aDutchList[2] + " -- " + aDutchList[3] + "\n\n"
                                    + pro[0] + "\t\t" + fut[0] + " " + aDutchList[6] + "\n"
                                    + pro[1] + "\t\t" + fut[1] + " " + aDutchList[6] + "\n"
                                    + pro[2] + "\t\t" + fut[1] + " " + aDutchList[6] + "\n"
                                    + pro[3] + "\t\t" + fut[1] + " " + aDutchList[6] + "\n"
                                    + pro[4] + "\t\t" + fut[1] + " " + aDutchList[6] + "\n"
                                    + pro[5] + "\t\t" + fut[1] + " " + aDutchList[6] + "\n"
                                    + pro[6] + "\t\t" + fut[2] + " " + aDutchList[6] + "\n"
                                    + pro[7] + "\t\t" + fut[2] + " " + aDutchList[6] + "\n"
                                    + pro[8] + "\t\t" + fut[2] + " " + aDutchList[6] + "\n");
                            match = true;
                        }
                    }
                }
            } else if (pastT) {
                if (!match) {
                    for (String[] aDutchList : list) {
                        if (input.equalsIgnoreCase(aDutchList[1])) {
                            switch (aDutchList[7]) {
                                case "t":
                                    displayArea.append(aDutchList[0] + " " + aDutchList[1] + " -- " + aDutchList[2] + " -- " + aDutchList[3] + "\n\n"
                                            + pro[0] + "\t\t" + aDutchList[4] + "te\n"
                                            + pro[1] + "\t\t" + aDutchList[4] + "te\n"
                                            + pro[2] + "\t\t" + aDutchList[4] + "te\n"
                                            + pro[3] + "\t\t" + aDutchList[4] + "te\n"
                                            + pro[4] + "\t\t" + aDutchList[4] + "te\n"
                                            + pro[5] + "\t\t" + aDutchList[4] + "te\n"
                                            + pro[6] + "\t\t" + aDutchList[4] + "ten\n"
                                            + pro[7] + "\t\t" + aDutchList[4] + "ten\n"
                                            + pro[8] + "\t\t" + aDutchList[4] + "ten\n");
                                    match = true;
                                    break;
                                case "d":
                                    displayArea.append(aDutchList[0] + " " + aDutchList[1] + " -- " + aDutchList[2] + " -- " + aDutchList[3] + "\n\n"
                                            + pro[0] + "\t\t" + aDutchList[4] + "de\n"
                                            + pro[1] + "\t\t" + aDutchList[4] + "de\n"
                                            + pro[2] + "\t\t" + aDutchList[4] + "de\n"
                                            + pro[3] + "\t\t" + aDutchList[4] + "de\n"
                                            + pro[4] + "\t\t" + aDutchList[4] + "de\n"
                                            + pro[5] + "\t\t" + aDutchList[4] + "de\n"
                                            + pro[6] + "\t\t" + aDutchList[4] + "den\n"
                                            + pro[7] + "\t\t" + aDutchList[4] + "den\n"
                                            + pro[8] + "\t\t" + aDutchList[4] + "den\n");
                                    match = true;
                                    break;
                                case "y":
                                    break;
                            }
                        }
                    }
                }
            }

            if (!match) {
                switch(input){
                    case "verb":
                    case "verbs":
                        displayArea.append("Regular Conjugation Chart:\n\n"
                            + "Ik\t[stem]\n"
                            + "Jij\t[stem]+t\n"
                            + "Hij\t[stem]+t\n"
                            + "Zij\t[stem]+t\n"
                            + "Het\t[stem]+t\n"
                            + "Wij\t[stem]+en\n"
                            + "Jullie\t[stem]+en\n"
                            + "U\t[stem]+t\n"
                            + "Zij\t[stem]+en\n");
                        match = true;
                        break;
                        
                    case "pronoun":
                    case "pronouns":
                        displayArea.append("List of Pronouns:\n\n"
                            + "I\t\tIk\n"
                            + "You\t\tJij\n"
                            + "He\t\tHij\n"
                            + "She\t\tZij\n"
                            + "It\t\tHet\n"
                            + "We\t\tWij\n"
                            + "You(plural)\tJullie\n"
                            + "You(formal)\tU\n"
                            + "They\t\tZij\n");
                        match = true;
                        break;
                }
            }

            if (!match) {
                L1.setText("Sorry, I don't know that word.");
            }

            if (match) {
                L1.setText(null);
            }

            match = false;

            T1.requestFocus();

            T1.selectAll();
        }
    }

    private void initUI() {

        JMenuBar menu = new JMenuBar();

        ten = new JLabel("Present tense   ");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu about = new JMenu("About");
        about.setMnemonic(KeyEvent.VK_A);

        JMenu tense = new JMenu("Tense");
        tense.setMnemonic(KeyEvent.VK_T);

        JMenu sel = new JMenu("Language select");
        sel.setMnemonic(KeyEvent.VK_S);
        sel.setToolTipText("Select new language.");

        JMenuItem bout = new JMenuItem("Info");
        bout.setMnemonic(KeyEvent.VK_W);
        bout.setToolTipText("About the programme.");
        bout.setSize(30, 30);
        bout.addActionListener((ActionEvent event) -> {
            about win = new about();
        });

        JMenuItem wd = new JMenuItem("Word List");
        wd.setMnemonic(KeyEvent.VK_L);
        wd.setToolTipText("Open the list of known words.");
        wd.addActionListener((ActionEvent event) -> {
            dutchWords j = new dutchWords();
        });

        JMenuItem ger = new JMenuItem("German");
        ger.setMnemonic(KeyEvent.VK_G);
        ger.setToolTipText("Switch To German.");
        ger.addActionListener((ActionEvent event) -> {
            pidgy g = new pidgy();
            dispose();
        });

        JMenuItem spn = new JMenuItem("Spanish");
        spn.setMnemonic(KeyEvent.VK_S);
        spn.setToolTipText("Switch To Spanish.");
        spn.addActionListener((ActionEvent event) -> {
            spanish g = new spanish();
            dispose();
        });

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Exit the application.");
        exit.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        JMenuItem past = new JMenuItem("Simple past");
        past.setMnemonic(KeyEvent.VK_S);
        past.setToolTipText("Switch conjugations to the simple past tence");
        past.addActionListener((ActionEvent event) -> {
            pastT = true;
            future = false;
            present = false;
            match = false;
            displayArea.setText(null);
            L1.setText(null);
            ten.setText("Past tense   ");
        });

        JMenuItem pres = new JMenuItem("Present");
        pres.setMnemonic(KeyEvent.VK_P);
        pres.setToolTipText("Switch conjugations to the present tence");
        pres.addActionListener((ActionEvent event) -> {
            pastT = false;
            future = false;
            present = true;
            match = false;
            displayArea.setText(null);
            L1.setText(null);
            ten.setText("Present tense   ");
        });

        JMenuItem futes = new JMenuItem("Future");
        futes.setMnemonic(KeyEvent.VK_F);
        futes.setToolTipText("Switch conjugations to future tence");
        futes.addActionListener((ActionEvent event) -> {
            pastT = false;
            future = true;
            present = false;
            match = false;
            displayArea.setText(null);
            L1.setText(null);
            ten.setText("Future tense   ");
        });

        file.setFont(fonttt);
        about.setFont(fonttt);
        sel.setFont(fonttt);
        bout.setFont(fonttt);
        wd.setFont(fonttt);
        ger.setFont(fonttt);
        exit.setFont(fonttt);
        tense.setFont(fonttt);
        past.setFont(fonttt);
        pres.setFont(fonttt);
        futes.setFont(fonttt);

        tense.add(futes);
        //tense.add(past);
        tense.add(pres);

        about.add(wd);
        about.add(bout);

        sel.add(ger);
        sel.add(spn);

        file.add(sel);
        file.add(exit);

        menu.add(file);
        menu.add(tense);
        menu.add(about);
        menu.add(Box.createHorizontalGlue());
        menu.add(ten);

        setJMenuBar(menu);
    }
}