/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author celine
 */
public interface Fruit {
    public boolean isSeedless();
    public double getPrice();
    public String getCountry();
    @Override
    public boolean equals(Object o);
    @Override
    public String toString();
}
