package salahuddin_ayubi.addmanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import salahuddin_ayubi.FXMLDocumentController;
import salahuddin_ayubi.bodymanager.Persistence_BodyManager;
import salahuddin_ayubi.configs.DateUtil;
import salahuddin_ayubi.configs.DialogesUtil;
import salahuddin_ayubi.model.Advertisement;
import salahuddin_ayubi.model.Advertisement_Table;
import salahuddin_ayubi.model.Body;
import salahuddin_ayubi.model.Generate_Table;
import salahuddin_ayubi.model.Title;
import salahuddin_ayubi.titlemanager.Persistence_TitleManager;

public class Addmanager_Controller
    {

    FXMLDocumentController controller;
    Addmanager_Persistence_Impl addmanager_Persistence_Impl = new Addmanager_Persistence_Impl();
    ObservableList<Advertisement_Table> listForTable_totalWordsFound = FXCollections.observableArrayList();
    //will hold a list of city, for these list of city have generate adds.
    ObservableList<Generate_Table> listForTable_Generate_Table = FXCollections.observableArrayList();

    int generate_table_index = 0;

    public Addmanager_Controller(FXMLDocumentController fXMLDocumentController)
        {
        this.controller = fXMLDocumentController;
        controller.getAdvertisement_generation_table().setItems(listForTable_Generate_Table);
        }

    public void advertisement_save_advertisement_button_action(ActionEvent event)
        {
        String status = addmanager_Persistence_Impl.save_Advertisement(making_AdvertiseMentObject());

        if (status.equals("200"))
          {
            if (controller.getAdvertisement_confirmation().isSelected())
              {
                DialogesUtil.conformation("Advertisement Saved");
              }
            //refactor, have to do.
            Advertisement a = making_AdvertiseMentObject();
            Advertisement_Table advertisement_Table
                    = new Advertisement_Table(a.getId(), a.getState(), a.getCity(), a.getZipcode(), a.getProgram(), a.getPhone(), a.getUrl(), a.getCatagory(), a.getDate());
            listForTable_totalWordsFound.add(advertisement_Table);
          }
        if (status.equals("500"))
          {
            if (controller.getAdvertisement_confirmation().isSelected())
              {
                DialogesUtil.error("Advertisement Save fail");
              }
          }
        }//public void advertisement_save_advertisement_button_action(ActionEvent event)

    public void advertisement_delete_advertisement_button_action(ActionEvent event)
        {
        try
          {
            Long id_to_delete = controller.getAdvertisements_table().getSelectionModel().getSelectedItem().getId();
            int selected_Index = controller.getAdvertisements_table().getSelectionModel().getSelectedIndex();
            String status = addmanager_Persistence_Impl.delete_Advertisement(id_to_delete);

            if (status.equals("200"))
              {
                if (controller.getAdvertisement_confirmation().isSelected())
                  {
                    DialogesUtil.conformation("Advertisement Deleted");
                  }
                listForTable_totalWordsFound.remove(selected_Index);
              }
            if (status.equals("500"))
              {
                if (controller.getAdvertisement_confirmation().isSelected())
                  {
                    DialogesUtil.conformation("Advertisement Delete fails");
                  }
              }//if
          } //try
        catch (Exception e)
          {
            DialogesUtil.warning("Please Slelect a item first..!");
          }

        }//public void advertisement_delete_advertisement_button_action(ActionEvent event)

    public void advertisement_refresh_advertisement_button_action(ActionEvent event)
        {
        listForTable_totalWordsFound.clear();
        List list_all_advertisements = addmanager_Persistence_Impl.readAll_Advertisement();
        for (Iterator iterator = list_all_advertisements.iterator(); iterator.hasNext();)
          {
            Advertisement a = (Advertisement) iterator.next();
            Advertisement_Table advertisement_Table
                    = new Advertisement_Table(a.getId(), a.getState(), a.getCity(), a.getZipcode(), a.getProgram(), a.getPhone(), a.getUrl(), a.getCatagory(), a.getDate());
            listForTable_totalWordsFound.add(advertisement_Table);
          }
        controller.getAdvertisements_table().setItems(listForTable_totalWordsFound);
        }//public void advertisement_refresh_advertisement_button_action(ActionEvent event)

    public void clear_advertisement_button_action(ActionEvent event)
        {
        all_fieldClear();
        }

    public void edit_advertisement_button_action(ActionEvent event)
        {
        try
          {
            Long id_to_edit = controller.getAdvertisements_table().getSelectionModel().getSelectedItem().getId();
            int selected_Index = controller.getAdvertisements_table().getSelectionModel().getSelectedIndex();
            fill_all_fields(addmanager_Persistence_Impl.read_Advertisement_byId(id_to_edit));
            listForTable_totalWordsFound.remove(selected_Index).toString();
          } catch (Exception e)
          {
            DialogesUtil.warning("Please Slelect a item first..!");
          }
        }//public void edit_advertisement_button_action(ActionEvent event)

    public void cityManager_city_table_mouse_double_click_action(MouseEvent mouseEvent)
        {
        if (mouseEvent.getClickCount() == 2)
          {
            if (controller.getAdvertisement_generate_textField_number_of_ads().getText().toString().isEmpty())
              {
                DialogesUtil.error("Please Enter the addvertisement Number...!");
              }//if(controller.getAdvertisement_generate_textField_number_of_ads().getText().toString().isEmpty())
            else
              {
                Advertisement_Table city_to_generate_add = controller.getAdvertisements_table().getSelectionModel().getSelectedItem();

                if (private_duplicateCity_check_in_genreationTable(city_to_generate_add.getCity()))
                  {
                    DialogesUtil.error("U have already Added it...!");
                  } else
                  {
                    if (controller.getAdvertisement_generate_CheckBox_auto_add().isSelected())
                      {
                        generate_table_index++;
                        Generate_Table generate_Table = new Generate_Table(
                                generate_table_index,
                                Long.toString(city_to_generate_add.getId()),
                                controller.getAdvertisement_generate_textField_number_of_ads().getText().toString(),
                                city_to_generate_add.getCatagory());
                        listForTable_Generate_Table.add(generate_Table);
                      }//if( controller.getAdvertisement_generate_CheckBox_auto_add().isSelected() )
                    else
                      {
                        controller.getAdvertisement_generate_textField_catagoty().setText(city_to_generate_add.getCatagory());
                        controller.getAdvertisement_generate_textField_city_id().setText(city_to_generate_add.getCity());
                      }// else of [---if (controller.getAdvertisement_generate_CheckBox_auto_add().isSelected())---]
                  }//else [--- if(private_duplicateCity_check_in_genreationTable(city_to_generate_add.getCity())) ---]
              }//else of [--- if(controller.getAdvertisement_generate_textField_number_of_ads().getText().toString().isEmpty()) ---]
          }//if (mouseEvent.getClickCount() == 2)
        }//public void cityManager_city_table_mouse_double_click_action(MouseEvent mouseEvent)

    public void clear_advertisement_generator_clear_button_action(ActionEvent event)
        {
        listForTable_Generate_Table.clear();
        generate_table_index = 0;
        }

    public void delete_advertisement_generator_clear_button_action(ActionEvent event)
        {
        try
          {
            Generate_Table generate_Table = controller.getAdvertisement_generation_table().getSelectionModel().getSelectedItem();
            listForTable_Generate_Table.remove(generate_Table);
            controller.getAdvertisement_generation_table().getSelectionModel().clearSelection();
          } catch (Exception e)
          {
            DialogesUtil.error("Please Select An Item First...!");
          }

        }//public void delete_advertisement_generator_clear_button_action(ActionEvent event)

    public void add_advertisement_generator_clear_button_action(ActionEvent event)
        {
        if (controller.getAdvertisement_generate_textField_city_id().getText().toString().isEmpty()
                | controller.getAdvertisement_generate_textField_number_of_ads().getText().toString().isEmpty()
                | controller.getAdvertisement_generate_textField_catagoty().getText().toString().isEmpty())
          {
            DialogesUtil.error("Please Fill all the Fields...!");
          } else
          {
            if (private_duplicateCity_check_in_genreationTable(controller.getAdvertisement_generate_textField_city_id().getText().toString()))
              {
                DialogesUtil.error("U already added this city..!");
              } else
              {
                generate_table_index++;
                Generate_Table generate_Table = new Generate_Table(
                        generate_table_index,
                        controller.getAdvertisement_generate_textField_city_id().getText().toString(),
                        controller.getAdvertisement_generate_textField_number_of_ads().getText().toString(),
                        controller.getAdvertisement_generate_textField_catagoty().getText().toString());

                listForTable_Generate_Table.add(generate_Table);
              }
          }
        }//public void add_advertisement_generator_clear_button_action(ActionEvent event)

    public void export_advertisement_generator_clear_button_action(ActionEvent event) throws Exception
        {
        File selectedDirectory = null;
        String fileName_with_path = null;

        try
          {
            DirectoryChooser fc = new DirectoryChooser();
            selectedDirectory = fc.showDialog(null);
            if (selectedDirectory != null)
              {
                File file = new File(selectedDirectory.getAbsolutePath().toString() + "Date_" + DateUtil.getDateForDirectory() + ".txt");
                file.createNewFile();
                fileName_with_path = file.getAbsolutePath();
              } else
              {
                System.out.println("Error in Chosing Folder...!");
              }
          } catch (Exception e)
          {
            e.printStackTrace();
          }

        if (selectedDirectory == null)
          {
            DialogesUtil.warning("Please Select a folder location..!");
          } else
          {
            System.out.println(" fileName_with_path : " + fileName_with_path);
            private_generate_adds_for_city(fileName_with_path);
          }//else [--- if(selectedDirectory == null) ---]
        }//public void export_advertisement_generator_clear_button_action(ActionEvent event)

    public void search_textField_key_realsed_action(KeyEvent keyEvent)
        {
        String searchKey = controller.getCity_manager_textField_search().getText().toString();
        if (controller.getCity_manager_radioButton_catagory().isSelected())
          {
            listForTable_totalWordsFound.clear();
            List list_all_advertisements = addmanager_Persistence_Impl.readAll_Advertisement_byCatagory(searchKey);
            for (Iterator iterator = list_all_advertisements.iterator(); iterator.hasNext();)
              {
                Advertisement a = (Advertisement) iterator.next();
                Advertisement_Table advertisement_Table
                        = new Advertisement_Table(a.getId(), a.getState(), a.getCity(), a.getZipcode(), a.getProgram(), a.getPhone(), a.getUrl(), a.getCatagory(), a.getDate());
                listForTable_totalWordsFound.add(advertisement_Table);
              }
            controller.getAdvertisements_table().setItems(listForTable_totalWordsFound);
          }//if(controller.getCity_manager_radioButton_catagory().isSelected())
        if (controller.getCity_manager_radioButton_city().isSelected())
          {
            listForTable_totalWordsFound.clear();
            List list_all_advertisements = addmanager_Persistence_Impl.readAll_Advertisement_byCity(searchKey);
            for (Iterator iterator = list_all_advertisements.iterator(); iterator.hasNext();)
              {
                Advertisement a = (Advertisement) iterator.next();
                Advertisement_Table advertisement_Table
                        = new Advertisement_Table(a.getId(), a.getState(), a.getCity(), a.getZipcode(), a.getProgram(), a.getPhone(), a.getUrl(), a.getCatagory(), a.getDate());
                listForTable_totalWordsFound.add(advertisement_Table);
              }
            controller.getAdvertisements_table().setItems(listForTable_totalWordsFound);
          }//if(controller.getCity_manager_radioButton_city().isSelected())
        }
//    Start : private area 

    private void private_generate_adds_for_city(String fileName)
        {

        int count_city_for_add = 0;
        
        System.out.println("\n\n private_generate_adds_for_city : fileName : " + fileName);

        Random obj_randomGenerator = new Random();
        Persistence_TitleManager persistence_TitleManager = new Persistence_TitleManager();
        Persistence_BodyManager persistence_BodyManager = new Persistence_BodyManager();
        Addmanager_Persistence_Impl addmanager_Persistence_Impl = new Addmanager_Persistence_Impl();

        // Not Efficicant in Space complexity and costly cause due to every time hiting DB. Can be reduced by Caching technipue.
        
        //for.1
        for (Iterator<Generate_Table> iterator = listForTable_Generate_Table.iterator(); iterator.hasNext();)
          {
            count_city_for_add++;
            
            Generate_Table generate_Table = iterator.next();
            int number_of_add_have_to_generate = Integer.parseInt(generate_Table.getNumber_of_add());

            //Test
            System.out.println(" generate_Table : " + generate_Table.toString());

            Long advertisement_id = Long.parseLong(generate_Table.getCity_id());
            //Test
            System.out.println("\n\n Long advertisement_id = Long.parseLong(generate_Table.getCity_id()); :"+advertisement_id);
            Advertisement advertisement = addmanager_Persistence_Impl.read_Advertisement_byId(advertisement_id);
            
            //Test
            System.out.println(" advertisement_id : " + advertisement_id);
            System.out.println(" advertisement : " + advertisement.toString());
            //Test

            String count_city_string = Integer.toString(count_city_for_add);
            String hipens = "\n\n\n\n"+count_city_string+"-------------------------------------------\n\n";
            private_write_Add_Data_to_file(fileName, hipens + advertisement.toString());

            // Problem Point.
            List list_total_id_list_title = addmanager_Persistence_Impl.getTotal_Title_id_List(generate_Table.getCatagory());
            List list_total_id_list_body = addmanager_Persistence_Impl.getTotal_Body_id_List(generate_Table.getCatagory());
            
            //Test
            System.out.println("list_total_id_list_title : "+list_total_id_list_title.size());
            System.out.println("list_total_id_list_body : "+list_total_id_list_body.size());
            //Test
            
//  Start : ...........test            
//            System.out.println("Body : ");
//              for (Object object : list_total_id_list_body)
//                {
//                    System.out.println(object);
//                }
//                System.out.println("Title: ");
//              for (Object object : list_total_id_list_title)
//                {
//                    System.out.println(object);
//                }
//  End : .............test            
//..............................>>>>>>>>    Start : nCr Selection Code <<<<<<<<...................................
            //for 1 >--->> Through List Title
//                more body items than title items.
            if (list_total_id_list_body.size() >= list_total_id_list_title.size())
              {
                System.out.println("if (list_total_id_list_body.size() >= list_total_id_list_title.size())");
                int generatedAddCount = 0;
                
                //Test
                int innerLoopCount = 0;
                //1
                boolean completed = false;
                for (Iterator iteratorBody = list_total_id_list_body.iterator(); iteratorBody.hasNext();)
                  {
                    innerLoopCount++;
//                    System.out.println(" innerLoopCount :"+innerLoopCount);
                    
//                    //Test
//                      System.out.println("\n\ngeneratedAddCount++ : "+generatedAddCount+"....."+number_of_add_have_to_generate+"\n\n");
                    Object nextBody = iteratorBody.next();
                    System.out.println(">>>>> : "+nextBody.toString());
                    
                    if(completed ==false)
                      {
                          //1.2
                          for (Iterator iteratorTitle = list_total_id_list_title.iterator(); iteratorTitle.hasNext();)
//                    for (int x = 0; x< list_total_id_list_title.size(); x++)
                            {
                              generatedAddCount++;
                              Object nextTitle = iteratorTitle.next();
                              System.out.println("------------ : " + nextTitle.toString());

                              Long title_id_to_raed_from_db = Long.parseLong(nextTitle.toString().toString());
//                        Long title_id_to_raed_from_db = Long.parseLong(nextTitle.toString().toString());
                              Long body_id_to_raed_from_db = Long.parseLong(nextBody.toString());
//
                              Title title = persistence_TitleManager.read_Title_byId(title_id_to_raed_from_db);
                              Body body = persistence_BodyManager.read_Body_byId(body_id_to_raed_from_db);
//
                              String genereted_add_title = title.getTitle_description();
                              String genereted_add_body = body.getBody_description();
//
                              String generated_add_index = count_city_string + "." + Integer.toString(generatedAddCount);
                              String formated_add_string = "\n\n" + generated_add_index + "   Title : " + genereted_add_title + "\n" + "Body : " + genereted_add_body;
//                        
//                        //Test
////                        System.out.println(" formated_add_string : "+formated_add_string); 
//                        
                              private_write_Add_Data_to_file(fileName, formated_add_string);
//                        
                              if (generatedAddCount == number_of_add_have_to_generate)
                                {
                                  System.out.println("Before Break : \n");
                                  System.out.println("generatedAddCount : \n" + generatedAddCount);
                                  System.out.println("number_of_add_have_to_generate : \n" + number_of_add_have_to_generate);
                                  completed = true;
                                  break;
                                }
                            }// For 1.2 :  for (Iterator iteratorTitle = list_total_id_list_title.iterator(); iteratorTitle.hasNext();)
                      }//if(completed ==false)
                  }//for 1 : for (Iterator iteratorBody = list_total_id_list_body.iterator(); iteratorBody.hasNext();)
                if(number_of_add_have_to_generate > generatedAddCount)
                  {
                      String dataSortageMessage = "\n\n*****Sorry, Requested amount of adds can not be generated due to sortage of data. ";
                      String rquested_amount = "\nRequested : "+Integer.toString(number_of_add_have_to_generate);
                      String generated_amount = "\nGenerated : "+Integer.toString(generatedAddCount);
                      private_write_Add_Data_to_file(fileName, dataSortageMessage+rquested_amount+generated_amount);
                  }
              }//if (list_total_id_list_body.size() >= list_total_id_list_title.size())
//                more title items than body items.

//.........................................................................................

//                more Title items than Body items.
            if (list_total_id_list_title.size() > list_total_id_list_body.size())
              {
                System.out.println("if (list_total_id_list_body.size() >= list_total_id_list_title.size())");
                int generatedAddCount = 0;
                
                //Test
                int innerLoopCount = 0;
                //1
                boolean completed = false;
                for (Iterator iteratorTitle = list_total_id_list_title.iterator(); iteratorTitle.hasNext();)
                  {
                    innerLoopCount++;
//                    System.out.println(" innerLoopCount :"+innerLoopCount);
                    
//                    //Test
//                      System.out.println("\n\ngeneratedAddCount++ : "+generatedAddCount+"....."+number_of_add_have_to_generate+"\n\n");
                    Object nextTitle = iteratorTitle.next();
                    System.out.println(">>>>> : "+nextTitle.toString());
                    
                    if(completed ==false)
                      {
                          //1.2
                          for (Iterator iteratorBody = list_total_id_list_body.iterator(); iteratorBody.hasNext();)
//                    for (int x = 0; x< list_total_id_list_title.size(); x++)
                            {
                              generatedAddCount++;
                              Object nextBody = iteratorBody.next();
                              System.out.println("------------ : " + nextBody.toString());

                              Long title_id_to_raed_from_db = Long.parseLong(nextBody.toString().toString());
//                        Long title_id_to_raed_from_db = Long.parseLong(nextTitle.toString().toString());
                              Long body_id_to_raed_from_db = Long.parseLong(nextBody.toString());
//
                              Title title = persistence_TitleManager.read_Title_byId(title_id_to_raed_from_db);
                              Body body = persistence_BodyManager.read_Body_byId(body_id_to_raed_from_db);
//
                              String genereted_add_title = title.getTitle_description();
                              String genereted_add_body = body.getBody_description();
//
                              String generated_add_index = count_city_string + "." + Integer.toString(generatedAddCount);
                              String formated_add_string = "\n\n" + generated_add_index + "   Title : " + genereted_add_title + "\n" + "Body : " + genereted_add_body;
//                        
//                        //Test
////                        System.out.println(" formated_add_string : "+formated_add_string); 
//                        
                              private_write_Add_Data_to_file(fileName, formated_add_string);
//                        
                              if (generatedAddCount == number_of_add_have_to_generate)
                                {
                                  System.out.println("Before Break : \n");
                                  System.out.println("generatedAddCount : \n" + generatedAddCount);
                                  System.out.println("number_of_add_have_to_generate : \n" + number_of_add_have_to_generate);
                                  completed = true;
                                  break;
                                }
                            }// For 1.2 :  for (Iterator iteratorTitle = list_total_id_list_title.iterator(); iteratorTitle.hasNext();)
                      }//if(completed ==false)
                  }//for 1 : for (Iterator iteratorBody = list_total_id_list_body.iterator(); iteratorBody.hasNext();)
                if(number_of_add_have_to_generate > generatedAddCount)
                  {
                      String dataSortageMessage = "\n\n*****Sorry, Requested amount of adds can not be generated due to sortage of data. ";
                      String rquested_amount = "\nRequested : "+Integer.toString(number_of_add_have_to_generate);
                      String generated_amount = "\nGenerated : "+Integer.toString(generatedAddCount);
                      private_write_Add_Data_to_file(fileName, dataSortageMessage+rquested_amount+generated_amount);
                  }
              }//if (list_total_id_list_body.size() >= list_total_id_list_title.size())
//                more title items than body items.



//..............................>>>>>>>>    End : nCr Selection Code <<<<<<<<...................................

//..............................>>>>>>>>    Start : Random Selection Code <<<<<<<<...................................
//            //for 1.2
//            for (int i = 0; i < Integer.parseInt(generate_Table.getNumber_of_add()); i++)
//              {
//                int random_title_list_index = obj_randomGenerator.nextInt(list_total_id_list_title.size());
//                int random_body_list_index = obj_randomGenerator.nextInt(list_total_id_list_body.size());
//
////                  System.out.println(" random_title_list_index : "+random_title_list_index);
////                  System.out.println(" random_body_list_index : "+random_body_list_index);
//                
//                String titleId = list_total_id_list_title.get(random_title_list_index).toString();
//                
//                Long title_id_to_raed_from_db = Long.parseLong(list_total_id_list_title.get(random_title_list_index).toString());
//                Long body_id_to_raed_from_db = Long.parseLong(list_total_id_list_body.get(random_body_list_index).toString());
//
//                Title title = persistence_TitleManager.read_Title_byId(title_id_to_raed_from_db);
//                Body body = persistence_BodyManager.read_Body_byId(body_id_to_raed_from_db);
//                
////                  System.out.println(" title_id_to_raed_from_db :  "+title_id_to_raed_from_db);
////                  System.out.println(" title : "+title);
//                
//                String genereted_add_title = title.getTitle_description();
//                String genereted_add_body = body.getBody_description();
//                
//                String formated_add_string = "\n\n"+"Title : "+genereted_add_title+"\n"+"Body : "+genereted_add_body;
//                
//                private_write_Add_Data_to_file(fileName, formated_add_string);
//                
////                list_total_id_list_body.remove(random_body_list_index);
////                list_total_id_list_title.remove(random_title_list_index);
//              }//for 1.2 (int i = 0; i < Integer.parseInt(generate_Table.getNumber_of_add());  i++)
//...............................>>>>>>>> End : Random Selection Code <<<<<<...................................
          }//for.1 (Iterator<Generate_Table> iterator = listForTable_Generate_Table.iterator(); iterator.hasNext();)

        
        
        }//method : private void private_generate_adds_for_city()

    private void private_write_Add_Data_to_file(String fileName, String data)
        {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        //try 1
        try
          {
            File file = new File(fileName);
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.write("\n----->>>>>>>>>");
          } //try 1
        catch (IOException e)
          {
            e.printStackTrace();
          } //catch 1
        finally
          {
            //try 1.2
            try
              {
                if (bufferedWriter != null)
                  {
                    bufferedWriter.close();
                  }
                if (fileWriter != null)
                  {
                    fileWriter.close();
                  }
              } //try 1.2
            catch (IOException ex)
              {
                ex.printStackTrace();
              }//cath
          }//finally 1

        }//end method : private void private_write_generetedData(String fileName, String data) 

    private Advertisement making_AdvertiseMentObject()
        {
        Long id = Long.parseLong(controller.getAdvertisement_id().getText().toString());
        String state = controller.getAdvertisement_state().getText().toString();
        String city = controller.getAdvertisement_city().getText().toString();
        String zipcode = controller.getAdvertisement_zipcode().getText().toString();
        String program = controller.getAdvertisement_program().getText().toString();
        String phone = controller.getAdvertisement_phone().getText().toString();
        String url = controller.getAdvertisement_url().getText().toString();
        String catagory = controller.getAdvertisement_catagory().getText().toString();
        String date = DateUtil.getDate();
        return new Advertisement(id, state, city, zipcode, program, phone, url, catagory, date);
        }//private Advertisement making_AdvertiseMentObject()

    private void all_fieldClear()
        {
        controller.getAdvertisement_id().setText("");
        controller.getAdvertisement_state().setText("");
        controller.getAdvertisement_city().setText("");
        controller.getAdvertisement_zipcode().setText("");
        controller.getAdvertisement_program().setText("");
        controller.getAdvertisement_phone().setText("");
        controller.getAdvertisement_url().setText("");
        controller.getAdvertisement_catagory().setText("");
        controller.getAdvertisement_id().setEditable(true);
        }//private void all_fieldClear()

    private void fill_all_fields(Advertisement a)
        {
        controller.getAdvertisement_id().setEditable(false);
        controller.getAdvertisement_id().setText(a.getId().toString());
        controller.getAdvertisement_state().setText(a.getState().toString());
        controller.getAdvertisement_city().setText(a.getCity().toString());
        controller.getAdvertisement_zipcode().setText(a.getZipcode().toString());
        controller.getAdvertisement_program().setText(a.getProgram().toString());
        controller.getAdvertisement_phone().setText(a.getPhone().toString());
        controller.getAdvertisement_url().setText(a.getUrl().toString());
        controller.getAdvertisement_catagory().setText(a.getCatagory().toString());
        }//private void fill_all_fields(Advertisement a)

    //this will, are we going to same id again on same seseaon for advertisement generation.
    private boolean private_duplicateCity_check_in_genreationTable(String cityID_toCheck)
        {
        boolean duplicate = false;
        for (Iterator<Generate_Table> iterator = listForTable_Generate_Table.iterator(); iterator.hasNext();)
          {
            Generate_Table generate_Table = iterator.next();
            if (generate_Table.getCity_id().equals(cityID_toCheck))
              {
                duplicate = true;
                break;
              }
          }//for (Iterator<Generate_Table> iterator = listForTable_Generate_Table.iterator(); iterator.hasNext();)
        return duplicate = false;
        }//private boolean private_duplicateCity_check_in_genreationTable(String cityID_toCheck)
//    End  : private area 

    }
