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
public class ElectricalcrdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String selectedelectricalevent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedelectricalevent() {
        return selectedelectricalevent;
    }

    public void setSelectedelectricalevent(String selectedelectricalevent) {
        this.selectedelectricalevent = selectedelectricalevent;
    }
}