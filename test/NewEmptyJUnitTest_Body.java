/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javafx.stage.DirectoryChooser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import salahuddin_ayubi.addmanager.Addmanager_Persistence_Impl;
import salahuddin_ayubi.bodymanager.Persistence_BodyManager;
import salahuddin_ayubi.model.Body;

/**
 *
 * @author Dell-3460
 */
public class NewEmptyJUnitTest_Body
    {

    public NewEmptyJUnitTest_Body()
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
//     @Test
    public void hello()
        {
        Persistence_BodyManager persistence_BodyManager = new Persistence_BodyManager();
        Body body = new Body("body_catagory", "body_description", "date");
        persistence_BodyManager.bodyManager_dao_save_body(body);
        }

//    @Test
    public void fileCreation() throws IOException
        {
//            File file = new File("newfile.txt");
//        File file = new File("D:\\newfile.txt");
//        boolean x = file.createNewFile();
//        System.out.println("X : " + x);

        try
          {
            DirectoryChooser fc = new DirectoryChooser();
            File selectedFile = fc.showDialog(null);
            System.out.println("selectedFile.getAbsolutePath().toString()");
            if (selectedFile != null)
              {
                System.out.println(selectedFile.getAbsolutePath().toString());
              } else
              {
                System.out.println("Error in Chosing Folder...!");
              }
            File file2 = new File(selectedFile.getAbsolutePath().toString() + "myWords.xml");
          } catch (Exception e)
          {
          }

        }//public void fileCreation() throws IOException

    @Test
    public void fileAppend() throws Exception
        {
        BufferedWriter bw = null;
        FileWriter fw = null;
        String FILENAME = "E:\\test\\filename.txt";
        try
          {
            String data = "\n This is new content \n";
            File file = new File(FILENAME);
//            file.createNewFile();

            // if file doesnt exists, then create it
            if (!file.exists())
              {file.createNewFile();}
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("Done");
          } 
        catch (IOException e)
          {e.printStackTrace();} 
        finally
          {
            try
              {
                if (bw != null)
                  {bw.close();}
                if (fw != null) 
                  {fw.close();}
              } 
            catch (IOException ex)  
              { ex.printStackTrace();}
          }//finally
        }// public void fileAppend() throws Exception
    
    @Test
    public void p()
        {
            Addmanager_Persistence_Impl addmanager_Persistence_Impl = new Addmanager_Persistence_Impl();
            List lT = addmanager_Persistence_Impl.getTotal_Title_id_List("event/class");
            List lB = addmanager_Persistence_Impl.getTotal_Body_id_List("event/class");
            for (Iterator iterator = lT.iterator(); iterator.hasNext();)
              {
                Object next = iterator.next();
                  System.out.println(">>>>>>"+next.toString());
                  for (Iterator iterator1 = lB.iterator(); iterator1.hasNext();)
                    {
                      Object next1 = iterator1.next();
                      System.out.println("......"+next1.toString());
                    }// End  : for (Iterator iterator1 = lB.iterator(); iterator1.hasNext();)
              }//End : for (Iterator iterator = lT.iterator(); iterator.hasNext();)
        }//End : public void p()
    }

