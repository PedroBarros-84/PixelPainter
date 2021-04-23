package org.academiadecodigo.bootcamp;

import java.io.*;

public class FileManager {

    private static final String FILE_PATH = "PixelPainter.txt";

    public static String readFile() {

        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line = bufferedReader.readLine();

            while (line != null) {
                result.append(line).append("\n");
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

        return result.toString();
    }

    public static void writeToFile(String painting) {

        BufferedWriter bufferedWriter = null;

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            bufferedWriter.write(painting);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
    }

}
