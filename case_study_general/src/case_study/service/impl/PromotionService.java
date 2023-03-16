package case_study.service.impl;

import case_study.exception.NumberRegexInvalidException;
import case_study.exception.NumberValueInvalidException;
import case_study.model.Booking;
import case_study.model.Customer;
import case_study.model.Facility;
import case_study.model.Link;
import case_study.service.IPromotionService;
import case_study.utils.ReadWriteBookingFileUtil;
import case_study.utils.ReadWriteCustomerFileUtil;
import case_study.utils.ReadWriteFacilityFileUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionService implements IPromotionService {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void displayUseService() {
        TreeSet<Booking> bookingList = ReadWriteBookingFileUtil.readBookingFile(Link.PATH_BOOKING.getPath());
        List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(Link.PATH_CUSTOMER.getPath());
        Map<Facility, Integer> facilityList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_VILLA.getPath());
        facilityList.putAll(ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_HOUSE.getPath()));
        facilityList.putAll(ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_ROOM.getPath()));
        Set<Facility> facilitySet = facilityList.keySet();

        System.out.print("\nNhập năm sử dụng dịch vụ: ");
        String year;
        while (true) {
            try {
                year = SCANNER.nextLine();
                if (!year.matches("^2\\d{3}$")) {
                    throw new NumberRegexInvalidException("Năm phải đúng định dạng 2XXX (X là các số từ 0-9), vui lòng nhập lại!");
                }
                break;
            } catch (NumberRegexInvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        List<String> serviceIdFacilityList = new ArrayList<>();
        for (Facility facility : facilitySet) {
            if (facility.getRentalType().equals("Nam")) {
                serviceIdFacilityList.add(facility.getServiceId());
            }
        }

        List<String> customerIdList = new ArrayList<>();
        String[] arr;
        for (Booking booking : bookingList) {
            arr = booking.getStartDay().split("/");
            if (year.equals(arr[2])) {
                for (String serviceIdFacility : serviceIdFacilityList) {
                    if (booking.getServiceId().equals(serviceIdFacility)) {
                        customerIdList.add(booking.getCustomerId());
                    }
                }
            }
        }

        if (customerIdList.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng sử dụng dịch vụ theo năm (trong năm " + year + "): ");
        } else {
            System.out.println("\nDanh sách khách hàng đã sử dụng dịch vụ theo năm (trong năm " + year + "): ");
            for (Customer customer : customerList) {
                for (String customerId : customerIdList) {
                    if (customer.getId().equals(customerId)) {
                        System.out.println(customer);
                    }
                }
            }
        }
    }

    @Override
    public void displayGetVoucher() {
        TreeSet<Booking> bookingList = ReadWriteBookingFileUtil.readBookingFile(Link.PATH_BOOKING.getPath());

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String[] arrDate = dateFormat.format(date).split("/");

        List<String> customerIdList = new ArrayList<>();
        String[] arrDateBooking;
        for (Booking booking : bookingList) {
            arrDateBooking = booking.getStartDay().split("/");
            if (arrDateBooking[2].equals(arrDate[2]) && arrDateBooking[1].equals(arrDate[1])) {
                customerIdList.add(booking.getCustomerId());
            }
        }

        if (customerIdList.isEmpty()) {
            System.out.printf("Không có khách hàng đặt chỗ trong tháng %s/%s!\n", arrDate[1], arrDate[2]);
        } else {
            int totalVoucher = customerIdList.size();
            System.out.println("Tổng số lượng voucher: " + totalVoucher);

            System.out.print("Xin mời nhập vào số lượng voucher khuyến mãi 10%: ");
            int voucher10Percent;
            while (true) {
                try {
                    voucher10Percent = Integer.parseInt(SCANNER.nextLine());
                    if (voucher10Percent < 0 || voucher10Percent > totalVoucher) {
                        throw new NumberValueInvalidException("số lượng voucher khuyến mãi 10% phải từ 0 - " + totalVoucher + ", vui lòng nhập lại!");
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số!");
                } catch (NumberValueInvalidException e) {
                    System.out.println(e.getMessage());
                }
            }

            int voucher20Percent = 0;
            if (voucher10Percent < totalVoucher) {
                System.out.print("Xin mời nhập vào số lượng voucher khuyến mãi 20%: ");
                while (true) {
                    try {
                        voucher20Percent = Integer.parseInt(SCANNER.nextLine());
                        if (voucher20Percent < 0 || voucher20Percent > totalVoucher - voucher10Percent) {
                            throw new NumberValueInvalidException("số lượng voucher khuyến mãi 20% phải từ 0 - " + (totalVoucher - voucher10Percent) + ", vui lòng nhập lại!");
                        }

                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số!");
                    } catch (NumberValueInvalidException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            int voucher50Percent = totalVoucher - voucher10Percent - voucher20Percent;
            System.out.println("Hiện có " + voucher10Percent + " voucher 10%, " + voucher20Percent + " voucher 20%, " + voucher50Percent + " voucher 50%.");

            List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(Link.PATH_CUSTOMER.getPath());
            Stack<Customer> customerStack = new Stack<>();
            for (String customerId : customerIdList) {
                for (Customer customer : customerList) {
                    if (customerId.equals(customer.getId())) {
                        customerStack.add(customer);
                    }
                }
            }

            System.out.println("\nDanh sách khách hàng nhận được voucher: ");
            for (int i = 0; i < totalVoucher; i++) {
                if (voucher10Percent > 0) {
                    System.out.println(customerStack.pop() + " - Khuyến mãi 10%.");
                    voucher10Percent--;
                } else if (voucher20Percent > 0) {
                    System.out.println(customerStack.pop() + " - Khuyến mãi 20%.");
                    voucher20Percent--;
                } else {
                    System.out.println(customerStack.pop() + " - Khuyến mãi 50%.");
                }
            }
        }
    }
}
