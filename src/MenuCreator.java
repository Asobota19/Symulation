import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCreator {
    Symulation symulation;
    JMenu menu;
    private String languageText = "Jezyk";
    MenuCreator(Symulation symulation) {
        this.symulation = symulation;
    }

    public void setLanguageText(String text) {
        menu.setText(text
        );
    }

    public JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menu = new JMenu("Menu ");
        menu.setPreferredSize(new Dimension(100, 40));
        menuBar.add(menu);

        JMenu submenu = new JMenu("Jezyk ");
        menu.add(submenu);

        JMenuItem menuItemEnglish = new JMenuItem("Angielski");
        menuItemEnglish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symulation.isPL = false;
                symulation.updateText();
            }
        });
        submenu.add(menuItemEnglish);
        JMenuItem menuItemPolish = new JMenuItem("Polski");
        menuItemPolish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symulation.isPL = true;
                symulation.updateText();
            }
        });
        submenu.add(menuItemPolish);

        JMenuItem menuItemColor = new JMenuItem("Kolor");
        menu.add(menuItemColor);

        JMenuItem menuItemSave = new JMenuItem("Zapisz dane");
        menu.add(menuItemSave);

        JMenuItem menuExit = new JMenuItem("Wyjdz");
        menu.add(menuExit);
        menuExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        return menuBar;
    }
}
