package bibliothekAnwendung.BiblioAnwendung.entity;

import lombok.*;




import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "person")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter





public class Person {




    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    long id;
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }



    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

   @OneToMany( fetch = FetchType.LAZY, mappedBy = "person")
   private Set <Ausleihe> ausleihePerson = new HashSet<>();


}
