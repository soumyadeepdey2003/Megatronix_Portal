package megatronix.soumya.Megatronix_portal.RD.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CodingRd")
@NoArgsConstructor
public class CodingModel {
    public CodingModel(String teamname, String selectedcodingevent, Long gid1, Long gid2, String number1){
        this.teamname=teamname;
        this.selectedcodingevent=selectedcodingevent;
        this.gid1=gid1;
        this.gid2=gid2;
        this.number1 = number1;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamname;
    @Column(name = "selectedcodingevent" , nullable = false)
    private  String selectedcodingevent;
    private Long gid1;
    @Column(nullable = true)
    private Long gid2;

    private String number1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getSelectedcodingevent() {
        return selectedcodingevent;
    }

    public void setSelectedcodingevent(String selectedcodingevent) {
        this.selectedcodingevent = selectedcodingevent;
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

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }
}
