package bibliothekAnwendung.BiblioAnwendung.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "buch")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Buch {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    long id;
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }



    @Column
    private String titel;

    @Column
    private String isbn;

    @Column
    private String id_BuchGenre;

    @Column
    private int bestand;

    @CreationTimestamp
    private Instant creationDate;

    @UpdateTimestamp
    private Instant updateDate;

    @Version
    private Long version;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buch")
    private Set<Ausleihe> ausleiheBuch = new HashSet<> ();

}
