package salahuddin_ayubi.titlemanager;

import java.sql.Clob;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import salahuddin_ayubi.FXMLDocumentController;
import salahuddin_ayubi.configs.DateUtil;
import salahuddin_ayubi.configs.DialogesUtil;
import salahuddin_ayubi.model.Advertisement;
import salahuddin_ayubi.model.Advertisement_Table;
import salahuddin_ayubi.model.Title;
import salahuddin_ayubi.model.Title_Table;

public class Controler_TitleManager
    {

    FXMLDocumentController controller;
    Persistence_TitleManager persistence_TitleManager = new Persistence_TitleManager();
    ObservableList<Title_Table> listForTable_Title = FXCollections.observableArrayList();

    Long id_to_edit = -1l;
    boolean edit_State = false;

    public Controler_TitleManager()
        {

        }

    public Controler_TitleManager(FXMLDocumentController fXMLDocumentController)
        {
        this.controller = fXMLDocumentController;
        }//public Controler_TitleManager(FXMLDocumentController fXMLDocumentController)

    public void titleManager_save_title_button_action(ActionEvent event)
        {
        Title title_ToSave = private_titleManager_making_titleObject();
        String status = persistence_TitleManager.titleManager_dao_save_Titles(title_ToSave);
        if (status.equals("200"))
          {
            //wrong, have to take Title Manager CheckBox.
            if (controller.getTitleManager_confirmation().isSelected())
              {
                DialogesUtil.conformation("Title Saved");
              }
            Title_Table title_Table = new Title_Table(title_ToSave.getId(), title_ToSave.getTitle_description(), title_ToSave.getTitle_catagory(), title_ToSave.getDate());
            listForTable_Title.add(title_Table);
            controller.getTitles_table().setItems(listForTable_Title);
          }
        if (status.equals("500"))
          {
            if (controller.getTitleManager_confirmation().isSelected())
              {
                DialogesUtil.error(" Title Save fail");
              }
          }
        }//public void titleManager_save_title_button_action(ActionEvent event)

    public void titleManager_refresh_title_button_action(ActionEvent event)
        {
        listForTable_Title.clear();
        for (Iterator<Title> iterator = persistence_TitleManager.titleManager_dao_readAll_Titles().iterator(); iterator.hasNext();)
          {
            Title t = (Title) iterator.next();
            Title_Table title_Table = new Title_Table(t.getId(), t.getTitle_description(), t.getTitle_catagory(), t.getDate());
            listForTable_Title.add(title_Table);
          }
        controller.getTitles_table().setItems(listForTable_Title);
        }//public void titleManager_refresh_title_button_action(ActionEvent event)

    public void titleManager_edit_title_button_action(ActionEvent event)
        {
        try
          {
            id_to_edit = controller.getTitles_table().getSelectionModel().getSelectedItem().getId();
            int selected_id_titleTable = controller.getTitles_table().getSelectionModel().getSelectedIndex();
            fill_all_fields(persistence_TitleManager.read_Title_byId(id_to_edit));
            listForTable_Title.remove(selected_id_titleTable).toString();
            //reverse the save and edit.
            controller.getTitleManager_button_edit_save().setVisible(true);
            controller.getTitleManager_button_save().setVisible(false);
          } catch (Exception e)
          {
            DialogesUtil.warning("Please Slelect a item first..!");
          }
        }//public void titleManager_edit_title_button_action(ActionEvent event)

    public void titleManager_edit_save_title_button_action(ActionEvent event)
        {
        //reverse the save and edit.
        controller.getTitleManager_button_edit_save().setVisible(false);
        controller.getTitleManager_button_save().setVisible(true);

        Title title_ToSave_afterEdit = private_titleManager_making_titleObject();
        title_ToSave_afterEdit.setId(new Long(id_to_edit));
        System.out.println("\n\n title_ToSave_afterEdit :" + title_ToSave_afterEdit);

        String status = persistence_TitleManager.titleManager_dao_save_Edited_Titles(title_ToSave_afterEdit);
        if (status.equals("200"))
          {
            //wrong, have to take Title Manager CheckBox.
            if (controller.getTitleManager_confirmation().isSelected())
              {
                DialogesUtil.conformation("Title Saved");
              }
            Title_Table title_Table = new Title_Table(title_ToSave_afterEdit.getId(), title_ToSave_afterEdit.getTitle_description(), title_ToSave_afterEdit.getTitle_catagory(), title_ToSave_afterEdit.getDate());
            listForTable_Title.add(title_Table);
            controller.getTitles_table().setItems(listForTable_Title);
          }
        if (status.equals("500"))
          {
            if (controller.getTitleManager_confirmation().isSelected())
              {
                DialogesUtil.error(" Title Save fail");
              }
          }

        id_to_edit = -1l;
        }//public void titleManager_edit_save_title_button_action(ActionEvent event)

    public void titleManager_delete_title_button_action(ActionEvent event)
        {
            try
              {
                Long id_to_delete = controller.getTitles_table().getSelectionModel().getSelectedItem().getId();
                int selected_Index = controller.getTitles_table().getSelectionModel().getSelectedIndex();
                String status = persistence_TitleManager.titleManager_dao_delete_Titles(id_to_delete);

                if (status.equals("200"))
                  {
                    if (controller.getTitleManager_confirmation().isSelected())
                      {
                        DialogesUtil.conformation("Titles Deleted");
                      }
                    listForTable_Title.remove(selected_Index);
                  }
                if (status.equals("500"))
                  {
                    if (controller.getTitleManager_confirmation().isSelected())
                      {
                        DialogesUtil.conformation("Title Delete fails");
                      }
                  }//if
              } //try
            catch (Exception e)
              {
                DialogesUtil.warning("Please Slelect a item first..!");
              }
        }//public void titleManager_delete_title_button_action(ActionEvent event)

    public void titleManager_clear_button_action(ActionEvent event)
        {
         private_titleManager_clear_();
        }
    
//    start : private area
    private Title private_titleManager_making_titleObject()
        {
        String catagory = controller.getTitleManager_textField_catagory().getText().toString();
        String title = controller.getTitleManager_textArea_title().getText().toString();
        String date = DateUtil.getDate();
        return new Title(catagory, title, date);
        }

    private void private_titleManager_clear_()
        {
        controller.getTitleManager_textField_catagory().setText("");
        controller.getTitleManager_textArea_title().setText("");
        }

    private void fill_all_fields(Title t)
        {
        controller.getTitleManager_textField_catagory().setText(t.getTitle_catagory());
        controller.getTitleManager_textArea_title().setText(t.getTitle_description());
        }
//    End : private area

    }
