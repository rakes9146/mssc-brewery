package guru.springframework.msscbrewery.domain;

import lombok.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

    private UUID id;

    private String name;
}
