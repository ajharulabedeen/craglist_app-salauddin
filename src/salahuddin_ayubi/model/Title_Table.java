
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
public class Title_Table
    {

//    lombok setter/getter, dont work
    
    private final SimpleLongProperty    id;//1
    private final SimpleStringProperty  title;   //2
    private final SimpleStringProperty  catagory;//8
    private final SimpleStringProperty  date;    //9

    public Title_Table()
        {
        this.id = null;
        this.catagory = null;
        this.date = null;
        this.title=null;
        }
    
    public Title_Table(Long   id, String title, String catagory, String date)
        {
        this.id         = new SimpleLongProperty(id);
        this.title      = new SimpleStringProperty(title);
        this.catagory   = new SimpleStringProperty(catagory);
        this.date       = new SimpleStringProperty(date);
        }

    public Long getId()
        {
        return id.get();
        }

    public String getTitle()
        {
        return title.get();
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
