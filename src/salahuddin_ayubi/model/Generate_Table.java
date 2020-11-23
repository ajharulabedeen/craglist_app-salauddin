/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salahuddin_ayubi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.ToString;

/**
 *
 * @author Dell-3460
 */
@ToString
public class Generate_Table
    {
        private final SimpleIntegerProperty     index;   //1
        private final SimpleStringProperty      city_id;    //2
        private final SimpleStringProperty  number_of_add;    //3
        private final SimpleStringProperty  catagory;   //4

    public Generate_Table()
        {
        this.index = null;
        this.city_id = null;
        this.number_of_add = null;
        this.catagory = null;
        }

    public Generate_Table(Integer index, String city_id, String number_of_add, String catagory)
        {
        this.index      = new SimpleIntegerProperty(index);
        this.city_id    = new SimpleStringProperty(city_id);
        this.number_of_add  = new SimpleStringProperty(number_of_add);
        this.catagory       = new SimpleStringProperty(catagory);
        }

    public Integer getIndex()
        {
        return index.get();
        }

    public String getCity_id()
        {
        return city_id.get();
        }

    public String getNumber_of_add()
        {
        return number_of_add.get();
        }

    public String getCatagory()
        {
        return catagory.get();
        }
    }
