package pl.lrozek.jws.client.business;

import java.util.Map.Entry;
import java.util.Properties;

import pl.lrozek.jws.client.dto.Tupple;

public class PropsProvider {

    public String isCustomPropertyAvailable() {
        return null != System.getProperty( PROPERTY_KEY ) ? "YES" : "NO";
    }

    public Tupple getValueOfCustomProperty() {
        return new Tupple( PROPERTY_KEY, System.getProperty( PROPERTY_KEY ) );
    }

    public Object[][] getAllProps() {
        Properties properties = System.getProperties();
        int rowsCount = properties.size();
        Object[][] data = new Object[rowsCount][];
        int row = 0;
        for ( Entry<Object, Object> entry : properties.entrySet() ) {
            data[row] = new Object[] { entry.getKey(), entry.getValue() };
            row++;
        }
        return data;
    }

    public static final String PROPERTY_KEY = "custom_property";
}
