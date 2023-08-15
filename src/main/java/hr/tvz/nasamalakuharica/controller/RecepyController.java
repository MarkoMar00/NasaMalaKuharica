package hr.tvz.nasamalakuharica.controller;

import hr.tvz.nasamalakuharica.dto.RecepyDto;
import hr.tvz.nasamalakuharica.service.RecepyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recepy")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class RecepyController {

    RecepyService recepyService;

    @GetMapping("/user")
    public List<RecepyDto> findRecepiesbyUserId (@RequestParam Long id) {
        return recepyService.findAllByUserId(id);
    }

    @GetMapping("/name")
    public ResponseEntity<List<RecepyDto>> findRecepiesByName(@RequestParam String name) {
        return recepyService.findByName(name)
                .map(
                        recepies -> ResponseEntity.status(HttpStatus.FOUND).body(recepies)
                ).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                );
    }

    @PostMapping("/save/{userId}/")
    public RecepyDto save(@PathVariable(value = "userId") Long userId, @RequestBody RecepyDto recepyDto) {
        return recepyService.save(userId, recepyDto);
    }


}
