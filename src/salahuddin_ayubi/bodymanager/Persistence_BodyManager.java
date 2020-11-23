/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salahuddin_ayubi.bodymanager;

import salahuddin_ayubi.titlemanager.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import salahuddin_ayubi.configs.EntityManagerUtil;
import salahuddin_ayubi.model.Advertisement;
import salahuddin_ayubi.model.Body;
import salahuddin_ayubi.model.Title;

/**
 *
 * @author Dell-3460
 */
public class Persistence_BodyManager
    {

    public String bodyManager_dao_save_body(Body body_to_save)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        try
          {
            entityManager_local.getTransaction().begin();
            body_to_save.setId(entityManager_local.merge(body_to_save).getId());
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\nError in Body Insertion.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            entityManager_local.detach(body_to_save);
            status = "500";//means fail.
          }
        System.out.println(body_to_save);
        return status;
        }//public String bodyManager_dao_save_body(Body body_to_save)

    public List bodyManager_dao_readAll_Bodies()
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        List<Body> list_body = null;
        try
          {
            entityManager_local.getTransaction().begin();
            
            TypedQuery query = entityManager_local.createQuery("SELECT b FROM Body b", Body.class);
            list_body = query.getResultList();

            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\n Error in Get all Body.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return list_body;
        }//public List bodyManager_dao_readAll_Bodies()

   public Body read_Body_byId(Long body_id_to_edit)
        {
        String status = null;
        EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
        Body body = null;
        try
          {
            entityManager_local.getTransaction().begin();
            body = entityManager_local.find(Body.class, body_id_to_edit);
            entityManager_local.getTransaction().commit();
            status = "200";//means ok
          } 
        catch (Exception e)
          {
            System.out.println("\n\n\n Error in Body read.");
            e.printStackTrace();
            System.out.println("\n\n\n");
            entityManager_local.getTransaction().rollback();
            status = "500";//means fail.
          }
        return body;
        }//public Body read_Body_byId(Long body_id_to_edit)
   
    String bodyManager_dao_save_Edited_Body(Body body_ToSave_afterEdit)
        {
            System.out.println("\n"+body_ToSave_afterEdit+"\n");
            String status = null;
            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
            try
              {
                entityManager_local.getTransaction().begin();
                entityManager_local.merge(body_ToSave_afterEdit);
                entityManager_local.getTransaction().commit();
                status = "200";//means ok
              } 
            catch (Exception e)
              {
                System.out.println("\n\n\nError in Body Edit Body.");
                e.printStackTrace();
                System.out.println("\n\n\n");
                entityManager_local.getTransaction().rollback();
//                entityManager_local.detach(title_to_save);
                status = "500";//means fail.
              }
            return status;
        }//String bodyManager_dao_save_Edited_Body(Body body_ToSave_afterEdit)

    public String bodyManager_dao_delete_Body(Long body_id_to_delete)
        {
            String status = null;
            EntityManager entityManager_local = EntityManagerUtil.getEntityManager();
            try
              {
                Body body_to_remove = entityManager_local.find(Body.class, body_id_to_delete);
                entityManager_local.getTransaction().begin();
                entityManager_local.remove(body_to_remove);
                entityManager_local.getTransaction().commit();
                status = "200";//means ok
              } 
            catch (Exception e)
              {
                System.out.println("\n\n\n Error in Body Delete.");
                e.printStackTrace();
                System.out.println("\n\n\n");
                entityManager_local.getTransaction().rollback();
                status = "500";//means fail.
              }
            return status;
        }//public String bodyManager_dao_delete_Body(Long body_id_to_delete)

    }
