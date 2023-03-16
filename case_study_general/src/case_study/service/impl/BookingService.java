package case_study.service.impl;

import case_study.exception.DateInvalidException;
import case_study.exception.DuplicateIdException;
import case_study.exception.IdFormatException;
import case_study.model.*;
import case_study.service.IBookingService;
import case_study.utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingService implements IBookingService {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() {
        TreeSet<Booking> bookingList = ReadWriteBookingFileUtil.readBookingFile(Link.PATH_BOOKING.getPath());

        String bookingId;
        if (bookingList.isEmpty()) {
            bookingId = "BK-1";
        } else {
            String[] arr = bookingList.last().getBookingId().split("-");
            bookingId = "BK-" + (Integer.parseInt(arr[1]) + 1);
        }
        System.out.println("\nMã đặt chỗ: " + bookingId);

        System.out.print("Nhập ngày bắt đầu: ");
        String startDay;
        while (true) {
            try {
                startDay = RegexExceptionUtil.getDateFormat();
                if (new SimpleDateFormat("dd/MM/yyyy").parse(startDay).getTime() < new Date().getTime()) {
                    throw new DateInvalidException("Ngày bắt đầu phải không nhỏ hơn ngày hiện tại, vui lòng nhập lại!");
                }

                break;
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DateInvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập ngày kết thúc: ");
        String endDay;
        while (true) {
            try {
                endDay = RegexExceptionUtil.getDateFormat();
                if (new SimpleDateFormat("dd/MM/yyyy").parse(endDay).getTime() <= new SimpleDateFormat("dd/MM/yyyy").parse(startDay).getTime()) {
                    throw new DateInvalidException("Ngày kết thúc phải lớn hơn ngày bắt đầu, vui lòng nhập lại!");
                }

                break;
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DateInvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        String customerId = BookingInfoUtil.getCustomerId();

        String serviceId = BookingInfoUtil.getServiceIdBooking();

        String serviceName = null;
        if (serviceId.contains("VL")) {
            serviceName = "Villa";
        } else if (serviceId.contains("HO")) {
            serviceName = "House";
        } else {
            serviceName = "Room";
        }

        bookingList.add(new Booking(bookingId, startDay, endDay, customerId, serviceId, serviceName));
        ReadWriteBookingFileUtil.writeBookingFile(Link.PATH_BOOKING.getPath(), bookingList);
        System.out.println("Thêm mới đặt chỗ thành công!");

        if (serviceId.contains("VL") || serviceId.contains("HO")) {
            System.out.println("\nĐối với dịch vụ Villa và House, khách hàng cần phải làm hợp đồng thuê!");
            Queue<Contract> contractList = ReadWriteContractFileUtil.readContractFile(Link.PATH_CONTRACT.getPath());

            String numberContract;
            numberContract = "CT-" + (contractList.size() + 1);
            System.out.println("Số hợp đồng: " + numberContract);

            System.out.println("Mã đặt chỗ: " + bookingId);

            System.out.print("Nhập số tiền đặt cọc (VNĐ): ");
            int depositMoney = RegexExceptionUtil.getNumberGreaterThan0();

            System.out.print("Nhập tổng số tiền thanh toán (VNĐ): ");
            int sumMoney = 0;
            while (sumMoney <= depositMoney) {
                sumMoney = RegexExceptionUtil.getNumberGreaterThan0();

                if (sumMoney <= depositMoney) {
                    System.out.println("Số tiền tổng phải lớn hơn số tiền cọc trước, vui lòng nhập lại!");
                }
            }

            System.out.println("Mã khách hàng: " + customerId);

            contractList.add(new Contract(numberContract, bookingId, depositMoney, sumMoney, customerId));
            ReadWriteContractFileUtil.writeContractFile(Link.PATH_CONTRACT.getPath(), contractList);
            System.out.println("Thêm mới hợp đồng thành công!");
        }
    }

    @Override
    public void display() {
        TreeSet<Booking> bookingList = ReadWriteBookingFileUtil.readBookingFile(Link.PATH_BOOKING.getPath());
        List<Booking> bookings = new ArrayList<>();
        bookings.addAll(bookingList);
        DateComparatorUtil dateComparatorUtil = new DateComparatorUtil();
        bookings.sort(dateComparatorUtil);
        System.out.println("\nDanh sách đặt chỗ: ");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
