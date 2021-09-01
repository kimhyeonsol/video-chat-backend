package capstone.videochat.service;
import capstone.videochat.DTO.FaceImageDTO;
import capstone.videochat.domain.User;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FaceDetectionService {

    BufferedReader input =null;
    BufferedWriter output =null;

    public boolean checkUserAttendance(FaceImageDTO faceImageDTO) throws IOException {

        String path = "C:/Users/DELL/Desktop/capstone/face-detection/";
        File file = new File(path+"image_base64.txt") ;

        // true 지정시 파일의 기존 내용에 이어서 작성
        FileWriter fileWriter = new FileWriter(file, true) ;
        // 파일안에 문자열 쓰기
        fileWriter.write(faceImageDTO.getFaceImage());
        fileWriter.flush();

        // 객체 닫기
        fileWriter.close();

        try {
            long start, end;
            String line;

            final String inputData = "image_base64.txt";
            
            //path 에다가 파이썬 파일이 있는 경로 설정

            
            String command ="python " + path + "face_detection.py " + path + inputData + " " + path;

            start = System.currentTimeMillis();

            Process p = Runtime.getRuntime().exec(command);
            output = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(p.getInputStream()));



            while ((line = input.readLine()) !=null) {
                if(line.equals("True")){
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
