package ihm;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelPaint extends JPanel implements MouseMotionListener,MouseListener
{
    private ArrayList<ArrayList<Point>> lstPoint;
    private ArrayList<Color> lstCouleur;
    private int epaisseur;
    private Color couleur;

    public PanelPaint()
    {
        this.epaisseur = 0;
        this.couleur = Color.BLACK;
        this.lstCouleur = new ArrayList<Color>();
        this.lstPoint = new ArrayList<ArrayList<Point>>();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void nouveau()
    {
        this.lstPoint = new ArrayList<ArrayList<Point>>();
        this.lstCouleur = new ArrayList<Color>();
        this.repaint();
    }

    public void annuler()
    {
        if (this.lstPoint.size() > 0)
        {
            this.lstPoint.remove(this.lstPoint.size()-1);
            this.lstCouleur.remove(this.lstCouleur.size()-1);
            this.repaint();
        }
    }

    public void changeCouleur(Color couleur)
    {
        this.couleur = couleur;
    }

    private void ajoutPoint(int posX, int posY)
    {
        for(int cptX = -this.epaisseur; cptX <= this.epaisseur; cptX++)
            for(int cptY = -this.epaisseur; cptY <= this.epaisseur; cptY++)
                this.lstPoint.get(this.lstPoint.size()-1).add(new Point(posX+cptX,posY+cptY));
        this.repaint();
    }

    public void changeEpaisseur(int epaisseur)
    {
        this.epaisseur = epaisseur;
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        for(int cptTrait = 0; cptTrait < this.lstPoint.size(); cptTrait++)
        {
            g.setColor(this.lstCouleur.get(cptTrait));
            for(int cpt = 0; cpt < this.lstPoint.get(cptTrait).size()-1; cpt++)
                g.drawLine((int)this.lstPoint.get(cptTrait).get(cpt).getX(), (int)this.lstPoint.get(cptTrait).get(cpt).getY(), (int)this.lstPoint.get(cptTrait).get(cpt+1).getX(), (int)this.lstPoint.get(cptTrait).get(cpt+1).getY());
            g.drawLine((int)this.lstPoint.get(cptTrait).get(this.lstPoint.get(cptTrait).size()-1).getX(), (int)this.lstPoint.get(cptTrait).get(this.lstPoint.get(cptTrait).size()-1).getY(), (int)this.lstPoint.get(cptTrait).get(this.lstPoint.get(cptTrait).size()-1).getX(), (int)this.lstPoint.get(cptTrait).get(this.lstPoint.get(cptTrait).size()-1).getY());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        this.ajoutPoint(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        this.lstCouleur.add(this.couleur);
        this.lstPoint.add(new ArrayList<Point>());
        this.ajoutPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {

    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {

    }

    @Override
    public void mouseExited(MouseEvent e) 
    {

    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {

    }
}