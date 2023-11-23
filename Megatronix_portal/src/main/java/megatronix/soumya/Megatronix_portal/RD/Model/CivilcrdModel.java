package megatronix.soumya.Megatronix_portal.RD.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CivilcrdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private  String selectedcivilevent;


    public String getSelectedcivilevent() {
        return selectedcivilevent;
    }

    public void setSelectedcivilevent(String selectedcivilevent) {
        this.selectedcivilevent = selectedcivilevent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
