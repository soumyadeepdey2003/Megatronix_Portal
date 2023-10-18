package megatronix.soumya.Megatronix_portal.RD.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CivilRd")
@NoArgsConstructor
public class CivilModel {
    public CivilModel(String selectedcivilevent, Long gid1, Long gid2, Long gid3, Long gid4, Long gid5, String number1, String number2){
        this.selectedcivilevent=selectedcivilevent;
        this.gid1=gid1;
        this.gid2=gid2;
        this.gid3=gid3;
        this.gid4=gid4;
        this.gid5=gid5;
        this.number1 = number1;
        this.number2 = number2;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private  String selectedcivilevent;
    private Long gid1;
    private Long gid2;
    @Column(nullable = true)
    private Long gid3;
    @Column(nullable = true)
    private Long gid4;
    @Column(nullable = true)
    private Long gid5;

    private String number1;
    @Column(nullable = true)
    private String number2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSelectedcivilevent() {
        return selectedcivilevent;
    }

    public void setSelectedcivilevent(String selectedcivilevent) {
        this.selectedcivilevent = selectedcivilevent;
    }

    public Long getGid1() {
        return gid1;
    }

    public void setGid1(Long gid1) {
        this.gid1 = gid1;
    }

    public Long getGid2() {
        return gid2;
    }

    public void setGid2(Long gid2) {
        this.gid2 = gid2;
    }
    public Long getGid3() {
        return gid3;
    }

    public void setGid3(Long gid3) {
        this.gid3 = gid3;
    }
    public Long getGid4() {
        return gid4;
    }

    public void setGid4(Long gid4) {
        this.gid4 = gid4;
    }
    public Long getGid5() {
        return gid5;
    }

    public void setGid5(Long gid5) {
        this.gid5 = gid5;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }
}

