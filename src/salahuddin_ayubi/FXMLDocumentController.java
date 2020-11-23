/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salahuddin_ayubi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import lombok.Setter;
import salahuddin_ayubi.addmanager.Addmanager_Controller;
import salahuddin_ayubi.bodymanager.Controler_BodyManager;
import salahuddin_ayubi.model.Advertisement_Table;
import salahuddin_ayubi.model.Body_Table;
import salahuddin_ayubi.model.Generate_Table;
import salahuddin_ayubi.model.Title_Table;
import salahuddin_ayubi.titlemanager.Controler_TitleManager;

public class FXMLDocumentController implements Initializable
    {

    @Override
    public void initialize(URL url, ResourceBundle rb)
        {
            addmanager_Controller = new Addmanager_Controller(this);
            controler_TitleManager = new Controler_TitleManager(this);
            controler_BodyManager = new Controler_BodyManager(this);
            tableInitilzer();
        }
    
    public void tableInitilzer()
        {
            advertisements_table_column_id.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, Long>("id"));
            advertisements_table_column_state.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("state"));
            advertisements_table_column_city.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("city"));
            advertisements_table_column_zipcode.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("zipcode"));
            advertisements_table_column_program.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("program"));
            advertisements_table_column_phone.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("phone"));
            advertisements_table_column_url.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("url"));
            advertisements_table_column_catagory.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("catagory"));
            advertisements_table_column_date.setCellValueFactory(new PropertyValueFactory<Advertisement_Table, String>("date"));
            
            titles_table_column_id.setCellValueFactory(new PropertyValueFactory<Title_Table, Long>("id"));
            titles_table_column_title.setCellValueFactory(new PropertyValueFactory<Title_Table, String>("title"));
            titles_table_column_catagory.setCellValueFactory(new PropertyValueFactory<Title_Table, String>("catagory"));
            titles_table_column_date.setCellValueFactory(new PropertyValueFactory<Title_Table, String>("date"));
            
            body_table_column_id.setCellValueFactory(new PropertyValueFactory<Body_Table, Long>("id"));
            body_table_column_catagory.setCellValueFactory(new PropertyValueFactory<Body_Table, String>("body"));
            body_table_column_body.setCellValueFactory(new PropertyValueFactory<Body_Table, String>("catagory"));
            body_table_column_date.setCellValueFactory(new PropertyValueFactory<Body_Table, String>("date"));
            
            advertisement_generation_table_column_index.setCellValueFactory(new PropertyValueFactory<Generate_Table, Integer>("index"));
            advertisement_generation_table_column_city_id.setCellValueFactory(new PropertyValueFactory<Generate_Table, String>("city_id"));
            advertisement_generation_table_column_number_of_adds.setCellValueFactory(new PropertyValueFactory<Generate_Table, String>("number_of_add"));
            advertisement_generation_table_column_catagory.setCellValueFactory(new PropertyValueFactory<Generate_Table, String>("catagory"));
            
        }
    
//   Start : Advertisement Manager
    Addmanager_Controller addmanager_Controller;
    
    @FXML   @Setter @Getter
    private TextField advertisement_id;
    @FXML   @Setter @Getter
    private TextField advertisement_state;
    @FXML   @Setter @Getter
    private TextField advertisement_city;
    @FXML   @Setter @Getter
    private TextField advertisement_zipcode;
    @FXML   @Setter @Getter
    private TextField advertisement_program;
    @FXML   @Setter @Getter
    private TextField advertisement_phone;
    @FXML   @Setter @Getter
    private TextField advertisement_url;
    @FXML   @Setter @Getter
    private TextField advertisement_catagory;
    @FXML   @Setter @Getter
    private CheckBox advertisement_confirmation;    
    
    @FXML   @Setter @Getter
    private TextField city_manager_textField_search;    
    @FXML   @Setter @Getter
    private RadioButton city_manager_radioButton_catagory;    
    @FXML   @Setter @Getter
    private RadioButton city_manager_radioButton_city;    
    
    @FXML @Setter @Getter
    private TableView<Advertisement_Table> advertisements_table;
    @FXML @Setter @Getter
    private TableColumn<Advertisement_Table, Long> advertisements_table_column_id;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_state;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_city;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_zipcode;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_program;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_phone;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_url;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_catagory;
    @FXML @Setter @Getter
    private TableColumn <Advertisement_Table, String> advertisements_table_column_date;


//          Start : Add Generetot Split Pane
    @FXML   @Setter @Getter
    private TextField advertisement_generate_textField_city_id;
    @FXML   @Setter @Getter
    private TextField advertisement_generate_textField_number_of_ads;
    @FXML   @Setter @Getter
    private TextField advertisement_generate_textField_catagoty;
    @FXML   @Setter @Getter
    private CheckBox advertisement_generate_CheckBox_auto_add;
    
    @FXML @Setter @Getter
    private TableView<Generate_Table> advertisement_generation_table;
    @FXML @Setter @Getter
    private TableColumn<Generate_Table, Integer> advertisement_generation_table_column_index;
    @FXML @Setter @Getter
    private TableColumn <Generate_Table, String> advertisement_generation_table_column_city_id;
    @FXML @Setter @Getter
    private TableColumn <Generate_Table, String> advertisement_generation_table_column_number_of_adds;
    @FXML @Setter @Getter
    private TableColumn <Generate_Table, String> advertisement_generation_table_column_catagory;
//          End   :Add Generetot Split Pane
    
    
    @FXML
    private void save_advertisement_button_action(ActionEvent event)
        {
            addmanager_Controller.advertisement_save_advertisement_button_action(event);
        }
    @FXML
    private void delete_advertisement_button_action(ActionEvent event)
        {
            addmanager_Controller.advertisement_delete_advertisement_button_action(event);
        }
    @FXML
    private void refresh_advertisement_button_action(ActionEvent event)
        {
            addmanager_Controller.advertisement_refresh_advertisement_button_action(event);
        }
    @FXML
    private void clear_advertisement_button_action(ActionEvent event)
        {
            addmanager_Controller.clear_advertisement_button_action(event);
        }
    @FXML
    private void edit_advertisement_button_action(ActionEvent event)
        {
            addmanager_Controller.edit_advertisement_button_action(event);
        }
    @FXML
    private void cityManager_city_table_mouse_double_click_action( MouseEvent mouseEvent )
        {
            addmanager_Controller.cityManager_city_table_mouse_double_click_action(mouseEvent);
        }
    @FXML
    private void clear_advertisement_generator_clear_button_action(ActionEvent event)
        {
            addmanager_Controller.clear_advertisement_generator_clear_button_action(event);
        }
    @FXML
    private void delete_advertisement_generator_clear_button_action(ActionEvent event)
        {
            addmanager_Controller.delete_advertisement_generator_clear_button_action(event);
        }
    @FXML
    private void add_advertisement_generator_clear_button_action(ActionEvent event)
        {
            addmanager_Controller.add_advertisement_generator_clear_button_action(event);
        }
    @FXML
    private void export_advertisement_generator_clear_button_action(ActionEvent event) throws Exception
        {
            addmanager_Controller.export_advertisement_generator_clear_button_action(event);
        }
    @FXML
    private void search_textField_key_realsed_action(KeyEvent keyEvent) throws Exception
        {
            addmanager_Controller.search_textField_key_realsed_action(keyEvent);
        }
    
//   End : Advertisement Manager

    
    
//   Start : Title Manager
    Controler_TitleManager controler_TitleManager;
    
    @FXML   @Setter @Getter
    private TextField titleManager_textField_catagory;
    @FXML   @Setter @Getter
    private TextArea titleManager_textArea_title;
    @FXML   @Setter @Getter
    private Button titleManager_button_edit_save;
    @FXML   @Setter @Getter
    private Button titleManager_button_save;
    @FXML   @Setter @Getter
    private CheckBox titleManager_confirmation;
    
    @FXML @Setter @Getter
    private TableView<Title_Table> titles_table;
    @FXML @Setter @Getter
    private TableColumn<Title_Table, Long> titles_table_column_id;
    @FXML @Setter @Getter
    private TableColumn <Title_Table, String> titles_table_column_title;
    @FXML @Setter @Getter
    private TableColumn <Title_Table, String> titles_table_column_catagory;
    @FXML @Setter @Getter
    private TableColumn <Title_Table, String> titles_table_column_date;
    
    @FXML
    private void titleManager_save_title_button_action(ActionEvent event)
        {
            controler_TitleManager.titleManager_save_title_button_action(event);
        }
    @FXML
    private void titleManager_refresh_title_button_action(ActionEvent event)
        {
            controler_TitleManager.titleManager_refresh_title_button_action(event);
        }
    @FXML
    private void titleManager_edit_title_button_action(ActionEvent event)
        {
            controler_TitleManager.titleManager_edit_title_button_action(event);
        }
    @FXML
    private void titleManager_edit_save_title_button_action(ActionEvent event)
        {
            controler_TitleManager.titleManager_edit_save_title_button_action(event);
        }
    @FXML
    private void titleManager_delete_title_button_action(ActionEvent event)
        {
            controler_TitleManager.titleManager_delete_title_button_action(event);
        }
    @FXML
    private void titleManager_clear_button_action(ActionEvent event)
        {
            controler_TitleManager.titleManager_clear_button_action(event);
        }
//   End : Title Manager

//   Start : Body Manager
        Controler_BodyManager controler_BodyManager;
        
        @FXML   @Setter @Getter
        private TextField bodyManager_textField_catagory;
        @FXML   @Setter @Getter
        private TextArea bodyManager_textArea_body;  
        
        @FXML   @Setter @Getter
        private Button bodyManager_button_save_new;  
        @FXML   @Setter @Getter
        private Button bodyManager_button_save_edit;  
        @FXML   @Setter @Getter
        private CheckBox bodyManager_checkBox_showNotification;  
        
        @FXML @Setter @Getter
        private TableView<Body_Table> body_table;
        @FXML @Setter @Getter
        private TableColumn<Body_Table, Long> body_table_column_id;
        @FXML @Setter @Getter
        private TableColumn <Body_Table, String> body_table_column_body;
        @FXML @Setter @Getter
        private TableColumn <Body_Table, String> body_table_column_catagory;
        @FXML @Setter @Getter
        private TableColumn <Body_Table, String> body_table_column_date;
        
        
        @FXML
        private void bodyManager_save_body_button_action(ActionEvent event)
            {
                controler_BodyManager.bodyManager_save_body_button_action(event);
            }
        @FXML
        private void bodyManager_refresh_body_button_action(ActionEvent event)
            {
                System.out.println("controler_BodyManager.bodyManager_refresh_body_button_action(event);");
                controler_BodyManager.bodyManager_refresh_body_button_action(event);
            }
        @FXML
        private void bodyManager_edit_body_button_action(ActionEvent event)
            {
                controler_BodyManager.bodyManager_edit_body_button_action(event);
            }
        @FXML
        private void bodyManager_edit_save_body_button_action(ActionEvent event)
            {
                controler_BodyManager.bodyManager_edit_save_body_button_action(event);
            }
        @FXML
        private void bodyManager_delete_body_button_action(ActionEvent event)
            {
                controler_BodyManager.bodyManager_delete_body_button_action(event);
            }
        @FXML
        private void bodyManager_clear_button_action(ActionEvent event)
            {
                controler_BodyManager.bodyManager_clear_button_action(event);
            }
        
//   End: Body Manager


    
    
    

    }
