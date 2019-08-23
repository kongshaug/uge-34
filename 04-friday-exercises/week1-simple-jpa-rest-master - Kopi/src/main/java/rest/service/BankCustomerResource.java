package rest.service;

import com.google.gson.Gson;
import dto.CustomerDTO;
import entities.BankCustomer;
import facades.BankFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




@Path("bankcustomer")
public class BankCustomerResource {

   EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
         BankFacade ba =  BankFacade.getFacadeExample(emf);

   
   


    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String gattagetthemall() {
        
               
        List<BankCustomer> emplist = ba.getAllBankCustomers();
        String ans = "";
        for(BankCustomer emp : emplist)
        {
        ans += new Gson().toJson(new CustomerDTO(emp));
        }
    
      return ans;
        
        
     
    }
     @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String doYouHaveId(@PathParam("id") Long id) {
        
         
        CustomerDTO cDTO =ba.getCustomerByID(id);

       return new Gson().toJson(cDTO);
         
   
        
    }
    
    @GET
    @Path("/pop")
    public String Popu()
    {
       EntityManagerFactory _emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        
        
        
        em.persist(new BankCustomer("jim", "cary", "2112 2332422", 123123.12, "he is a good guy, give him a cookie"));
        em.persist(new BankCustomer("bill", "billington", "4323 9099999", 222222.12, "he is a bad cat, dont give him a cookie"));
        em.persist(new BankCustomer("kayti", "kaitington", "9393 2112211221", 3333333.33, "she is a moron , give her a cat"));
        em.persist(new BankCustomer("filip", "filipton", "8888 77777777", 54545445.44, "havent meet the guy but i hear great things"));
        em.persist(new BankCustomer("ymaino", "pedersen", "7686 93939393", 75757575.09, "he already has a bunch of cookies"));
        em.getTransaction().commit();
        em.close();
        return "it worked!";
        }


}
