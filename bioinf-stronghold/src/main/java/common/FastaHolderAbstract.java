package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Oleg Grigorjev on 07.08.2016.
 */
public abstract class FastaHolderAbstract {
    protected List<FastaItem> items;

    public abstract void evaluate();

    public void setItems(Collection<FastaItem> items) {
        this.items = new ArrayList<>(items);
    }

    public void readFastaFile(String fileName) {
        try {
            setItems(Text.readFastaFile(new FileReader(fileName)).values());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
