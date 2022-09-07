package fr.ensicaen.ecole.genielogiciel.model;

public interface ISquareModel {
    enum Speciality {
        Enseignement_Anglais, Enseignement_Maths, Enseignement_Info, Enseignement_Economie, Antiseche, Jeudi, Soiree, Normal, Examen, Redoublement, Diplome
    }
    int getSquareID();
    Speciality getSpeciality();
}