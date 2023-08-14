package hr.tvz.nasamalakuharica.repository;

import hr.tvz.nasamalakuharica.domain.Recepy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecepyRepository extends JpaRepository<Recepy, Long> {

    List<Recepy> findAllByUser_Id(Long userId);

    Optional<List<Recepy>> findByName(String name);
}
