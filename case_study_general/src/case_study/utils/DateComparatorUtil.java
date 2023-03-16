package case_study.utils;

import case_study.model.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class DateComparatorUtil implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        try {
            long start1 = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getStartDay()).getTime();
            long start2 = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getStartDay()).getTime();

            if (start1 > start2) {
                return 1;
            }

            if (start1 < start2) {
                return -1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            long end1 = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getEndDay()).getTime();
            long end2 = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getEndDay()).getTime();

            if (end1 > end2) {
                return 1;
            }

            if (end1 < end2) {
                return -1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
