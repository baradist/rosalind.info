package FIB_recurrence_relations;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class RabbitsCounter {
    public long count(int months, int prolificacy) {
        long adults = 0;
        long childern = 1;
        for (int i = 0; i < months - 1; i++) {
            long newChildren = adults * prolificacy;
            adults += childern;
            childern = newChildren;
        }
        return adults + childern;
    }
}
