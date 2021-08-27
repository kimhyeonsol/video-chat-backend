package capstone.videochat.service;
import java.io.*;

public class FaceDetectionService {

    BufferedReader input =null;
    BufferedWriter output =null;

    public boolean checkUserAttendance(byte[] image) throws IOException {

        try {
            long start, end;
            String line;

            String inputData = " " + image.toString();

            String execPath ="python C:\\Users\\DELL\\Desktop\\capstone\\face-detection\\face_detection.py"+inputData;

            start = System.currentTimeMillis();

            Process p = Runtime.getRuntime().exec(execPath);
            output = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

            input =new BufferedReader(new InputStreamReader(p.getInputStream()));



            while ((line = input.readLine()) !=null) {
                if(line == "True"){
                    return true;
                }
                else{
                    return false;
                }
            }

            end = System.currentTimeMillis();

            System.out.println("<br>Running Time : " + (end - start) / 1000f +"s.");

        }catch (IOException err) {
            err.printStackTrace();
        }finally {
            if (input !=null) input.close();
        }

        return false;
    }
}
