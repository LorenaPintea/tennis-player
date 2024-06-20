package springdatajpa.tennisplayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Long> {
    //NO implementation required!
    //Simply by extending the JpaRepository, we get all basic CRUD operations.


    List<Player> findByNationality(String nationality);
}
