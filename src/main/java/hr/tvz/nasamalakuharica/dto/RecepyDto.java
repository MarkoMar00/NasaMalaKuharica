package hr.tvz.nasamalakuharica.dto;

import hr.tvz.nasamalakuharica.domain.Ingredient;
import hr.tvz.nasamalakuharica.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecepyDto {
    private Long id;

    private String name;

    private Integer portions;

    private Integer preparationTimeMinutes;

    private String instructions;

    private LocalDate date;

}
