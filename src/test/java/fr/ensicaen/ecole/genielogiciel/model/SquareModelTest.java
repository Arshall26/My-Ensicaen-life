package fr.ensicaen.ecole.genielogiciel.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquareModelTest {
    ISquareModel square = new SquareModel(1);

    @Test
    public void randomSquareTest() {

        for(int i =0; i<1000; i++){
            square = SquareModel.randomSquare(1);
            assertTrue((square.getSpeciality() == ISquareModel.Speciality.Normal)
                    || (square.getSpeciality() == ISquareModel.Speciality.Antiseche)
                    || (square.getSpeciality() == ISquareModel.Speciality.Diplome)
                    || (square.getSpeciality() == ISquareModel.Speciality.Redoublement)
                    || (square.getSpeciality() == ISquareModel.Speciality.Examen)
                    || (square.getSpeciality() == ISquareModel.Speciality.Jeudi)
                    || (square.getSpeciality() == ISquareModel.Speciality.Soiree)
                    || (square.getSpeciality() == ISquareModel.Speciality.Enseignement_Economie)
                    || (square.getSpeciality() == ISquareModel.Speciality.Enseignement_Anglais)
                    || (square.getSpeciality() == ISquareModel.Speciality.Enseignement_Maths)
                    || (square.getSpeciality() == ISquareModel.Speciality.Enseignement_Info));
        }
    }
}