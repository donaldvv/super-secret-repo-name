package Project.ELearningSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AdminEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @Column(name = "fname",nullable = false)
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "emailid")
    private String EmailID;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String Gender;


}
