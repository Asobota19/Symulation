import save.SaveService;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCreator {
    private Symulation symulation;
    private JMenu menu;
    private JMenu submenu;
    private JMenuItem menuExit;
    private JMenuItem menuItemColor;
    private JMenuItem menuItemSave;

    MenuCreator(Symulation symulation) {
        this.symulation = symulation;
    }


    public JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menu = new JMenu("Menu ");
        menu.setPreferredSize(new Dimension(100, 40));
        menuBar.add(menu);

        submenu = new JMenu("Jezyk ");
        menu.add(submenu);

        submenu.add(createLanguageMenuItem(false, "English"));
        submenu.add(createLanguageMenuItem(true, "Polski"));

        menu.add(createColorChangeMenuItem());

        menu.add(createSaveMenuItem());

        menu.add(createExitMenuItem());

        return menuBar;
    }

    private JMenuItem createExitMenuItem() {
        menuExit = new JMenuItem("Wyjdz");
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
                updateMenuText(isPlLanguage);
            }
        });
        return languageMenuItem;
    }

    private JMenuItem createColorChangeMenuItem() {
        menuItemColor = new JMenuItem("Kolor");
        menuItemColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symulation.setRightPanelComponentColor(JColorChooser.showDialog(symulation, "Choose color", Color.WHITE));
            }
        });
        return menuItemColor;
    }

    private JMenuItem createSaveMenuItem() {
        menuItemSave = new JMenuItem("Zapisz dane");
        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                symulation.saveRightPanelImage(chooser);
                SaveService.createFile(symulation.getSaveData(), symulation.isPL, chooser);
            }
        });
        return menuItemSave;
    }

    private void updateMenuText(boolean isPl) {
        if(isPl) {
            submenu.setText("Jezyk");
            menuExit.setText("Wyjdz");
            menuItemColor.setText("Kolor");
            menuItemSave.setText("Zapisz dane");
        } else {
            submenu.setText("Language");
            menuExit.setText("Exit");
            menuItemColor.setText("Color");
            menuItemSave.setText("Save data");
        }
    }
}
