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
public class GamingcrdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String selectedgamingevent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedgamingevent() {
        return selectedgamingevent;
    }

    public void setSelectedgamingevent(String selectedgamingevent) {
        this.selectedgamingevent = selectedgamingevent;
    }
}