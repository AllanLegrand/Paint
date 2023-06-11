package ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FramePaint extends JFrame
{
    private static final int LARGEUR = (int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.55);
    private static final int HAUTEUR = (int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.55);

    public FramePaint()
    {
        this.setTitle   ("MonMenu");
		this.setLocation((int)(LARGEUR-LARGEUR*0.55), (int)(HAUTEUR-HAUTEUR*0.55));
		this.setSize    (LARGEUR, HAUTEUR);

        PanelPaint panelPaint = new PanelPaint();

        this.add(panelPaint,BorderLayout.CENTER);
        this.add(new PanelOption(panelPaint),BorderLayout.WEST);
        this.add(new PanelCouleur(panelPaint),BorderLayout.SOUTH);

        this.setJMenuBar( new MenuBarPaint(this,panelPaint) );

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible( true );
    }
}