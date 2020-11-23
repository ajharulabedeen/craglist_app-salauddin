package salahuddin_ayubi.model;

import java.sql.Clob;
import java.util.List;
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
public class Body
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;                    //1
        
        @Column @Setter @Getter
        private String  body_catagory;      //2
        
        @Lob @Setter @Getter
        private String  body_description;     //3
        
        @Column @Setter @Getter
        private String date;                //4

    public Body()
        {
        }
        
    public Body(String body_catagory, String body_description, String date)
        {
        this.body_catagory = body_catagory;
        this.body_description = body_description;
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
