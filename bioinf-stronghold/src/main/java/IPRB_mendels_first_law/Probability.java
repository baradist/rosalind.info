package IPRB_mendels_first_law;

import lombok.Setter;

import java.util.Locale;

/**
 * Created by 1 on 04.07.2016.
 */
@Setter
public class Probability {
    private double dominant;
    private double hybrid;
    private double recessive;

    public double getDominantPhenotypeProbability() {
        double commonCount = dominant + hybrid + recessive;

        double probRecessiveRecessive = (recessive / commonCount) * (recessive - 1) / (commonCount - 1);
        double probRecessiveHybrid = (recessive / commonCount) * hybrid / (commonCount - 1);
        double probHybridRecessive = (hybrid / commonCount) * recessive / (commonCount - 1);
        double probHybridHybrid = (hybrid / commonCount) * (hybrid - 1) / (commonCount - 1);

        return 1 - (probRecessiveRecessive
                + 0.5 * probRecessiveHybrid
                + 0.5 * probHybridRecessive
                + 0.25 * probHybridHybrid);
    }

    public String getStringDominantPhenotypePProbability() {
        return String.format(Locale.ENGLISH, "%1$.5f", getDominantPhenotypeProbability());
    }

}
