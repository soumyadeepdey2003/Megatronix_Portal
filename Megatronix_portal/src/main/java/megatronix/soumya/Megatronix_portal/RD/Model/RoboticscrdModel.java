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
public class RoboticscrdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String selectedroboticsevent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedroboticsevent() {
        return selectedroboticsevent;
    }

    public void setSelectedroboticsevent(String selectedroboticsevent) {
        this.selectedroboticsevent = selectedroboticsevent;
    }
}
