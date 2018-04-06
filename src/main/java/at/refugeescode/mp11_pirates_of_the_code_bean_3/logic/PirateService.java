package at.refugeescode.mp11_pirates_of_the_code_bean_3.logic;

import at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence.PieceOfEightRepository;
import at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence.Pirate;
import at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence.PirateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PirateService {

    private PirateRepository pirateRepository;

    private PieceOfEightRepository pieceOfEightRepository;

    private CsvParser csvParser;

    public PirateService(PirateRepository pirateRepository, PieceOfEightRepository pieceOfEightRepository, CsvParser csvParser) {
        this.pirateRepository = pirateRepository;
        this.pieceOfEightRepository = pieceOfEightRepository;
        this.csvParser = csvParser;
    }

    public void populatePirates() {

        // delete all the pirates and pieces of eight from the database
        deleteAll();

        // use the csvParser to get a list of all the pirates, the path should be "classpath:pirates.csv"
        //csvParser.asList(pirates.classPath);
        PirateModule pirateModule = new PirateModule("classpath:pirates.csv");
        List<Pirate> pirates = csvParser.asList(pirateModule);

        pirates.stream()
                // for each pirate, save first manually the piece of eight,
                .map(pirate -> {
                    pieceOfEightRepository.save(pirate.getPieceOfEight());
                    return pirate;
                })
                // connect it to the corresponding pirate and then save the pirate
                .forEach(pirate -> pirateRepository.save(pirate));

    }

    // return all the pirates from the database
    public List<Pirate> findAll() {
        return pirateRepository.findAll();
    }

    public void deleteAll() {

        // delete all pirates
        pirateRepository.deleteAll();

        // delete all pieces of eight
        pieceOfEightRepository.deleteAll();

    }
}
