package springdatajpa.tennisplayer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Player insertPlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    public Player getPlayerByName(String name) {
        return entityManager.find(Player.class, name);
    }

    public List<Player> getAllPlayers() {
        TypedQuery<Player> query = entityManager.createNamedQuery("get_all_players", Player.class);
        return query.getResultList();
    }

    public void deletePlayerById(int id) {
        entityManager.remove(entityManager.find(Player.class, id));
    }
}
