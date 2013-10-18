package pl.lrozek.jws.client.main;

import javax.swing.SwingUtilities;

import pl.lrozek.jws.client.business.PropsProvider;
import pl.lrozek.jws.client.gui.MainWindow;

public class Main {

    public static void main( String[] args ) {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run() {
                MainWindow mainFrame = new MainWindow( new PropsProvider() );
                mainFrame.init();
                mainFrame.setVisible( true );
            }

        } );
    }

}
