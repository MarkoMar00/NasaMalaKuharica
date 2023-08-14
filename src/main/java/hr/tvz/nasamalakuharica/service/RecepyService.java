package hr.tvz.nasamalakuharica.service;

import hr.tvz.nasamalakuharica.dto.RecepyDto;

import java.util.List;
import java.util.Optional;

public interface RecepyService {

    List<RecepyDto> findAllByUserId(Long userId);

    Optional<List<RecepyDto>> findByName(String name);

    RecepyDto save(Long userId, RecepyDto recepy);
}
