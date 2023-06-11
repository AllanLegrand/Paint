package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOption extends JPanel implements ActionListener,AdjustmentListener
{
    private JButton[] tabBtn;
    private Scrollbar sbDefil1;
    private PanelPaint panelPaint;

    public PanelOption(PanelPaint panelPaint)
    {
        this.setBackground(Color.LIGHT_GRAY);
        this.panelPaint = panelPaint;
        //this.setLayout(new GridLayout(2,5));
        //this.tabBtn = new JButton[10];

        this.sbDefil1 = new Scrollbar ( Scrollbar.HORIZONTAL,   0, 40,   0, 300);

        this.add(sbDefil1);

        this.sbDefil1.addAdjustmentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) 
    {
        this.panelPaint.changeEpaisseur(this.sbDefil1.getValue());
    }
}
