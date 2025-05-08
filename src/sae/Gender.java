package sae;

public enum Gender {
    FEMALE("female"),MALE("male"),OTHER("other");

    private String genre;

    private Gender(genre){
        genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }
}
