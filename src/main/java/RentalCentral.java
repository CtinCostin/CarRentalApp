import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rentalcentral")
public class RentalCentral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<RentalDealer> rentalDealers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<RentalDealer> getRentalDealers() {
        return rentalDealers;
    }

    public void setRentalDealers(List<RentalDealer> rentalDealers) {
        this.rentalDealers = rentalDealers;
    }

}
