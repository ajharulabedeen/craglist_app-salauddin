/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import salahuddin_ayubi.addmanager.Addmanager_Persistence_Impl;
import salahuddin_ayubi.configs.DateUtil;
import salahuddin_ayubi.configs.EntityManagerUtil;
import salahuddin_ayubi.model.Advertisement;
import salahuddin_ayubi.model.Title;
import salahuddin_ayubi.titlemanager.Persistence_TitleManager;

/**
 *
 * @author Dell-3460
 */
public class NewEmptyJUnitTest
    {

    public NewEmptyJUnitTest()
        {
        }

    @BeforeClass
    public static void setUpClass()
        {
        }

    @AfterClass
    public static void tearDownClass()
        {
        }

    @Before
    public void setUp()
        {
        }

    @After
    public void tearDown()
        {
//        EntityManagerUtil.closeEntityManager();
        }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
//    public void hello()
//        {
//        System.out.println("Alhumdulilah..Unit Testing working...!");
//        Advertisement advertisement1
//                = new Advertisement(new Long(2), "CA", "Bakersfield", "93301", "Dental Assisting", "(661) 490-9311", "salaudin.com", "event/class", new Date().toString());
//        Advertisement advertisement2
//                = new Advertisement(new Long(9), "CA", "Bakersfield", "93301", "Dental Assisting", "(661) 490-9311", "salaudin.com", "event/class", new Date().toString());
//        Advertisement advertisement3
//                = new Advertisement(new Long(24), "CA", "Bakersfield", "93301", "Dental Assisting", "(661) 490-9311", "salaudin.com", "event/class", new Date().toString());
//
//        insetAdd(advertisement1);
//        insetAdd(advertisement2);
//        insetAdd(advertisement3);
//        delete(advertisement1);
//        List l = readAll();
//            for (Iterator iterator = l.iterator(); iterator.hasNext();)
//              {
//                Object next = iterator.next();
//                System.out.println(next.toString());
//              }
//        System.out.println(l.get(0).toString());
//        }
//
//    public void insetAdd(Advertisement advertisement)
//        {
//            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
//            entityManager_local.getTransaction().begin();
////            entityManager_local.persist(advertisement);
//            entityManager_local.merge(advertisement);
//            entityManager_local.getTransaction().commit();
//        }
//
//    public void delete(Advertisement advertisement)
//        {
//            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
//            entityManager_local.getTransaction().begin();
//            entityManager_local.remove(advertisement);
//            entityManager_local.getTransaction().commit();
//        }
//
//    public List readAll()
//        {
//            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
//            entityManager_local.getTransaction().begin();
//
//            TypedQuery query = entityManager_local.createQuery("SELECT a FROM Advertisement a", Advertisement.class);
//            List list_advertisements = query.getResultList();
//
//            entityManager_local.getTransaction().commit();
//            
//            return list_advertisements;
//        }
//    @Test
    public void insetTitle()
        {
//            System.out.println("\n\n\n\n..............");
//            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
//            entityManager_local.getTransaction().begin();
//        Title t = new Title(new Long(1), "title_catagory", "title_description", DateUtil.getDate());
        Title t = new Title("title_catagory17++>>>>----", "title_description", DateUtil.getDate());
        t.setId(new Long(17));
            Persistence_TitleManager persistence_TitleManager = new Persistence_TitleManager();
        System.out.println(persistence_TitleManager.titleManager_dao_save_Titles(t));
//        Comment c = new Comment("sasfaf");
//        Title t = new Title("sasfaf");
//        System.out.println(c.toString());
//            entityManager_local.merge(c);
//            entityManager_local.getTransaction().commit();

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Salahuddin_AyubiPU");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        em.persist(t);
//        em.persist(c);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        System.out.println(">>>>>>>>>> : " + t.toString());
//        System.out.println("\n\n Before >>>---: " + t);
//        System.out.println("\n\n >>>---: " + insert(t));
//        System.out.println("\n\n Before >>>---: " + t);
        }

    //This method has done, to test how to get id froma a auto inremented save.
    public Title insert(Title t)
        {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Salahuddin_AyubiPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        Title t2 = em.merge(t);
//        Long id = t2.getId();
//        t.setId(id);
//        t.setId(em.merge(t).getId());
        em.merge(t);
//        System.out.println("id : " + id);
        em.getTransaction().commit();
//        em.close();
//        emf.close();
        return t;
        }
    
    @Test
    public void getIdList()
        {
            Addmanager_Persistence_Impl addmanager_Persistence_Impl = new Addmanager_Persistence_Impl();
            addmanager_Persistence_Impl.getTotal_Title_id_List("234");
        }

    }
