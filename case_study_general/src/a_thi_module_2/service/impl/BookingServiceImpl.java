package a_thi_module_2.service.impl;

import case_study.common.EnterBookingInfo;
import case_study.common.EnterServicesInfo;
import case_study.model.Booking;
import case_study.service.IBookingService;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class BookingServiceImpl implements IBookingService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LINK_BOOKING_FILE = "src\\case_study\\data\\booking.csv";

    @Override
    public void display() {
        int i;
        Set<Booking> bookingSet = ReadAndWriteFile.readBookingFromFile(LINK_BOOKING_FILE);
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void add() {
        Set<Booking> bookingSet = ReadAndWriteFile.readBookingFromFile(LINK_BOOKING_FILE);
        String bookingID = EnterBookingInfo.enterBookingID();
        LocalDate startDate = EnterBookingInfo.enterStartDate();
        LocalDate endDate = EnterBookingInfo.enterEndDate(startDate);
        String customerID = EnterBookingInfo.enterCustomerIDForBooking();
        String serviceName = EnterBookingInfo.enterServiceNameForBooking();
        System.out.println("Loại dịch vụ");
        String serviceType = EnterServicesInfo.returnTypeOfRental();
        bookingSet.add(new Booking(bookingID,startDate,endDate,customerID,serviceName,serviceType));
        System.out.println("\nĐã thêm thông tin booking:");
        System.out.println(new Booking(bookingID,startDate,endDate,customerID,serviceName,serviceType));
        ReadAndWriteFile.writeBookingToFile(LINK_BOOKING_FILE, bookingSet, false);
    }

    @Override
    public void edit() {
    }
}
