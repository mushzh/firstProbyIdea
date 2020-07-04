package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class OutputStreamTest {

    /**
     * 写入一个flag和一个文件的内容
     */
    public void outputTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        String flag = "1";
        try {
            fis = new FileInputStream("C:\\\\Users\\user\\Documents\\TestFile\\formFrom.txt");
            byte [] b = new byte[1024];
            boolean firstFlag = true;
            fos = new FileOutputStream("C:\\\\Users\\user\\Documents\\TestFile\\formTo.txt");
            while(true){
                int temp = fis.read(b, 0, b.length);
                //如果temp = -1的时候，说明读取完毕
                if(temp == -1){
                    break;
                }
                if (firstFlag) {
                    firstFlag = false;
//                    fos.write(flag.getBytes(), 0, flag.getBytes().length);
                    flag = "123456";
                    fos.write(flag.getBytes(), 1, 5);
                }
                fos.write(b, 0, temp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
