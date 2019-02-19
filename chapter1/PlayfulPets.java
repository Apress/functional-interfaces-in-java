package chapter1;
import java.util.*;

@FunctionalInterface
interface PetMatcher
{
    List<Pet> match(Pet pet);
    default Pet first(Pet pet)
    {
        int index = Pet.pets.indexOf(pet);
        return index > -1? Pet.pets.get(index) : null;
    }
}




public class PlayfulPets 
{
    private static void matchPet(String criteria, 
                                 PetMatcher matcher, Pet pet)
    {
        System.out.println("\n" + criteria + ":");
        System.out.println("First: " + matcher.first(pet));
        System.out.println("All matches:");
        List<Pet> matches = matcher.match(pet);
        for (Pet p : matches)
            System.out.println(p);
    }

    public static void main(String[] args)
    {
        Pet.pets.add(new Pet("Scruffy","dog","poodle",
                             "white",895.00));
        Pet.pets.add(new Pet("Meow","cat","siamese","white",740.25));
        Pet.pets.add(new Pet("Max","dog","poodle","black",540.50));
        Pet.pets.add(new Pet("Cuddles","dog","pug","black",1282.75));
        Pet.pets.add(new Pet("Slider","snake","garden",
                             "green",320.00));
        
        PetMatcher breedMatcher = new PetMatcher() {
            public List<Pet> match(Pet pet)
            {
                List<Pet> matches = new ArrayList<>();
                for (Pet p : Pet.pets)
                    if (p.equals(pet))
                        matches.add(p);
                return matches;
            }
        };
        
        PetMatcher priceMatcher = new PetMatcher() {
            public List<Pet> match(Pet pet)
            {
                List<Pet> matches = new ArrayList<>();
                for (Pet p : Pet.pets)
                    if (p.price <= pet.price)
                        matches.add(p);
                return matches;
            }
            public Pet first(Pet pet)
            {
                int index = -1;
                for(Pet p : Pet.pets)
                    if (p.price <= pet.price)
                        return p;
                return null;
            }
        };
        
        matchPet("Poodles",breedMatcher,
                 new Pet(null, "dog", "poodle", null, 0.0));
        matchPet("Pets for $800 or less",priceMatcher,
                 new Pet(null, null, null, null, 800.0));
    }
}
