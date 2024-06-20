package springdata.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlayerDao playerDao;

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Inserting a player
        logger.info("Inserting Player 4: {}", playerDao.addPlayer(
                new Player(4, "Thiem", "Austria",
                        new Date(System.currentTimeMillis()), 17)));

        //Updating a player
        logger.info("Updating Player with Id 4: {}", playerDao.updatePlayer(
                new Player(4, "Thiem", "Austria",
                        Date.valueOf("1993-09-03"), 17)));

        //View player by ID
        logger.info("Players with Id 4: {}", playerDao.getPlayerById(4));

        //Delete one player
        logger.info("Deleting Player with Id 3: {}", playerDao.deletePlayerById(3));

        //View all players
        logger.info("All Players Data: {}", playerDao.getAllPlayers());

        //View all French Players
        logger.info("French Players: {}", playerDao.getPlayerByNationality("France"));

        //Special case: Create a tournament table in H2 DB
        playerDao.createTournamentTable();
    }
}
