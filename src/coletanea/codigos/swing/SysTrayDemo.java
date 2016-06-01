package coletanea.codigos.swing;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SysTrayDemo {
    protected static TrayIcon trayIcon;
    private static PopupMenu createTrayMenu() {
        ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bye from the tray");
                System.exit(0);
            }
        };

        ActionListener executeListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog
                   (null, "Popup from the action on the systray!",
                    "User action", JOptionPane.INFORMATION_MESSAGE);
                trayIcon.displayMessage
                   ("Done", "You can do it again if you want!",
                    TrayIcon.MessageType.INFO);
            }
        };

        PopupMenu menu = new PopupMenu();
        MenuItem execItem = new MenuItem("Action...");
        execItem.addActionListener(executeListener);
        menu.add(execItem);

        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(exitListener);
        menu.add(exitItem);
        return menu;
    }

    /**
     * Loading the image from a file
     */
    private static TrayIcon createTrayIconFromFile() {
        Image image =
          Toolkit.getDefaultToolkit().getImage("/temp/trayrealhowto.jpg");
        PopupMenu popup = createTrayMenu();
        TrayIcon ti = new TrayIcon(image, "Java System Tray Demo", popup);
        ti.setImageAutoSize(true);
        return ti;
    }

    /**
     * Loading the image from the classpath
     * if in a folder in a jar, remember to add the folder!
     * ex. /img/realhowto.jpg
     */
    private static TrayIcon createTrayIconFromResource()
      throws java.io.IOException {
      ClassLoader cldr = SysTrayDemo.class.getClassLoader();
      java.net.URL imageURL = cldr.getResource("trayrealhowto.jpg");
      Image image = Toolkit.getDefaultToolkit().getImage(imageURL);
      PopupMenu popup = createTrayMenu();
      TrayIcon ti = new TrayIcon(image, "Java System Tray Demo", popup);
      ti.setImageAutoSize(true);
      return ti;
    }

    /**
     * using a built-in icon
     * (may not work with some LAF or built-in icon, use with caution!)
     * we need to convert the icon to an Image
     */
    private static TrayIcon createTrayIconFromBuiltInIcon() {
        Icon icon = UIManager.getIcon("OptionPane.warningIcon");
        PopupMenu popup = createTrayMenu();
        Image image = iconToImage(icon);
        TrayIcon ti = new TrayIcon(image, "Java System Tray Demo", popup);
        ti.setImageAutoSize(true);
        return ti;
    }

    static Image iconToImage(Icon icon) {
          if (icon instanceof ImageIcon) {
              return ((ImageIcon)icon).getImage();
          } else {
              int w = icon.getIconWidth();
              int h = icon.getIconHeight();
              GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
              GraphicsDevice gd = ge.getDefaultScreenDevice();
              GraphicsConfiguration gc = gd.getDefaultConfiguration();
              BufferedImage image = gc.createCompatibleImage(w, h);
              Graphics2D g = image.createGraphics();
              icon.paintIcon(null, g, 0, 0);
              g.dispose();
              return image;
          }
      }

    public static void main(String[] args) throws Exception {
        if (!SystemTray.isSupported()) {
            System.out.println
               ("System tray not supported on this platform");
            System.exit(1);
        }

        try {
            SystemTray sysTray = SystemTray.getSystemTray();
            trayIcon = createTrayIconFromFile();
            //trayIcon = createTrayIconFromResource();
            //trayIcon = createTrayIconFromBuiltInIcon();
            sysTray.add(trayIcon);
            trayIcon.displayMessage("Ready",
                "Tray icon started and tready", TrayIcon.MessageType.INFO);
        }
        catch (AWTException e) {
            System.out.println("Unable to add icon to the system tray");
            System.exit(1);
        }
    }
}