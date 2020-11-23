/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salahuddin_ayubi.titlemanager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import salahuddin_ayubi.configs.EntityManagerUtil;
import salahuddin_ayubi.model.Advertisement;
import salahuddin_ayubi.model.Title;

/**
 *
 * @author Dell-3460
 */
public class Persistence_TitleManager
    {

    public String titleManager_dao_save_Titles(Title title_to_save)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        try
          {
            entityManager_local.getTransaction().begin();
//            entityManager_local.merge(title_to_save);
            title_to_save.setId(entityManager_local.merge(title_to_save).getId());
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\nError in Title Insertion.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            entityManager_local.detach(title_to_save);
            status = "500";//means fail.
          }
        System.out.println(title_to_save);
        return status;
        }

    public List titleManager_dao_readAll_Titles()
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List<Title> list_titles = null;
        try
          {
            entityManager_local.getTransaction().begin();
            
            TypedQuery query = entityManager_local.createQuery("SELECT t FROM Title t", Title.class);
            list_titles = query.getResultList();

            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\n Error in Get all Title.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return list_titles;
        }

   public Title read_Title_byId(Long title_id_to_edit)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        Title title = null;
        try
          {
            entityManager_local.getTransaction().begin();
            title = entityManager_local.find(Title.class, title_id_to_edit);
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } catch (Exception e)
          {
            System.out.println("\n\n\nError in Title read.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return title;
        }

    String titleManager_dao_save_Edited_Titles(Title title_ToSave_afterEdit)
        {
            System.out.println("\n"+title_ToSave_afterEdit+"\n");
            String status = null;
            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
            try
              {
                entityManager_local.getTransaction().begin();
                entityManager_local.merge(title_ToSave_afterEdit);
                entityManager_local.getTransaction().commit();
                status = "200";//means ok
              } 
            catch (Exception e)
              {
                System.out.println("\n\n\nError in Title Insertion.");
                e.printStackTrace();
                System.out.println("\n\n\n");
                entityManager_local.getTransaction().rollback();
//                entityManager_local.detach(title_to_save);
                status = "500";//means fail.
              }
            return status;
        }

    public String titleManager_dao_delete_Titles(Long title_id_to_delete)
        {
            String status = null;
            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
            try
              {
                Title title_to_remove = entityManager_local.find(Title.class, title_id_to_delete);
                entityManager_local.getTransaction().begin();
                entityManager_local.remove(title_to_remove);
                entityManager_local.getTransaction().commit();
                status = "200";//means ok
              } 
            catch (Exception e)
              {
                System.out.println("\n\n\nError in Title Delete.");
                e.printStackTrace();
                System.out.println("\n\n\n");
                entityManager_local.getTransaction().rollback();
                status = "500";//means fail.
              }
            return status;
        }

    }
