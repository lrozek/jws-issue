package pl.lrozek.jws.client.dto;

public class Tupple {

    private String key;

    private String value;

    public Tupple( String key, String value ) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }

}
