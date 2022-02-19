package serenitylabs.tutorials.vetclinic.playingball.model;

public class DontKnowThatGameException extends RuntimeException {
    public DontKnowThatGameException(String errorMessage){
        super(errorMessage);
    }
}
