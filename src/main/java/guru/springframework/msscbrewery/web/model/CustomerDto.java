package guru.springframework.msscbrewery.web.model;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDto {

    private UUID id;

    @Size(min=3, max = 100)
    private String name;
}
