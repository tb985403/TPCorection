/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Fruit;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author celine
 */
public class VueGraphiqueListe extends JFrame implements VueGraphique {
    private final JButton inc;
    private final JButton dec;
    private final JComboBox<Fruit> listeFruits;
    private JTextArea affichenb;

    public JButton getInc() {
        return inc;
    }

    public JButton getDec() {
        return dec;
    }

    public JTextArea getAffiche() {
        return affichenb;
    }
    
    public void setAffiche(JTextArea affiche) {
        this.affichenb = affiche;
    }

    public JComboBox<Fruit> getListeAdd() {
        return listeFruits;
    }
    
    public void addListeFruits(Fruit f){
        listeFruits.addItem(f);
        affichenb.setText(affichenb.getText() + "0 " + f + " a " + f.getPrice() + " euros\n" );
    }

    public VueGraphiqueListe(){
        super("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affichenb = new JTextArea("Panier de 0 fruits\n");
        
        listeFruits = new JComboBox<Fruit>();
        JPanel panelN = new JPanel();
	panelN.setLayout(new FlowLayout());
        panelN.add(inc);
        panelN.add(listeFruits);
        add(panelN, BorderLayout.NORTH);

        add(dec, BorderLayout.SOUTH);
        add(affichenb, BorderLayout.CENTER);
        
        this.setVisible(true);
        
        /* Use setName() so AssertJ Swing can find these components easily */
        inc.setName("Plus");
        dec.setName("Minus");
        affichenb.setName("Affichage");
        listeFruits.setName("Fruit");
    }

    @Override
    public void update(Observable m, Object o) {
        Panier p = (Panier) m;
        if(p.estVide())
            getAffiche().setText("Panier de 0 fruits\n");
        else
            getAffiche().setText("Panier de " + ((Integer)p.getFruits().size()).toString() + " fruits : " + p.getPrice() + " euros\n");
        for(int i = 0 ; i < listeFruits.getItemCount() ; i++)
        {
            Fruit f = (Fruit) listeFruits.getItemAt(i);
            int nb = p.nbFruits(f);
            affichenb.setText(affichenb.getText() + nb + " " + listeFruits.getItemAt(i) + " a " + listeFruits.getItemAt(i).getPrice() + " euros\n" );
        }
    }

    @Override
    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
}
