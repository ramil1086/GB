import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        try {
            readAndPrintBytesFromFile("lorem.txt");
            joinFiles("file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt");

            //            в документе 12039 страниц
            readPagesFromFile("War and Peace.txt", 12000);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void readAndPrintBytesFromFile(String filePath) throws IOException {
//        FileInputStream fis = new FileInputStream(new File(filePath).getAbsoluteFile());
//        byte[] byteArray = new byte[fis.available()];
//        fis.read(byteArray);
//        fis.close();

        // или все вышеуказанное можно в одну строку
            byte[] byteArray = Files.readAllBytes(Paths.get(filePath).toAbsolutePath());

        System.out.println(Arrays.toString(byteArray));
    }

    public static void joinFiles(String ... filePaths) throws IOException {
        ArrayList<InputStream> inptStrmList = new ArrayList();
        for (String f : filePaths) {
            inptStrmList.add(new FileInputStream(String.valueOf(Paths.get(f).toAbsolutePath())));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new SequenceInputStream(Collections.enumeration(inptStrmList))));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("secondTask.txt"));
        while (bufferedReader.ready()) {
            bufferedWriter.write(bufferedReader.readLine());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void readPagesFromFile(String filePath, int pageToRead) throws IOException {
        long t = System.currentTimeMillis();
        File file = new File(filePath);
        System.out.printf("В Вашем файле %d страниц(а/ы)\n", file.getAbsoluteFile().length()/1800+1);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        bufferedReader.skip((pageToRead-1)*1800);
        int n = 0;
        while (n<1800 && bufferedReader.ready()) {
            System.out.print((char)bufferedReader.read());
            n++;
        }
        bufferedReader.close();
        System.out.println();
        System.out.println((System.currentTimeMillis()-t) + "милисекунд");


    }
}