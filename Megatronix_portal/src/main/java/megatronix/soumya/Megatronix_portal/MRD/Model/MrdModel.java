package megatronix.soumya.Megatronix_portal.MRD.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.scheduling.annotation.Async;


@Entity
@Table(name = "Mrd")
@NoArgsConstructor
@Async
public class MrdModel {
    public MrdModel(String name, String college, String year, String department, String roll, String email, String phoneNumber, Long gid){
        this.name=name;
        this.college=college;
        this.year=year;
        this.department=department;
        this.roll=roll;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.gid = gid;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String college;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false, unique = true)
    private String roll;

    @Column(nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Nullable
    private Long gid;


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCollege() {
        return college;
    }
    public String getYear() {
        return year;
    }
    public String getDepartment() {
        return department;
    }
    public String getRoll() {
        return roll;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getGid() {
        return gid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }
}
