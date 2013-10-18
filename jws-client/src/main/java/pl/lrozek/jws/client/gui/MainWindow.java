package pl.lrozek.jws.client.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pl.lrozek.jws.client.business.PropsProvider;

public class MainWindow extends JFrame {

    private JLabel jLabelPresence;

    private JLabel jLabelValue;

    private JTable jTable;

    private JScrollPane jScrollPane;

    private PropsProvider propsProvider;

    public MainWindow( PropsProvider propsProvider ) throws HeadlessException {
        this.propsProvider = propsProvider;
    }

    private static final long serialVersionUID = 1L;

    public void init() {
        setSize();
        initComponents();
        configureLayout();
    }

    private void configureLayout() {
        setLayout( createLayoutManager() );
        add( jLabelPresence, getConstraints( 0 ) );
        add( jLabelValue, getConstraints( 1 ) );
        add( jScrollPane, getConstraints4ScrollPane( 2 ) );
    }

    private GridBagLayout createLayoutManager() {
        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[] { 0, 1 };
        layout.columnWidths = new int[] { 0, 0 };
        layout.rowWeights = new double[] { 0, 0, 0, 1 };
        layout.rowHeights = new int[] { 0, 0, 0, 0 };
        return layout;
    }

    private GridBagConstraints getConstraints( int row ) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = row;
        return constraints;
    }

    private GridBagConstraints getConstraints4ScrollPane( int row ) {
        GridBagConstraints constraints = getConstraints( row );
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        return constraints;
    }

    private void initComponents() {
        jLabelPresence = new JLabel();
        jLabelPresence.setText( "is custom property present: " + propsProvider.isCustomPropertyAvailable() );
        jLabelValue = new JLabel();
        jLabelValue.setText( propsProvider.getValueOfCustomProperty().toString() );
        jTable = new JTable( propsProvider.getAllProps(), new Object[] { "propertyName", "propertyValue" } );
        jScrollPane = new JScrollPane( jTable );
    }

    private void setSize() {
        int width = 600;
        int height = 400;
        Dimension defaultSize = new Dimension( width, height );
        setSize( defaultSize );
    }

}
