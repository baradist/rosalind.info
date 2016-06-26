package RNA_dna_into_rna;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Transcriber {
    String value;

    public Transcriber(String value) {
        this.value = value;
        replaceTWithU();
    }

    private void replaceTWithU() {
        value = value.replace('T', 'U');
    }

    public String getValue() {
        return value;
    }
}
