package i;

import javax.swing.*;

public class ert extends JFrame{

    private JPanel panel1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JTabbedPane tabbedPane1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTree tree1;

    public ert(){
        super("windows");
        setBounds(0,0, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
    }

    public static void main(String[] args) {
        new ert().setVisible(true);
    }
}
