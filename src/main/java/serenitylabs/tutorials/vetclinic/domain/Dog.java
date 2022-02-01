package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private String name;
    private LocalDate birthday;
    private String breed;

    public Dog(String name, String breed, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday () { return birthday; }

    public String getBreed() { return breed; }

    public static DogBreeder called(String name) {
        return new DogBreeder(name);
    }
    public static class DogBreeder {
        private String breed;
        private String name;
        private LocalDate birthday;

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
            return new Dog(name, breed, birthday);
        }
    }

}
