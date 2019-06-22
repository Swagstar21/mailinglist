package email.list.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String emailAddress;
    private String subscription;

    public User(String name, String emailAddress, String subscription) {
        this.name = name;
        this.emailAddress = emailAddress;
        this. subscription = subscription;
    }
}
