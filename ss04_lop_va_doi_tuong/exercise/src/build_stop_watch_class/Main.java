package build_stop_watch_class;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhấn 1 để bắt đầu bấm giờ: ");
        int pressOne = Integer.parseInt(sc.nextLine());
        StopWatch stopWatchObject = new StopWatch();
        if (pressOne == 1) {
            stopWatchObject.start();
            stopWatchObject.getStartTime();
        }
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println(time1);
        int i;
        int j;
        int l;
        long k=0;
        for (i = 0; i < 1000; i++) {
            for (j = 0; j < 1000; j++){
                for (l=0; l < 1000;l++){
                    k++;
                }
            }
        }
        long pressTwo = k;
        if (pressTwo == 1000000000) {
            stopWatchObject.stop();
            stopWatchObject.getEndTime();
            LocalDateTime time2 = LocalDateTime.now();
            System.out.println(time2);
            System.out.println("\nĐã trôi qua " + stopWatchObject.getElapsedTime() + " mili giây");
        }
    }
}