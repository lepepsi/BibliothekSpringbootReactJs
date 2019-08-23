package bibliothekAnwendung.BiblioAnwendung.resource;

import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PersonDto {


    @NotNull
    private String userName;

    @Email
    @NotNull
    private String email;
    private String firstName;
    private String lastName;
    private Set<Ausleihe> ausleiheSetPerson;




}
