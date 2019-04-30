import save.SaveService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCreator {
    private Symulation symulation;
    private JMenu menu;

    MenuCreator(Symulation symulation) {
        this.symulation = symulation;
    }


    public JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menu = new JMenu("Menu ");
        menu.setPreferredSize(new Dimension(100, 40));
        menuBar.add(menu);

        JMenu submenu = new JMenu("Jezyk ");
        menu.add(submenu);

        submenu.add(createLanguageMenuItem(false, "Angielski"));
        submenu.add(createLanguageMenuItem(true, "Polski"));

        menu.add(createColorChangeMenuItem());

        menu.add(createSaveMenuItem());

        menu.add(createExitMenuItem());

        return menuBar;
    }

    private JMenuItem createExitMenuItem() {
        JMenuItem menuExit = new JMenuItem("Wyjdz");
        menu.add(menuExit);
        menuExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        return menuExit;
    }

    private JMenuItem createLanguageMenuItem(boolean isPlLanguage, String text) {
        JMenuItem languageMenuItem = new JMenuItem(text);
        languageMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symulation.isPL = isPlLanguage;

                symulation.updateText();
            }
        });
        return languageMenuItem;
    }

    private JMenuItem createColorChangeMenuItem() {
        JMenuItem menuItemColor = new JMenuItem("Kolor");
        menuItemColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symulation.setRightPanelComponentColor(JColorChooser.showDialog(symulation, "Choose color", Color.WHITE));
            }
        });
        return menuItemColor;
    }

    private JMenuItem createSaveMenuItem() {
        JMenuItem menuItemSave = new JMenuItem("Zapisz dane");
        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveService.createFile(symulation.getSaveData(), symulation.isPL);
                symulation.saveRightPanelImage();
            }
        });
        return menuItemSave;
    }
}
