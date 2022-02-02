package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
public class WhenCreatingADog {

    @Test
    public void a_new_dog_should_have_a_name() {
        LocalDate birthday = LocalDate.now();

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")
                .bornOn(birthday)
                .build();

        assertThat(fido.getName()).isEqualTo("Fido");
        assertThat(fido.getBreed()).isEqualTo("Labrador");
        assertThat(fido.getBirthday()).isEqualTo(birthday);
        assertThat(fido.getColor()).isEqualTo("black");
    }
}
