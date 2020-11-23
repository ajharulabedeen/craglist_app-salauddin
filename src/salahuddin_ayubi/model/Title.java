package salahuddin_ayubi.model;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
//@AllArgsConstructor
public class Title
    {        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        
        @Column @Setter @Getter
        private String  title_catagory; //2
        
        
        @Lob @Setter @Getter
        private String title_description;        //3

        @Column @Setter @Getter
        private String date;            //4

    public Title()
        {
        }

    public Title(String title_catagory, String title_description, String date)
        {
        this.title_catagory = title_catagory;
        this.title_description = title_description;
        this.date = date;
        }

    public Long getId()
        {
        return id;
        }

    public void setId(Long id)
        {
        this.id = id;
        }
    }
