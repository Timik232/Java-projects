package patterns;
//
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EditorUI extends JFrame {
    private final ICreateDocument factory = new TextFactory();
    private IDocument idocument;
    private  JFileChooser fileChooser = null;
    JMenuBar menuBar = new JMenuBar();
    public EditorUI(){
        super("Menu");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        setSize(500, 250);
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    private JMenu createFileMenu(){
        fileChooser = new JFileChooser();
        JMenu file = new JMenu("File");
        JMenuItem create = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem(new ExitAction());
        file.add(create);
        file.addSeparator();
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(exit);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idocument = factory.createNew();
                JOptionPane.showMessageDialog(EditorUI.this, idocument.print());
                JTextArea textArea = new JTextArea(2, 10);
                EditorUI.this.add(textArea);
            }
        });
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idocument = factory.createOpen();
                fileChooser.setDialogTitle("Choosing directory");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(EditorUI.this);
                if (result == JFileChooser.APPROVE_OPTION ) {
                    File f = fileChooser.getSelectedFile();
                    try {
                        Desktop.getDesktop().open(f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Saving file");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(EditorUI.this);
                if (result == JFileChooser.APPROVE_OPTION )
                    JOptionPane.showMessageDialog(EditorUI.this,
                            "File " + fileChooser.getSelectedFile() + " was saved");
            }
        });

        return file;
    }
    class ExitAction extends AbstractAction
    {
        ExitAction() {
            putValue(NAME, "Exit");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new EditorUI();
    }
}