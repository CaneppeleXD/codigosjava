package br.univates.source;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JDialog;

public class testeDialog {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MessageDialog");
        JOptionPane pane = new JOptionPane();
        pane.setMessage("long message...");
        JProgressBar jProgressBar = new JProgressBar(1, 100);
        jProgressBar.setValue(15);
        pane.add(jProgressBar,1);
        JDialog dialog = pane.createDialog(frame, "Information message");
        dialog.setVisible(true);
        dialog.dispose();
        System.exit(0);
    }  
}
