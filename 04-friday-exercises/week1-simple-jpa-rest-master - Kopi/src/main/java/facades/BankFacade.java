package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankFacade {

    private static BankFacade instance;
    private static EntityManagerFactory emf;
    

    //Private Constructor to ensure Singleton
    private BankFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   public CustomerDTO getCustomerByID(Long id) {
        
        EntityManager em = getEntityManager();

        try {
            BankCustomer bc = em.find(BankCustomer.class, id);
            CustomerDTO cus = new CustomerDTO(bc);
            return cus;
        } finally {
            em.close();
        }
    }

   public List<CustomerDTO> getCustomerByName(String firstname) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<BankCustomer> tq = em.createQuery("SELECT bc from BankCustomer bc where bc.firstName = :firstname", BankCustomer.class);
            tq.setParameter("firstname", firstname);
            List<BankCustomer> cusList = tq.getResultList();
            List<CustomerDTO> DTOList = new ArrayList<>();
            for (BankCustomer bc : cusList) {
                DTOList.add(new CustomerDTO(bc));
            }

            return DTOList;
        } finally {
            em.close();
        }

    }

   public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = getEntityManager();
        
        try{
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        return cust;
        }finally{
        em.close();
        
        }
    }
    
   public BankCustomer deleteCust(BankCustomer cust) {
        EntityManager em = getEntityManager();
        
        try{
        em.getTransaction().begin();
        BankCustomer bc = em.merge(cust);
        em.remove(bc);
        em.getTransaction().commit();
        return cust;
        }finally{
        em.close();
        
        }
        
    }

   public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<BankCustomer> tq = em.createQuery("SELECT bc from BankCustomer bc", BankCustomer.class);
            List<BankCustomer> cusList = tq.getResultList();
            return cusList;
        } finally {
            em.close();
        }
    }
}
