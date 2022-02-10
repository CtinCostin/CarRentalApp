import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @ManyToMany(mappedBy = "users")
    private List<RentalDealer> rentalDealers = new ArrayList<RentalDealer>();

    @ManyToMany
    private List<Car> cars = new ArrayList<Car>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<RentalDealer> getRentalDealers() {
        return rentalDealers;
    }

    public void setRentalDealers(List<RentalDealer> rentalDealers) {
        this.rentalDealers = rentalDealers;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
