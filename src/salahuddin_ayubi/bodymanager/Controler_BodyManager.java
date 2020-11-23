package salahuddin_ayubi.bodymanager;

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import salahuddin_ayubi.FXMLDocumentController;
import salahuddin_ayubi.configs.DateUtil;
import salahuddin_ayubi.configs.DialogesUtil;
import salahuddin_ayubi.model.Body;
import salahuddin_ayubi.model.Body_Table;
import salahuddin_ayubi.model.Title;
import salahuddin_ayubi.model.Title_Table;

public class Controler_BodyManager
    {

    FXMLDocumentController controller;
    Persistence_BodyManager persistence_BodyManager = new Persistence_BodyManager();
    ObservableList<Body_Table> listForTable_Body = FXCollections.observableArrayList();

    Long id_to_edit = -1l;
    boolean edit_State = false;

    public Controler_BodyManager()
        {

        }

    public Controler_BodyManager(FXMLDocumentController fXMLDocumentController)
        {
        this.controller = fXMLDocumentController;
        }//public Controler_BodyManager(FXMLDocumentController fXMLDocumentController)

    public void bodyManager_save_body_button_action(ActionEvent event)
        {
        Body body_ToSave = private_bodyManager_making_bodyObject();
        String status = persistence_BodyManager.bodyManager_dao_save_body(body_ToSave);
        if (status.equals("200"))
          {
            //wrong, have to take Title Manager CheckBox.
            if (controller.getBodyManager_checkBox_showNotification().isSelected())
              {
                DialogesUtil.conformation("Body Saved");
              }
            Body_Table body_Table = new Body_Table(body_ToSave.getId(), body_ToSave.getBody_description(), body_ToSave.getBody_catagory(), body_ToSave.getDate());
            listForTable_Body.add(body_Table);
            controller.getBody_table().setItems(listForTable_Body);
          }
        if (status.equals("500"))
          {
            if (controller.getTitleManager_confirmation().isSelected())
              {
                DialogesUtil.error(" Body Save fail");
              }
          }
        }//public void bodyManager_save_body_button_action(ActionEvent event)

    public void bodyManager_refresh_body_button_action(ActionEvent event)
        {
        listForTable_Body.clear();
        for (Iterator<Body> iterator = persistence_BodyManager.bodyManager_dao_readAll_Bodies().iterator(); iterator.hasNext();)
          {
            Body b = (Body) iterator.next();
            Body_Table body_Table = new Body_Table(b.getId(), b.getBody_description(), b.getBody_catagory(), b.getDate());
            listForTable_Body.add(body_Table);
          }
        controller.getBody_table().setItems(listForTable_Body);
        }//public void bodyManager_refresh_body_button_action(ActionEvent event)

    public void bodyManager_edit_body_button_action(ActionEvent event)
        {
        try
          {
            id_to_edit = controller.getBody_table().getSelectionModel().getSelectedItem().getId();
            int selected_id_bodyTable = controller.getBody_table().getSelectionModel().getSelectedIndex();
            fill_all_fields(persistence_BodyManager.read_Body_byId(id_to_edit));
            listForTable_Body.remove(selected_id_bodyTable).toString();
            //reverse the save and edit.
            controller.getBodyManager_button_save_edit().setVisible(true);
            controller.getBodyManager_button_save_new().setVisible(false);
          } 
        catch (Exception e)
          {
            DialogesUtil.warning("Please Slelect a item first..!");
          }
        }//public void bodyManager_edit_body_button_action(ActionEvent event)

    //boiler plated.
    public void bodyManager_edit_save_body_button_action(ActionEvent event)
        {
        //reverse the save and edit.
        controller.getBodyManager_button_save_edit().setVisible(false);
        controller.getBodyManager_button_save_new().setVisible(true);

        Body body_ToSave_afterEdit = private_bodyManager_making_bodyObject();
        body_ToSave_afterEdit.setId(new Long(id_to_edit));
        System.out.println("\n\n title_ToSave_afterEdit :" + body_ToSave_afterEdit);

        String status = persistence_BodyManager.bodyManager_dao_save_Edited_Body(body_ToSave_afterEdit);
        if (status.equals("200"))
          {
            if (controller.getBodyManager_checkBox_showNotification().isSelected())
              {
                DialogesUtil.conformation("Body Saved");
              }
            Body_Table body_Table = 
                    new Body_Table(body_ToSave_afterEdit.getId(), body_ToSave_afterEdit.getBody_description(), body_ToSave_afterEdit.getBody_catagory(), body_ToSave_afterEdit.getDate());
            listForTable_Body.add(body_Table);
            controller.getBody_table().setItems(listForTable_Body);
          }
        if (status.equals("500"))
          {
            if (controller.getTitleManager_confirmation().isSelected())
              {
                DialogesUtil.error("Body Save fail");
              }
          }

        id_to_edit = -1l;
        }//public void titleManager_edit_save_title_button_action(ActionEvent event)

    public void bodyManager_delete_body_button_action(ActionEvent event)
        {
            try
              {
                Long id_to_delete = controller.getBody_table().getSelectionModel().getSelectedItem().getId();
                int selected_Index = controller.getBody_table().getSelectionModel().getSelectedIndex();
                String status = persistence_BodyManager.bodyManager_dao_delete_Body(id_to_delete);

                if (status.equals("200"))
                  {
                    if (controller.getBodyManager_checkBox_showNotification().isSelected())
                      {
                        DialogesUtil.conformation("Body Deleted");
                      }
                    listForTable_Body.remove(selected_Index);
                  }
                if (status.equals("500"))
                  {
                    if (controller.getAdvertisement_confirmation().isSelected())
                      {
                        DialogesUtil.conformation("body Delete fails.");
                      }
                  }//if
              } //try
            catch (Exception e)
              {
                DialogesUtil.warning("Please Slelect a item first..!");
              }
        }//public void bodyManager_delete_body_button_action(ActionEvent event)

    public void bodyManager_clear_button_action(ActionEvent event)
        {
         private_bodyManager_clear_();
        }//public void bodyManager_clear_button_action(ActionEvent event)
    
//    start : private area
    private Body private_bodyManager_making_bodyObject()
        {
        String catagory = controller.getBodyManager_textField_catagory().getText().toString();
        String body_description = controller.getBodyManager_textArea_body().getText().toString();
        String date = DateUtil.getDate();
        return new Body(catagory, body_description, date);
        }

    private void private_bodyManager_clear_()
        {
        controller.getBodyManager_textArea_body().setText("");
        controller.getBodyManager_textField_catagory().setText("");
        }

    private void fill_all_fields(Body b)
        {
        controller.getBodyManager_textArea_body().setText(b.getBody_description());
        controller.getBodyManager_textField_catagory().setText(b.getBody_catagory());
        }
//    End : private area

    }
