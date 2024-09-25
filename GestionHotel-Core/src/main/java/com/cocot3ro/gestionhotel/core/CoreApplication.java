package com.cocot3ro.gestionhotel.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);

        System.setProperty("java.awt.headless", "false");

        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            PopupMenu popup = new PopupMenu();
            MenuItem closeItem = new MenuItem("Cerrar");
            closeItem.addActionListener(e -> System.exit(0));
            popup.add(closeItem);
            Image image = Toolkit.getDefaultToolkit().getImage(CoreApplication.class.getResource("/images/app_image.png"));
            TrayIcon trayIcon = new TrayIcon(image, "Gestion Hotel");
            trayIcon.setImageAutoSize(true);
            trayIcon.setPopupMenu(popup);
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }
        } else {
            System.err.println("SystemTray is not supported");
        }
    }
}
