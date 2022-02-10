import java.util.List;
import java.util.Scanner;

public class MainRental {

    public static void main(String[] args) {

        Dao dao = new Dao();

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("---------------------");
            System.out.println("0.Exit");
            System.out.println("1.Add car");
            System.out.println("2.Add user");
            System.out.println("3.Show users");
            System.out.println("4.Choose car you want to rent");
            System.out.println("Select option:");
            System.out.println("---------------------");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Enter car name:");
                String carName = scanner.nextLine();
                System.out.println("Enter car type:");
                String carType = scanner.nextLine();
                System.out.println("Enter car colour:");
                String colourOfCar = scanner.nextLine();

                Car newCar = new Car();
                newCar.setName(carName);
                newCar.setType(carType);
                newCar.setColour(colourOfCar);
                dao.addCar(newCar);

            }
            if (option == 2) {
                System.out.println("Enter user first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter user last name:");
                String lastName = scanner.nextLine();

                User newUser = new User();
                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                dao.addUser(newUser);
            }
            if (option == 3) {
                List<User> userList = dao.getUsers();
                for (User user : userList) {
                    System.out.println(user.getId() + "." + user.getFirstName() + " " + user.getLastName());
                }

            }
            if (option == 4) {
                List<Car> cars = dao.getCars();
                for (Car car : cars) {
                    System.out.println(car.getId() + "." + car.getName() + " - " + car.getType() + " - " + car.getColour());
                    List<User> users = (List<User>) car.getUsers();
                    for (User user : users) {
                        System.out.println("   ->" + user.getId() + "." + user.getFirstName() + " " + user.getLastName());
                    }
                }
                System.out.println("Enter the id of the user who want to rent:");
                int idOfUser = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the id of the car you want to rent:");
                int idOfCar = scanner.nextInt();
                scanner.nextLine();

                dao.rentACar(idOfUser, idOfCar);


            }

        }

    }
}
