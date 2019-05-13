package web.worker.tracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {

    // workers' ids in database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // workers' first names
    @Column(name = "first_name")
    private String firstName;

    // workers' last names
    @Column(name = "last_name")
    private String lastName;

    // worker's emails
    @Column(name = "email")
    private String email;

    public Worker() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Worker {" +
                "id = " + id + ", firstName = '" + firstName + '\'' + ", lastName = " + lastName + ", email = '" + email + '\'' + '}';
    }
}