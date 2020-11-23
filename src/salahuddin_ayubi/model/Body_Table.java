
package salahuddin_ayubi.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Body_Table
    {

//    lombok setter/getter, dont work
    
    private final SimpleLongProperty    id;         //1
    private final SimpleStringProperty  body;       //2
    private final SimpleStringProperty  catagory;   //3
    private final SimpleStringProperty  date;       //4

    public Body_Table()
        {
        this.id = null;
        this.body = null;
        this.catagory = null;
        this.date = null;
        }

    public Body_Table(
            Long id, String body, String catagory, String date)
        {
        this.id = new SimpleLongProperty (id);
        this.body = new SimpleStringProperty(body);
        this.catagory = new SimpleStringProperty(catagory);
        this.date = new SimpleStringProperty(date);
        }

    public Long getId()
        {
        return id.get();
        }

    public String getBody()
        {
        return body.get();
        }

    public String getCatagory()
        {
        return catagory.get();
        }

    public String getDate()
        {
        return date.get();
        }

    
    }
