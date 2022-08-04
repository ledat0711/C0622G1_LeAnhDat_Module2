/*Mô tả:
Thiết kế một lớp tên là StopWatch.

Hướng dẫn:
Lớp này bao gồm:

Trường startTime và endTime là private với
phương thức getter để trả về giá trị của startTime và endTime.

Phương thức khởi tạo không tham số khởi tạo
startTime với thời gian hiện tại của hệ thống.

Phương thức start() để reset startTime về
thời gian hiện tại của hệ thống.

Phương thức stop() để thiết đặt endTime
về thời gian hiện tại của hệ thống.

Phương thức getElapsedTime() trả về
thời gian đã trôi qua theo số milisecond giây

Vẽ sơ đồ UML cho lớp StopWatch và cài đặt lớp.

Viết chương trình đo thời gian thực thi của thuật toán sắp xếp chọn (selection sort) cho 100,000 số.*/
package build_stop_watch_class;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;

import java.text.SimpleDateFormat;
import java.util.Date;

class StopWatch {
    private long startTime;
    private long endTime;
    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public StopWatch() {
        long endTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return ((endTime - startTime));
    }
}
