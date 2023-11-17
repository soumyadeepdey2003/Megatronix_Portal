package megatronix.soumya.Megatronix_portal.RD.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rdmain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long id;
    private String selectedDomain;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedDomain() {
        return selectedDomain;
    }

    public void setSelectedDomain(String selectedDomain) {
        this.selectedDomain = selectedDomain;
    }
}
//model, service , repo, controller