package in.dackend.fitapp.dto;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@Table(name = "fit_tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId;
    
    @Column(unique = true) 
    @NotEmpty
    private String usrName;
    
    @NotEmpty
    private String usrPassword;
    
    private Date usrDob;
    private String usrGender;
    private double usrWeight;
    private double usrHeight;
    private String usrHealthissues;
    private String usrGoal;
    private String usrEmail;
    
    @NotEmpty
    @Column(unique = true) 
    private String usrPhonenumber;
    private String usrAddress;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrAccountCreationDate;

}
