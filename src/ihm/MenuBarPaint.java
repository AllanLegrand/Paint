package ihm;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.*;


public class MenuBarPaint extends JMenuBar implements ActionListener
{
    private FramePaint frame;   
	private PanelPaint panelPaint;

    private JMenuItem menuiFichierNouveau;
	private JMenuItem menuiFichierOuvrir;
	private JMenuItem menuiFichierFermer;
	private JMenuItem menuiFichierEnregistrer;
	private JMenuItem menuiFichierEnregistrerSous;
	private JMenuItem menuiFichierQuitter;

	private JMenuItem menuiEditionAnnuler;
	private JMenuItem menuiEditionRefaire;
	private JMenuItem menuiEditionCopier;
	private JMenuItem menuiEditionColler;
	private JMenuItem menuiEditionCouper;

    public MenuBarPaint(FramePaint frame, PanelPaint panelPaint)
    {
        this.frame = frame;
		this.panelPaint = panelPaint;

        // un element de la barre de menu
		JMenu menuFichier   = new JMenu("Fichier"  );
		JMenu menuEdition   = new JMenu("Edition"  );

        menuFichier  .setMnemonic('F');
        menuEdition  .setMnemonic('E');

		// les items du menu fichier
		this.menuiFichierNouveau 		 = new JMenuItem ("Nouveau"			);
		this.menuiFichierOuvrir  		 = new JMenuItem ("Ouvrir" 			);
		this.menuiFichierFermer          = new JMenuItem ("Fermer" 	);
		this.menuiFichierEnregistrer 	 = new JMenuItem ("Enregistrer"     );
		this.menuiFichierEnregistrerSous = new JMenuItem ("Enregistrer Sous");
		this.menuiFichierQuitter 		 = new JMenuItem ("Quitter"			);

        this.menuiFichierNouveau        .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK                              )); 
        this.menuiFichierOuvrir         .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK                              )); 
        this.menuiFichierEnregistrer    .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK                              )); 
        this.menuiFichierEnregistrerSous.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK ));
        this.menuiFichierQuitter        .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_DOWN_MASK                               )); 

		this.menuiEditionAnnuler 		 = new JMenuItem ("Annuler"			);
		this.menuiEditionRefaire 		 = new JMenuItem ("Refaire"			);
		this.menuiEditionCopier 		 = new JMenuItem ("Copier"			);
		this.menuiEditionColler 		 = new JMenuItem ("Coller"			);
		this.menuiEditionCouper 		 = new JMenuItem ("Couper"			);

        this.menuiEditionAnnuler.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK )); 
        this.menuiEditionRefaire.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK )); 
        this.menuiEditionCopier .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK )); 
        this.menuiEditionColler .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK )); 
        this.menuiEditionCouper .setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK )); 

		// ajouts des items au menu correspondant
		menuFichier.add( this.menuiFichierNouveau		  );
		menuFichier.add( this.menuiFichierOuvrir          );
		menuFichier.add( this.menuiFichierFermer          );
		menuFichier.addSeparator( 					  );
		menuFichier.add( this.menuiFichierEnregistrer     );
		menuFichier.add( this.menuiFichierEnregistrerSous );
		menuFichier.addSeparator( 					  );
		menuFichier.add( this.menuiFichierQuitter 		  );

		menuEdition.add( this.menuiEditionAnnuler);
		menuEdition.add( this.menuiEditionRefaire);
		menuEdition.addSeparator(                );
		menuEdition.add( this.menuiEditionCopier );
		menuEdition.add( this.menuiEditionColler );
		menuEdition.add( this.menuiEditionCouper );

		// ajout du menu 'Fichier' a la barre de menu
		this.add( menuFichier   );
		this.add( menuEdition   );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		this.menuiFichierNouveau        .addActionListener ( this );
		this.menuiFichierOuvrir         .addActionListener ( this );
		this.menuiFichierFermer         .addActionListener ( this );
		this.menuiFichierEnregistrer    .addActionListener ( this );
		this.menuiFichierEnregistrerSous.addActionListener ( this );
		this.menuiFichierQuitter        .addActionListener ( this );

		this.menuiEditionAnnuler.addActionListener ( this );
		this.menuiEditionRefaire.addActionListener ( this );
		this.menuiEditionCopier .addActionListener ( this );
		this.menuiEditionColler .addActionListener ( this );
		this.menuiEditionCouper .addActionListener ( this );
    }

    public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource() == this.menuiFichierNouveau )
			this.panelPaint.nouveau();

		if ( e.getSource() == this.menuiEditionAnnuler )
			this.panelPaint.annuler();

		if ( e.getSource() == this.menuiFichierQuitter )
			this.frame.dispose();
	}
}
