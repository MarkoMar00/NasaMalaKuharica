package hr.tvz.nasamalakuharica.service.impl;

import hr.tvz.nasamalakuharica.domain.Recepy;
import hr.tvz.nasamalakuharica.domain.User;
import hr.tvz.nasamalakuharica.dto.RecepyDto;
import hr.tvz.nasamalakuharica.repository.RecepyRepository;
import hr.tvz.nasamalakuharica.repository.UserRepository;
import hr.tvz.nasamalakuharica.service.RecepyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecepyServiceImpl implements RecepyService {

    RecepyRepository recepyRepository;
    UserRepository userRepository;

    @Override
    public List<RecepyDto> findAllByUserId(Long userId) {
        return recepyRepository.findAllByUser_Id(userId)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<List<RecepyDto>> findByName(String name) {
        return Optional.of(recepyRepository.findByName(name).get()
                .stream().map(this::mapToDto).collect(Collectors.toList()));
    }

    @Override
    public RecepyDto save(Long userId, RecepyDto recepyDto) {
        Recepy recepy = mapToRecepy(recepyDto);

        User user = userRepository.findById(userId).orElseThrow();

        recepy.setUser(user);

        Recepy newRecepy = recepyRepository.save(recepy);

        return mapToDto(newRecepy);
    }

    private Recepy mapToRecepy (RecepyDto recepyDto) {
        Recepy recepy = new Recepy();
        recepy.setId(recepyDto.getId());
        recepy.setName(recepyDto.getName());
        recepy.setPortions(recepyDto.getPortions());
        recepy.setPreparationTimeMinutes(recepyDto.getPreparationTimeMinutes());
        recepy.setInstructions(recepyDto.getInstructions());
        recepy.setDate(recepyDto.getDate());

        return recepy;
    }

    private RecepyDto mapToDto (Recepy recepy) {
        RecepyDto recepyDto = new RecepyDto();
        recepyDto.setId(recepy.getId());
        recepyDto.setName(recepy.getName());
        recepyDto.setPortions(recepy.getPortions());
        recepyDto.setPreparationTimeMinutes(recepy.getPreparationTimeMinutes());
        recepyDto.setInstructions(recepy.getInstructions());
        recepyDto.setDate(recepy.getDate());

        return recepyDto;
    }
}
