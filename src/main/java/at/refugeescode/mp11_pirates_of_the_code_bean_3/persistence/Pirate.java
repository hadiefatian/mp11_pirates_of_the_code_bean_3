package at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pirate {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private PieceOfEight pieceOfEight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceOfEight getPieceOfEight() {
        return pieceOfEight;
    }

    public void setPieceOfEight(PieceOfEight pieceOfEight) {
        this.pieceOfEight = pieceOfEight;
    }
}
