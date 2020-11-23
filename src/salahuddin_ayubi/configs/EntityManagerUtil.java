
package salahuddin_ayubi.configs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil
    {
        public static EntityManagerFactory entityManagerFactory = null;// = Persistence.createEntityManagerFactory("JPA_oneToManyPU");
        public static EntityManager entityManager = null;// = emf.createEntityManager();
        public static EntityManager getEntityManager()
            {
                if( entityManager == null )
                  {
                    entityManagerFactory = Persistence.createEntityManagerFactory("Salahuddin_AyubiPU");
                    entityManager = entityManagerFactory.createEntityManager();
                  }
                return entityManager;
            }
        public static void closeEntityManager()
            {
                entityManager.close();
                entityManagerFactory.close();
            }
        
    }
