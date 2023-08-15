package org.fileTransfer.working;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Sender {

    private Sender() {
    }

    public static void send(OutputStream os, String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        Image img = ImageIO.read(new File(fileName));
        oos.writeObject(new ImageIcon(img));
    }
}
