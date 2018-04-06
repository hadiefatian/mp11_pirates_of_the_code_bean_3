package at.refugeescode.mp11_pirates_of_the_code_bean_3.logic;

import at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence.PieceOfEight;
import at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence.Pirate;

public class PirateModule extends CsvParserModule<Pirate> {

    public PirateModule(String path) {
        super(path);
    }

    @Override
    boolean isValid(String[] columns) {
        return columns.length == 2;
    }

    @Override
    Pirate toObject(String[] columns) {
        Pirate pirate = new Pirate();
        pirate.setName(columns[0]);
        pirate.setPieceOfEight(createPieceOfEight(columns[1]));
        return pirate;
    }

    private PieceOfEight createPieceOfEight(String column) {
        PieceOfEight pieceOfEight = new PieceOfEight();
        pieceOfEight.setName(column);
        return pieceOfEight;
    }
}
