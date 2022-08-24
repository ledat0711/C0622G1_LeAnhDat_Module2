package copy_binary_file.controller;

import copy_binary_file.utils.exception.AdditionalException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyBinaryFile {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        int j = 0;
        int i = 0;
        Scanner in = new Scanner(System.in);
        while (i < 10) {
            i++;
            try {
                System.out.println("Nhập đường dẫn file nguồn: ");
                String sourcePath = in.nextLine();
                File sourceFile = new File(sourcePath);
                if (!(sourceFile.exists())) {
                    throw new FileNotFoundException();
                }
                while (j < 10) {
                    try {
                        j++;
                        System.out.println("\nNhập đường dẫn file đích: ");
                        String destPath = in.nextLine();
                        File destFile = new File(destPath);
                        FileInputStream fileInputStream = new FileInputStream(sourcePath);
                        long sizeInputFile = fileInputStream.getChannel().size();
                        File fileDestination = new File(destPath);
                        if (fileDestination.exists()) {
                            throw new AdditionalException("File đích đã tồn tại.");
                        }
                        System.out.println("\nFile nguồn có kích thước: " + sizeInputFile + " bytes.");
                        //copyFileUsingJava7Files(sourceFile, destFile);
                        copyFileUsingStream(sourceFile, destFile);
                        System.out.println("Sao chép thành công.");
                        break;
                    } catch (AdditionalException ae) {
                        System.out.println(ae.getMessage());
                    }catch (Exception e){
                        System.out.println("Đã có lỗi xảy ra. Vui lòng kiểm tra lại. ");
                    }
                }
                break;
            } catch (FileNotFoundException f) {
                System.out.println("Không tìm thấy file nguồn theo đường dẫn bạn cung cấp.");
            } catch (Exception e) {
                System.out.println("Đã có lỗi xảy ra. Vui lòng kiểm tra lại. ");
            }
        }
    }
}