public class Translator {

    Symulation symulation;
    public String FRAME_TITLE_PL = "Symulacja ogniskowania obrazu w oku w przypadkach ametropii";
    public String FRAME_TITLE_ANG= "Symualtion title";
    public String frameTitle = FRAME_TITLE_PL;

    public String LABEL_REFRACTIVE_ERROR_PL = "Wybierz rodzaj ametropii";
    public String LABEL_REFRACTIVE_ERROR_ANG = "rodzaj ametropii ang";
    public String labelRefractiveError = LABEL_REFRACTIVE_ERROR_PL;

    public String RADIOBUTTON_NEAR_SIGHTEDNESS_PL = "Krotkowzrocznosc";
    public String RADIOBUTTON_NEAR_SIGHTEDNESS_ANG = "Near-sightedness";
    public String radiobuttonNearSightedness = RADIOBUTTON_NEAR_SIGHTEDNESS_PL;

    public String  RADIOBUTTON_FAR_SIGHTEDNESS_PL = "Dalekowzrocznosc";
    public String  RADIOBUTTON_FAR_SIGHTEDNESS_ANG = "Far-sightedness";
    public String radiobuttonFarSightedness = RADIOBUTTON_NEAR_SIGHTEDNESS_PL;

    public String LABEL_WIELKOSC_WADY_PL = "Wpisz wielkosc wady wzroku";
    public String LABEL_WIELKOSC_WADY_ANG = "ANG";
    public String labelWielkoscWady = LABEL_REFRACTIVE_ERROR_PL;

    public String LABEL_LENGHT_PL = "Odleglosc";
    public String LABEL_LENGHT_ANG = "Lenght";
    public String labelLenght = LABEL_LENGHT_PL;

    public String BUTTON_RUN_PL = "Rozpocznij";
    public String BUTTON_RUN_ANG = "Run";
    public String buttonRun = BUTTON_RUN_PL;



    public Translator(Symulation symulation) {
        this.symulation = symulation;
    }

    public void updateText(boolean isPl) {
        if(isPl) {
            frameTitle = FRAME_TITLE_PL;
            labelRefractiveError = LABEL_REFRACTIVE_ERROR_PL;
            radiobuttonNearSightedness = RADIOBUTTON_NEAR_SIGHTEDNESS_PL;
            radiobuttonFarSightedness = RADIOBUTTON_FAR_SIGHTEDNESS_PL;
            labelWielkoscWady = LABEL_WIELKOSC_WADY_PL;
            labelLenght = LABEL_LENGHT_PL;
            buttonRun = BUTTON_RUN_PL;

        } else {
            frameTitle = FRAME_TITLE_ANG;
            labelRefractiveError = LABEL_REFRACTIVE_ERROR_ANG;
            radiobuttonNearSightedness = RADIOBUTTON_NEAR_SIGHTEDNESS_ANG;
            radiobuttonFarSightedness = RADIOBUTTON_FAR_SIGHTEDNESS_ANG;
            labelWielkoscWady = LABEL_REFRACTIVE_ERROR_ANG;
            labelLenght = LABEL_LENGHT_ANG;
            buttonRun = BUTTON_RUN_ANG;
        }
    }

}
