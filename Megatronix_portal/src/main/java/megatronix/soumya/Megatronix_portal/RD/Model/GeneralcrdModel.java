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
public class GeneralcrdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String selectedgeneralevent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedgeneralevent() {
        return selectedgeneralevent;
    }

    public void setSelectedgeneralevent(String selectedgeneralevent) {
        this.selectedgeneralevent = selectedgeneralevent;
    }
}