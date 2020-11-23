package salahuddin_ayubi.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement
    {
        @Id @Setter @Getter
        private Long id;        //1
        @Column @Setter @Getter
        private String state;   //2
        @Column @Setter @Getter
        private String city;    //3
        @Column @Setter @Getter
        private String zipcode; //4
        @Column @Setter @Getter
        private String program; //5
        @Column @Setter @Getter
        private String phone;   //6
        @Column @Setter @Getter
        private String url;     //7
        @Column @Setter @Getter
        private String catagory;//8
        @Column @Setter @Getter
        private String date;    //9
        
        @Setter @Getter
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
        List<Advertisement_Details> advertisement_Detailses;

    public Advertisement(
            Long id, 
            String state, 
            String city, 
            String zipcode, 
            String program, 
            String phone, 
            String url, 
            String catagory, 
            String date
            )
        {
        this.id = id;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.program = program;
        this.phone = phone;
        this.url = url;
        this.catagory = catagory;
        this.date = date;
        }
        
        
    }
