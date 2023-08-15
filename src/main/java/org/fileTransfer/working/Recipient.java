package org.fileTransfer.working;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Recipient {

    private Recipient() {
    }

    public static void receive(InputStream is, String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(is);

        ImageIcon img = (ImageIcon) ois.readObject();

        BufferedImage out = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = out.createGraphics();
        g2.drawImage(img.getImage(), 0, 0, null);

        g2.dispose();

        ImageIO.write(out,
                "png",
                new File(fileName));
    }
}
