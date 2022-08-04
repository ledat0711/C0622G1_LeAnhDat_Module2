package build_stop_watch_class;

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
        System.out.print("\nNhấn 2 để kết thúc bấm giờ và in ra thời gian: ");
        int pressTwo = Integer.parseInt(sc.nextLine());
        if (pressTwo == 2) {
            stopWatchObject.stop();
            stopWatchObject.getEndTime();
            System.out.println("Đã trôi qua " + stopWatchObject.getElapsedTime()+" mili giây");
        }
    }
}
