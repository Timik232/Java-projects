package events;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MilanMadrid extends JFrame {
    JButton madrid = new JButton("Real Madrid");
    JButton milan = new JButton("AC Milan");
    JLabel result = new JLabel("Result: 0 X 0",SwingConstants.CENTER);
    JLabel score = new JLabel("Last Scorer: N/A");
    JLabel winner = new JLabel("Winner: DRAW");
    JPanel[] pnl = new JPanel[16];
    int milwin = 0;
    int madwin = 0;
    public MilanMadrid(){
        super("Football game");
        setSize(450,130);
        setLayout(new GridLayout(2,3));
        for (int i = 0; i < 6; i++) {
        pnl[i] = new JPanel();
        add(pnl[i]);
        }
        milan.setPreferredSize(new Dimension(120,38));
        madrid.setPreferredSize(new Dimension(120,38));
        pnl[4].add(result);
        pnl[2].add(score);
        pnl[0].add(winner);
        pnl[3].add(madrid);
        pnl[5].add(milan);

        madrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madwin+=1;
                result.setText("Result: " + madwin + " X " + milwin);
                score.setText("Last Scorer: Real Madrid");
                if (madwin > milwin)
                    winner.setText("Winner: Real Madrid");
                else if (madwin == milwin)
                    winner.setText("Winner: Draw");
                else
                    winner.setText("Winner: AC Milan");
            }
        });
        milan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milwin+=1;
                result.setText("Result: " + madwin + " X " + milwin);
                score.setText("Last Scorer: AC Milan");
                if (madwin > milwin)
                    winner.setText("Winner: Real Madrid");
                else if (madwin == milwin)
                    winner.setText("Winner: Draw");
                else
                    winner.setText("Winner: AC Milan");
            }
        });
    }
    public static void main(String[]args){
        new MilanMadrid().setVisible(true);
    }
}
