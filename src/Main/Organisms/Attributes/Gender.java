package Main.Organisms.Attributes;

import Main.CFrame;

public enum Gender {
    //TODO: implement methods that come with being female f.e. getPregnant and giveBirth
    MALE,
    FEMALE;

    /**
     * @return a random Main.Main.NeuralNetwork.NeuralNetwork.Gender
     */
    public static Gender getRandomGender(){
        if(CFrame.random.nextBoolean())return Gender.MALE;
        else return Gender.FEMALE;
    }
}
