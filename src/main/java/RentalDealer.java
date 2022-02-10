import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rentaldealer")
public class RentalDealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int name;

    @OneToMany
    private List<Car> cars = new ArrayList<Car>();

    @ManyToOne
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<User>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
