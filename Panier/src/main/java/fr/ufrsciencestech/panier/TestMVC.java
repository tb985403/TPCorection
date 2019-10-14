package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.Controler.*;
import fr.ufrsciencestech.panier.View.*;
import javax.swing.JFrame;
/*
//pour springIoC :
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
*/

/**
 *
 * @author celine
 */
public class TestMVC {

    public static void main(String[] args){
        Panier p = new Panier(4);
        //une vue console abonnee au panier :
        VueConsole vuec = new VueConsole();
        p.addObserver(vuec);
        
        //une vue graphique simple abonnee au panier :
        VueGraphiqueSimple vueg = new VueGraphiqueSimple();
        //VueGraphiqueSimpleAWT vueg = new VueGraphiqueSimpleAWT();
        Controleur cs = new ControleurSimple();
        cs.setPanier(p);
        p.addObserver(vueg);
        vueg.addControleur(cs);
        
        /* //La meme chose mais avec SpringIoC :
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        Controleur cs = (Controleur)context.getBean("Controleur");  //SpringIoC
        p.addObserver(test.vueg);
        test.vueg.addControleur(cs);*/

        //une vue graphique complexe (liste) abonnee au panier :
        VueGraphiqueListe vuel = new VueGraphiqueListe();
        Fruit o = (Fruit)new Orange();
        vuel.addListeFruits(o);
        Fruit b = (Fruit)new Banane();
        vuel.addListeFruits(b);
        Fruit c = (Fruit)new Cerise();
        vuel.addListeFruits(c);
        
        Fruit ban = (Fruit)new Macedoine(new Banane());
        vuel.addListeFruits(ban);
        
        Fruit ile = (Fruit)new Macedoine(new Banane());
        Ananas a1 = new Ananas();
        ((Macedoine)ile).add(a1);
        vuel.addListeFruits(ile);
        
        Fruit rouge = (Fruit)new Macedoine(new Cerise());
        Jus jf1 = new Jus(new Fraise());
        ((Macedoine)rouge).add(jf1);
        vuel.addListeFruits(rouge);
  
        Fruit jo1 = (Fruit)new Jus(new Orange());
        vuel.addListeFruits(jo1);
        Fruit jmi = (Fruit)new Jus(ile);
        vuel.addListeFruits(jmi);
        
        ControleurListe cl = new ControleurListe();
        cl.setPanier(p);
        cl.setVue(vuel);
        p.addObserver(vuel);
        vuel.addControleur(cl);
        //afficher la vue courante
        vuel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vuel.pack();
    }
}
