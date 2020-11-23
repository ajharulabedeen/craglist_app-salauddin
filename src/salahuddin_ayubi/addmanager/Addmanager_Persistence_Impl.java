package salahuddin_ayubi.addmanager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import salahuddin_ayubi.configs.EntityManagerUtil;
import salahuddin_ayubi.model.Advertisement;
import salahuddin_ayubi.model.Title;

//public class Addmanager_Persistence_Impl implements Addmanager_Persistence_I
public class Addmanager_Persistence_Impl
    {

    public String save_Advertisement(Advertisement advertisement)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        try
          {

            entityManager_local.getTransaction().begin();
//            entityManager_local.persist(advertisement);
            entityManager_local.merge(advertisement);
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } catch (Exception e)
          {
            System.out.println("\n\n\nError in Advertisment Insertion.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            entityManager_local.detach(advertisement);
            status = "500";//means fail.
          }
        return status;
        }//public String save_Advertisement(Advertisement advertisement)

    public Advertisement read_Advertisement_byId(Long advertisementID)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        Advertisement advertisement = null;
        try
          {
            entityManager_local.getTransaction().begin();
            advertisement = entityManager_local.find(Advertisement.class, advertisementID);
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } catch (Exception e)
          {
            System.out.println("\n\n\nError in Advertisment read.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return advertisement;
        }//public Advertisement read_Advertisement_byId(Long advertisementID)

    public String delete_Advertisement(Long advertisementID)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        try
          {
            Advertisement advertisement_to_remove = entityManager_local.find(Advertisement.class, advertisementID);
            entityManager_local.getTransaction().begin();
            entityManager_local.remove(advertisement_to_remove);
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } catch (Exception e)
          {
            System.out.println("\n\n\nError in Advertisment Delete.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return status;
        }//public String delete_Advertisement(Long advertisementID)

    public List readAll_Advertisement()
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List<Advertisement> list_advertisements = null;
        try
          {
            entityManager_local.getTransaction().begin();

            TypedQuery query = entityManager_local.createQuery("SELECT a FROM Advertisement a", Advertisement.class);
            list_advertisements = query.getResultList();

            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } catch (Exception e)
          {
            System.out.println("\n\n\nError in Get all dvertisement.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return list_advertisements;
        }//End method : public List readAll_Advertisement()

    public List getTotal_Title_id_List(String catagory_title)
        {
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List list_total_title_id = null;
        try
          {
            entityManager_local.getTransaction().begin();

            Query query = entityManager_local.createNativeQuery("SELECT title.id FROM title WHERE title.title_catagory=?");
            query.setParameter(1, catagory_title);
            list_total_title_id = query.getResultList();
            entityManager_local.getTransaction().commit();
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\nError in getTotal_Title_id_List.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
          }//try
        return list_total_title_id;
        }//public List getTotal_Title_id_List(String catagory_title)

    public List getTotal_Body_id_List(String catagory_body)
        {
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List list_total_title_id = null;
        try
          {
            entityManager_local.getTransaction().begin();
            Query query = entityManager_local.createNativeQuery("SELECT body.id FROM body WHERE body.body_catagory=?");
            query.setParameter(1, catagory_body);
            list_total_title_id = query.getResultList();
            entityManager_local.getTransaction().commit();
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\nError in getTotal_Body_id_List.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
          }//try
        return list_total_title_id;
        }//public List getTotal_Body_id_List(String catagory_body)

    List readAll_Advertisement_byCatagory(String catagorySearchKey)
        {
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List<Advertisement> list_advertisements = null;
        try
          {
            entityManager_local.getTransaction().begin();

            TypedQuery query = entityManager_local.createQuery("SELECT a FROM Advertisement a WHERE a.catagory LIKE ?", Advertisement.class);
            query.setParameter(1, "%"+catagorySearchKey+"%");
            
            list_advertisements = query.getResultList();

            entityManager_local.getTransaction().commit();
        
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\n Error in Get all advertisement by Catagory.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
         
          }
        return list_advertisements;
        }// End Method : List readAll_Advertisement_byCatagory(String catagorySearchKey)

    List readAll_Advertisement_byCity(String searchKey)
        {
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List<Advertisement> list_advertisements = null;
        try
          {
            entityManager_local.getTransaction().begin();

            TypedQuery query = entityManager_local.createQuery("SELECT a FROM Advertisement a WHERE a.city LIKE ?", Advertisement.class);
            query.setParameter(1, "%"+searchKey+"%");

            list_advertisements = query.getResultList();

            entityManager_local.getTransaction().commit();

          } 
        catch (Exception e)
          {
            System.out.println("\n\n\n Error in Get all advertisement by City.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();

          }
        return list_advertisements;
        }
    }
