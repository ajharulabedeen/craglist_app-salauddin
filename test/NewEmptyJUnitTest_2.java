/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import salahuddin_ayubi.model.Title;
import salahuddin_ayubi.titlemanager.Persistence_TitleManager;

/**
 *
 * @author Dell-3460
 */
public class NewEmptyJUnitTest_2
    {

    public NewEmptyJUnitTest_2()
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
        }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
    public void hello()
        {
            Persistence_TitleManager persistence_TitleManager = new Persistence_TitleManager();
            List l = persistence_TitleManager.titleManager_dao_readAll_Titles();
            System.out.println("L : " + l.size());
            for (Iterator iterator = persistence_TitleManager.titleManager_dao_readAll_Titles().iterator(); iterator.hasNext();)
              {
                Title t = (Title) iterator.next();
                System.out.println(t.toString());
                System.out.println("\n<------------------------------------------------------------------------------------------>\n");
              }
        }
    
    }
