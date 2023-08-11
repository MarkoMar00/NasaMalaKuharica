package hr.tvz.nasamalakuharica.dto;

import hr.tvz.nasamalakuharica.domain.Recepy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String username;

    private List<Recepy> recepies;
}
