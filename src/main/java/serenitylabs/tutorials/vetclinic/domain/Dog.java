package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private String name;
    private LocalDate birthday;
    private String breed;
    private String color;

    public Dog(String name, String breed, String color, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday () { return birthday; }

    public String getBreed() { return breed; }

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }

    public String getColor() {
        return this.color;
    }

    public static class DogBreeder implements WithBreed{
        private String breed;
        private String name;
        private LocalDate birthday;
        private String color;

        public DogBreeder(String name) {
            this.name = name;
        }
        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }
        public DogBreeder bornOn(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }
        public Dog build() {
            return new Dog(name, breed, color,birthday);
        }

        public DogBreeder ofColor(String color) {
            this.color = color;
            return this;
        }
    }

}
