package a_thi_module_2.utils.read_write_data;

import case_study.model.Booking;
import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.Customer;
import case_study.model.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadAndWriteFile {
    public static void writeStringToFile(String path, List<String> stringList, boolean append) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readStringFromFile(String path) {
        String line;
        List<String> stringList = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void writeEmployeeToFile(String path, List<Employee> employeeList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.toString());
        }
        writeStringToFile(path, stringList, append);
    }
    /**
     * Method name: readEmployeeFromFile();
     * Function of the method: Input data as a list of strings from file.
     * */
    public static List<Employee> readEmployeeFromFile(String path) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readStringFromFile(path);
        for (String string : stringList) {
            String[] array = string.split(",");
            employeeList.add(new Employee(array[0], LocalDate.parse(array[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")), array[2], array[3], array[4], array[5], array[6], array[7],
                    array[8], Double.parseDouble(array[9])));
        }
        return employeeList;
    }

    public static void writeCustomerToFile(String path, List<Customer> customerList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.toString());
        }
        writeStringToFile(path, stringList, append);
    }

    public static List<Customer> readCustomerFromFile(String path) {
        List<Customer> customerList = new ArrayList<>();
        List<String> stringList = readStringFromFile(path);
        for (String string : stringList) {
            String[] array = string.split(",");
            customerList.add(new Customer(array[0],
                    LocalDate.parse(array[1],DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    array[2],
                    array[3],
                    array[4],
                    array[5],
                    array[6],
                    array[7],
                    array[8]));
        }
        return customerList;
    }

    public static void writeVillaToFile(String path, Map<Villa, Integer> villaIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Villa> villaSet = villaIntegerMap.keySet();
        for (Villa villa : villaSet) {
            stringList.add(villa.toString() + "," + 0);
        }
        writeStringToFile(path, stringList, append);
    }

    public static Map<Villa, Integer> readVillaFromFile(String path) {
        List<String> stringList = readStringFromFile(path);
        Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            villaIntegerMap.put(new Villa(arr[0],
                    arr[1],
                    Double.parseDouble(arr[2]),
                    Double.parseDouble(arr[3]),
                    Integer.parseInt(arr[4]),
                    arr[5],
                    arr[6],
                    arr[7],
                    Integer.parseInt(arr[8])),
                    Integer.parseInt(arr[9]));
        }
        return villaIntegerMap;
    }

    public static void writeHouseToFile(String path, Map<House, Integer> houseIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<House> houseSet = houseIntegerMap.keySet();
        for (House house : houseSet) {
            stringList.add(house.toString() + "," + 0);
        }
        writeStringToFile(path, stringList, append);
    }

    public static Map<House, Integer> readHouseFromFile(String path) {
        List<String> stringList = readStringFromFile(path);
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            houseIntegerMap.put(new House(arr[0],
                    arr[1],
                    Double.parseDouble(arr[2]),
                    Double.parseDouble(arr[3]),
                    Integer.parseInt(arr[4]),
                    arr[5],
                    arr[6],
                    Integer.parseInt(arr[7])),
                    Integer.parseInt(arr[8]));
        }
        return houseIntegerMap;
    }

    public static void writeRoomToFile(String path, Map<Room, Integer> roomIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Room> roomSet = roomIntegerMap.keySet();
        for (Room room : roomSet) {
            stringList.add(room.toString() + "," + 0);
        }
        writeStringToFile(path, stringList, append);
    }

    public static Map<Room, Integer> readRoomFromFile(String path) {
        List<String> stringList = readStringFromFile(path);
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            roomIntegerMap.put(new Room(arr[0],
                    arr[1],
                    Double.parseDouble(arr[2]),
                    Double.parseDouble(arr[3]),
                    Integer.parseInt(arr[4]),
                    arr[5],
                    arr[6]),
                    Integer.parseInt(arr[7]));
        }
        return roomIntegerMap;
    }

    public static void writeFacilityToFile(String path, Map<Facility, Integer> facilityIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility facility : facilitySet) {
            stringList.add(facility.toString() + "," + 0);
        }
        writeStringToFile(path, stringList, append);
    }

    public static Map<Facility, Integer> readFacilityFromFile(String path) {
        List<String> stringList = readStringFromFile(path);
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            if (arr[0].contains("VL")) {
                facilityIntegerMap.put(new Villa(arr[0],
                        arr[1],
                        Double.parseDouble(arr[2]),
                        Double.parseDouble(arr[3]),
                        Integer.parseInt(arr[4]),
                        arr[5],
                        arr[6],
                        arr[7],
                        Integer.parseInt(arr[8])),
                        Integer.parseInt(arr[9]));
            } else if (arr[0].contains("HO")) {
                facilityIntegerMap.put(new House(arr[0],
                        arr[1],
                        Double.parseDouble(arr[2]),
                        Double.parseDouble(arr[3]),
                        Integer.parseInt(arr[4]),
                        arr[5],
                        arr[6],
                        Integer.parseInt(arr[7])),
                        Integer.parseInt(arr[8]));
            } else if (arr[0].contains("RO")) {
                facilityIntegerMap.put(new Room(arr[0],
                        arr[1],
                        Double.parseDouble(arr[2]),
                        Double.parseDouble(arr[3]),
                        Integer.parseInt(arr[4]),
                        arr[5],
                        arr[6]),
                        Integer.parseInt(arr[7]));
            }
        }
        return facilityIntegerMap;
    }

    public static void writeBookingToFile(String path, Set<Booking> bookingSet, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Booking booking : bookingSet) {
            stringList.add(booking.toString() + "," + 0);
        }
        writeStringToFile(path, stringList, append);
    }

    public static Set<Booking> readBookingFromFile(String path) {
        List<String> stringList = ReadAndWriteFile.readStringFromFile(path);
        Set<Booking> bookingSet = new TreeSet<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            bookingSet.add(new Booking(arr[0],
                    LocalDate.parse(arr[1],DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    LocalDate.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    arr[3],
                    arr[4],
                    arr[5]));
        }
        return bookingSet;
    }

}
