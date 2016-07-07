package FIBD_mortal_rabbits;

import java.math.BigInteger;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Oleg Grigorjev on 08.07.2016.
 */
public class RabbitsCounter {
    public BigInteger count(int months, int lifeLenght) {
        Queue<BigInteger> olds = new LinkedBlockingQueue<>(--lifeLenght);
        for (int i = 0; i < lifeLenght; i++) {
            olds.add(BigInteger.ZERO);
        }
        BigInteger adults = new BigInteger("0");
        BigInteger children = BigInteger.ONE;
        for (int i = 1; i < months; i++) {
            BigInteger newChildren = adults.multiply(BigInteger.valueOf(1));
            adults = adults.subtract(olds.poll());
            adults = adults.add(children);
            olds.add(children);
            children = newChildren;
        }
        return adults.add(children);
    }
}
