

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void createDirectory(String adres) {
        File dir = new File(adres);
        if (dir.mkdir()) {
            System.out.println("Каталог создан");
        }
    }

    public static void createFile(String adres, String name) {
        File file = new File(adres, name);
        try {
            if (file.createNewFile())
                System.out.println("Файл создан");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    //    private static String S1;
    private static ArrayList<File> listWithFileNames = new ArrayList<>();

    public static void getListFiles(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
//                S1= S1+" "+ s.getName();
            } else if (s.isDirectory()) {
                listWithFileNames.add(s);
//               S1= S1+" " + s.getName();
                getListFiles(s.getAbsolutePath());
            }
        }

    }

    public static void main(String[] args) {
        createDirectory("C:\\Games\\src");
        createDirectory("C:\\Games\\res");
        createDirectory("C:\\Games\\savegame");
        createDirectory("C:\\Games\\temp");
        createDirectory("C:\\Games\\src\\main");
        createDirectory("C:\\Games\\src\\test");
        createFile("C:\\Games\\src\\main", "Main.java");
        createFile("C:\\Games\\src\\main", "Utils.java");
        createDirectory("C:\\Games\\res\\drawables");
        createDirectory("C:\\Games\\res\\vectors");
        createDirectory("C:\\Games\\res\\icons");
        createFile("C:\\Games\\temp", "temp.txt");
        StringBuilder catalog = new StringBuilder();
        String path = "C:\\Games";
        File dir = new File(path);

        getListFiles("C:\\Games");

        System.out.println(listWithFileNames);
        try (FileWriter writer = new FileWriter("C:\\Games\\temp\\temp.txt", false)) {
            writer.write(String.valueOf(listWithFileNames));
            writer.append('\n');
            writer.append("Каталоги и файлы успешно созданы!");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

















