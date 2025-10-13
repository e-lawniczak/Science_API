package el.development.LabNotes.user.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordSalt;
    private boolean isDeleted;
    private boolean isActive;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DateCreated")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DateModified")
    private Date modifyDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    protected User(String email, String password, String firstName, String lastName, Role role, boolean isActive, boolean isDeleted){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.role = role;
    }

}
