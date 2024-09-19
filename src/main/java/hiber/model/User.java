package hiber.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @MapsId
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Car car;

    public User(String firstName, String lastName, String email, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
