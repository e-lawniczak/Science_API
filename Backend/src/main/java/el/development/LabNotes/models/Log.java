//package el.development.LabNotes.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.util.Date;
//
//@Data
//@Entity
//@Table(name = "Logs", indexes = {
//        @Index(name = "ix_Logs_Code", columnList = "code")
//})
//public class Log {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String message;
//    private String code;
//    private String requestPath;
//    private String exception;
//    private String ipAddress;
//    private String requestBody;
//
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "DateCreated")
//    private Date createDate;
//
//
//}
