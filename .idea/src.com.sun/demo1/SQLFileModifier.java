package org.day.day2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author SunYB
 * @Package：org.day.day2
 * @Project：DayN
 * @Date 2023/8/24 12:43
 * @Version
 */
public class SQLFileModifier {
    public static void main(String[] args) {
        String filePath = "";
        String new_file = "";
        String modifiedContent = modifyFileContent(filePath);
        saveToFile(new_file, modifiedContent);
    }

    private static String modifyFileContent(String filePath) {
        StringBuilder modifiedContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 修改内容
                line = line.replace("into ''NJACC.ACCT660001''", "into `NJACC.ACCT660001`");
//                line = line.replace("TO_DATE", "STR_TO_DATE");
                line = line.replace("str_to_date", "STR_TO_DATE");
//                line = line.replace("MM/DD/YYYY HH24:MI:SS", "%Y-%m-%d %H:%i:%s");
                line = line.replace("%Y-%m-%d %h:%i:%s", "%Y-%m-%d %H:%i:%s");
                modifiedContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modifiedContent.toString();
    }

    private static void saveToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
