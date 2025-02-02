package guru.springframework.msscbrewery.web.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDto {

    private UUID id;
    private String name;
}
