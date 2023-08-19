package hr.tvz.nasamalakuharica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private Long id;

    private String name;

    private Integer portions;

    private Integer preparationTimeMinutes;

    private String instructions;

    private LocalDate date;

}
