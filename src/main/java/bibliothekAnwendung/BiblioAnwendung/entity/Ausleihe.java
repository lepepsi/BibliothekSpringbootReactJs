package bibliothekAnwendung.BiblioAnwendung.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;


@Entity
@Table(name = "ausleihe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Ausleihe {





    @Id
//    @GeneratedValue
//    @Column(name = "id", unique = true, nullable = false)
    private long id;
//    public long getId() {
//        return id;
//    }


//    public void setId(long id) {
//        this.id = id;
//    }



    @Column
    @NotNull
    private Instant ausleihBeginn;

    @Column
    private Instant ausleihEnde;

    @Column
    private int buchGenre;

    @CreationTimestamp
    private Instant creationDate;

    @UpdateTimestamp
    private Instant updateDate;

    @Version
    private Long version;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="buch_id")
    private Buch buch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;



}
