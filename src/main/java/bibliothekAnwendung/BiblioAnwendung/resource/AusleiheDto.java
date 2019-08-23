package bibliothekAnwendung.BiblioAnwendung.resource;


import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data


public class AusleiheDto {




    private Instant ausleihBeginn;
    private Instant ausleihEnde;
    private BuchDto buchDto;
    private PersonDto personDto;
//    private Set<BuchDto> buchSet;
//    private Set<PersonDto> personSet;



}
