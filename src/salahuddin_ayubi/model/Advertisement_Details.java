package salahuddin_ayubi.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Advertisement_Details
    {
        @Id
        private Long id;        //1
        @Column @Setter @Getter
        private Long  title_id; //2
        @Column @Setter @Getter
        private Long  body_id;  //3
        @Column @Setter @Getter
        private String date;    //4
    }
