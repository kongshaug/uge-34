///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import dto.CustomerDTO;
//import entities.BankCustomer;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author benja
// */
//public class BankFacadeTest {
//    private static EntityManagerFactory emf;
//   
//    
//    public BankFacadeTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
// 
//
//    /**
//     * Test of getCustomerByID method, of class BankFacade.
//     * gets gustomer with id = 3, which should be bill billington and checks if that is his name.
//     * 
//     */
//    @Test
//    public void testGetCustomerByID() {
//        System.out.println("getCustomerByID");
//         EntityManagerFactory _emf = Persistence.createEntityManagerFactory("pu");
//        BankFacade bf = BankFacade.getFacadeExample(_emf);
//        Long id = 3L;
//       
//        String expResult = "bill billington";
//        String result = bf.getCustomerByID(id).getFullName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
//
//    /**
//     * Test of getCustomerByName method, of class BankFacade.
//     */
//    @Test
//    public void testGetCustomerByName() {
//        System.out.println("getCustomerByName");
//         EntityManagerFactory _emf = Persistence.createEntityManagerFactory("putest");
//        BankFacade bf = BankFacade.getFacadeExample(_emf);
//        String name = "bill";
//        String expResult = "bill billington";
//        String result = bf.getCustomerByName(name).get(0).getFullName();
//        assertEquals(expResult, result);
//        
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of addCustomer method, of class BankFacade.
//     */
//    @Test
//    public void testAddCustomer() {
//        EntityManagerFactory _emf = Persistence.createEntityManagerFactory("pu");
//        BankFacade bf = BankFacade.getFacadeExample(_emf);
//        
//        String expResult = "1111 111111211";
//        BankCustomer b = bf.addCustomer(new BankCustomer("test", "person", "1111 111111211", 32.3, "nice dummy person"));
//        String  result= bf.getCustomerByName("test").get(0).getAccountNumber();
//        bf.deleteCust(b);
//        assertEquals(expResult, result);
//        
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
//
//    /**
//     * Test of getAllBankCustomers method, of class BankFacade.
//     */
//    @Test
//    public void testGetAllBankCustomers() {
//        System.out.println("getAllBankCustomers");
//        EntityManagerFactory _emf = Persistence.createEntityManagerFactory("putest");
//        BankFacade bf = BankFacade.getFacadeExample(_emf);
//        
//        int expResult = 8;
//        int result = bf.getAllBankCustomers().size();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//    
//}
