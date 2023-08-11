package hr.tvz.nasamalakuharica.dto;

import hr.tvz.nasamalakuharica.domain.Recepy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientDto {
    private Long id;

    private String name;

    private Integer amount;

    private Recepy recepy;
}
