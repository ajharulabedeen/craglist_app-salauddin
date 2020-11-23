
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
public class Advertisement_Table
    {

//    lombok setter/getter, dont work
    
    private final SimpleLongProperty    id;//1
    private final SimpleStringProperty  state;   //2
    private final SimpleStringProperty  city;    //3
    private final SimpleStringProperty  zipcode; //4
    private final SimpleStringProperty  program; //5
    private final SimpleStringProperty  phone;   //6
    private final SimpleStringProperty  url;     //7
    private final SimpleStringProperty  catagory;//8
    private final SimpleStringProperty  date;    //9

    public Advertisement_Table()
        {
        this.id = null;
        this.state = null;
        this.city = null;
        this.zipcode = null;
        this.program = null;
        this.phone = null;
        this.url = null;
        this.catagory = null;
        this.date = null;
        }
    
    public Advertisement_Table(
            Long   id, 
            String state, 
            String city, 
            String zipcode, 
            String program, 
            String phone, 
            String url, 
            String catagory, 
            String date)
        {
        this.id         = new SimpleLongProperty(id);
        this.state      = new SimpleStringProperty(state);
        this.city       = new SimpleStringProperty(city);
        this.zipcode    = new SimpleStringProperty(zipcode);
        this.program    = new SimpleStringProperty(program);
        this.phone      = new SimpleStringProperty(phone);
        this.url        = new SimpleStringProperty(url);
        this.catagory   = new SimpleStringProperty(catagory);
        this.date       = new SimpleStringProperty(date);
        }

    public Long getId()
        {
        return id.get();
        }

    public String getState()
        {
        return state.get();
        }

    public String getCity()
        {
        return city.get();
        }

    public String getZipcode()
        {
        return zipcode.get();
        }

    public String getProgram()
        {
        return program.get();
        }

    public String getPhone()
        {
        return phone.get();
        }

    public String getUrl()
        {
        return url.get();
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
