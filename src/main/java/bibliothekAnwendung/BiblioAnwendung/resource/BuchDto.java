package bibliothekAnwendung.BiblioAnwendung.resource;

import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

public class BuchDto {

    @NotNull
    private String titel;

    private String isbn;
    private String id_BuchGenre;
    private int  bestand;
    private Set<Ausleihe> ausleiheBuch;

}
