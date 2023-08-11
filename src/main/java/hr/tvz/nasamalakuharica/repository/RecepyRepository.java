package hr.tvz.nasamalakuharica.repository;

import hr.tvz.nasamalakuharica.domain.Recepy;
import hr.tvz.nasamalakuharica.domain.User;

import java.util.List;
import java.util.Optional;

public interface RecepyRepository {

    List<Recepy> findAllByUserId(User user);

    Optional<List<Recepy>> findByName(String name);

    Optional<Recepy> save(Recepy recepy, User user);

    void delete(String name);
}
