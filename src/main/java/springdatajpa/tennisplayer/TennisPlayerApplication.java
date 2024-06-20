package springdatajpa.tennisplayer;

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
    PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert players
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Thiem", "Austria",
                        new Date(System.currentTimeMillis()), 17)));

        //Get player with id = 3
        logger.info("\n\n>> Player with id 3: {}\n", playerRepository.getPlayerById(3));

        //Update 3rd player
        logger.info("\n\n>> Updating Player with Id 3: {}\n", playerRepository.updatePlayer(
                new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 20)));

        //Get player with id = 3
        logger.info("\n\n>> Player with id 3: {}\n", playerRepository.getPlayerById(3));

        //Get all players
        logger.info("\n\n>> All players: {}\n", playerRepository.getAllPlayers());

        //Delete player with id = 2
        playerRepository.deletePlayerById(2);

        //Get all players
        logger.info("\n\n>> All players: {}\n", playerRepository.getAllPlayers());
    }
}
