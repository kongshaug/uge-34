/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author benja
 */
public class MakeTestData {
    public static void main(String[] args) {
        EntityManagerFactory _emf = Persistence.createEntityManagerFactory("putest");
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        
        
        
        em.persist(new BankCustomer("jim", "cary", "2112 2332422", 123123.12, "he is a good guy, give him a cookie"));
        em.persist(new BankCustomer("bill", "billington", "4323 9099999", 222222.12, "he is a bad cat, dont give him a cookie"));
        em.persist(new BankCustomer("kayti", "kaitington", "9393 2112211221", 3333333.33, "she is a moron , give her a cat"));
        em.persist(new BankCustomer("filip", "filipton", "8888 77777777", 54545445.44, "havent meet the guy but i hear great things"));
        em.persist(new BankCustomer("ymaino", "pedersen", "7686 93939393", 75757575.09, "he already has a bunch of cookies"));
        em.getTransaction().commit();
        em.close();
       
    }
    
}
