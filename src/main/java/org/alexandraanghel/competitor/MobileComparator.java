package org.alexandraanghel.competitor;

import java.util.Comparator;

public class MobileComparator implements Comparator<Mobile> {

    @Override
    public int compare(Mobile mobile, Mobile t1) {
        if (mobile == t1)
        {
            return 0;
        }
        if (mobile == null)
        {
            return -1;
        }
        if (t1 == null)
        {
            return 1;
        }
        return Double.compare(mobile.getTotalTraveledDistance(), t1.getTotalTraveledDistance());
    }
}
