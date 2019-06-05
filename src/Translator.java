import javax.swing.*;
import java.awt.*;

public class Translator {

    Symulation symulation;
    MenuCreator menucreator;
    public String FRAME_TITLE_PL = "Symulacja ogniskowania obrazu w oku w przypadkach ametropii";
    public String FRAME_TITLE_ANG= "Defect of vision symulation in case of ametropia";

    public String LABEL_REFRACTIVE_ERROR_PL = "Wybierz rodzaj ametropii";
    public String LABEL_REFRACTIVE_ERROR_ANG = "Choose type of ametropia";

    public String RADIOBUTTON_NEAR_SIGHTEDNESS_PL = "Krotkowzrocznosc";
    public String RADIOBUTTON_NEAR_SIGHTEDNESS_ANG = "Near-sightedness";

    public String  RADIOBUTTON_FAR_SIGHTEDNESS_PL = "Dalekowzrocznosc";
    public String  RADIOBUTTON_FAR_SIGHTEDNESS_ANG = "Far-sightedness";

    public String LABEL_WIELKOSC_WADY_PL = "Wybierz wielkosc wady wzroku";
    public String LABEL_WIELKOSC_WADY_ANG = "Choose level of ametropia";

    public String LABEL_LENGHT_PL = "Odleglosc";
    public String LABEL_LENGHT_ANG = "Lenght";
    public String labelLenghtText = LABEL_LENGHT_PL;

    public String BUTTON_RUN_PL = "Rozpocznij";
    public String BUTTON_RUN_ANG = "Run";

    public String MENU_JEZYK_PL = "Jezyk";
    public String MENU_JEZYK_ANG = "Language";
    
    public String MENU_JEZYK_WYBOR_POL_PL = "Polski";
    public String MENU_JEZYK_WYBOR_ANG_PL = "Polish";
    public String MENU_JEZYK_WYBOR_POL_ENG = "Angielski";
    public String MENU_JEZYK_WYBOR_ANG_ENG = "English";
    public String MENU_KOLOR_PL = "Kolor";
    public String MENU_KOLOR_ANG = "Colour";
    public String MENU_ZAPISZ_PL = "Zapisz";
    public String MENU_ZAPISZ_ENG = "Save";
    public String MENU_WYJSCIE_PL = "Wyjdz";
    public String MENU_WYJSCIE_ENG = "Quit";

    public Translator(Symulation symulation, MenuCreator menuCreator) {
        this.symulation = symulation;
    }

    public void updateText(boolean isPl) {
        if(isPl) {
            SwingUtilities.invokeLater(() -> symulation.setTitle(FRAME_TITLE_PL));
            SwingUtilities.invokeLater(() -> symulation.getLabelTitle().setText(FRAME_TITLE_PL));
            SwingUtilities.invokeLater(() -> symulation.getChangeRefractiveErrorLabel().setText(LABEL_REFRACTIVE_ERROR_PL));
            SwingUtilities.invokeLater(() -> symulation.getNearSightedness().setText(RADIOBUTTON_NEAR_SIGHTEDNESS_PL));
            SwingUtilities.invokeLater(() -> symulation.getFarSightedness().setText(RADIOBUTTON_FAR_SIGHTEDNESS_PL));
            SwingUtilities.invokeLater(() -> symulation.getVisualImpairment().setText(LABEL_WIELKOSC_WADY_PL));
            SwingUtilities.invokeLater(() -> symulation.getLabelOdleglosc().setText(LABEL_LENGHT_PL + " " + symulation.getOdleglosc() + "m"));
            labelLenghtText = LABEL_LENGHT_PL;
            SwingUtilities.invokeLater(() -> symulation.getLenghtLabel().setText(LABEL_LENGHT_PL));
            SwingUtilities.invokeLater(() -> symulation.getButtonRun().setText(BUTTON_RUN_PL));
        } else {
            SwingUtilities.invokeLater(() -> symulation.setTitle(FRAME_TITLE_ANG));
            SwingUtilities.invokeLater(() -> symulation.getLabelTitle().setText(FRAME_TITLE_ANG));
            SwingUtilities.invokeLater(() -> symulation.getChangeRefractiveErrorLabel().setText(LABEL_REFRACTIVE_ERROR_ANG));
            SwingUtilities.invokeLater(() -> symulation.getNearSightedness().setText(RADIOBUTTON_NEAR_SIGHTEDNESS_ANG));
            SwingUtilities.invokeLater(() -> symulation.getFarSightedness().setText(RADIOBUTTON_FAR_SIGHTEDNESS_ANG));
            SwingUtilities.invokeLater(() -> symulation.getVisualImpairment().setText(LABEL_WIELKOSC_WADY_ANG));
            SwingUtilities.invokeLater(() -> symulation.getLabelOdleglosc().setText(LABEL_LENGHT_ANG + " " + symulation.getOdleglosc() + "m"));
            labelLenghtText = LABEL_LENGHT_ANG;
            SwingUtilities.invokeLater(() -> symulation.getLenghtLabel().setText(LABEL_LENGHT_ANG));
            SwingUtilities.invokeLater(() -> symulation.getButtonRun().setText(BUTTON_RUN_ANG));
        }
    }

    public static String getVisualImparimentTranslation(boolean isPl) {
        if(isPl) {
            return "Wada wzroku: ";
        }
        return "Visual impariment: ";
    }

    public static String getAmethropyTypeTranslation(boolean isPl) {
        if(isPl) {
            return "Rodzaj ametropii: ";
        }
        return "Amethropy type: ";
    }

    public static String getLenghtTranslation(boolean isPl) {
        if(isPl) {
            return "Odleglosc: ";
        }
        return "Length: ";
    }

    public static String getSaveDateTranslation(boolean isPl) {
        if(isPl) {
            return "Data zapisu: ";
        }
        return "Save date: ";
    }
}
