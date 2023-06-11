package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCouleur extends JPanel implements ActionListener
{
    private JButton[] tabCoul;
    private PanelPaint panelPaint;

    public PanelCouleur(PanelPaint panelPaint)
    {
        this.setBackground(Color.LIGHT_GRAY);
        this.panelPaint = panelPaint;

        this.tabCoul = new JButton[27];
        for(int cptR = 0; cptR <= 2; cptR++)
            for(int cptG = 0; cptG <= 2; cptG++)
                for(int cptB = 0; cptB <= 2; cptB++)
                {
                    this.tabCoul[cptR*4+cptG*2+cptB] = new JButton();
                    this.tabCoul[cptR*4+cptG*2+cptB].setBackground(new Color(cptR*127, cptG*127, cptB*127));
                    this.add(this.tabCoul[cptR*4+cptG*2+cptB]);
                    this.tabCoul[cptR*4+cptG*2+cptB].addActionListener(this);
                }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        this.panelPaint.changeCouleur(((JButton)e.getSource()).getBackground());
    }
}
