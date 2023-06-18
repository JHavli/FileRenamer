package FileRenamer;

import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        String directory = ""; //ad your path here
        String baseName = "Test_";

        renameFiles(directory, baseName);
    }

    public static void renameFiles(String directory, String baseName) {
        File folder = new File(directory);

        if (!folder.isDirectory()) {
            System.out.println("Invalid directory: " + directory);
            return;
        }

        File[] files = folder.listFiles();

        int count = 1;
        for (File file : files) {
            if (file.isFile()) {
                String oldName = file.getName();
                String fileExtension = oldName.substring(oldName.lastIndexOf('.'));
                String newName = baseName + String.format("%03d", count) + fileExtension;

                File newFile = new File(directory + File.separator + newName);

                if (file.renameTo(newFile)) {
                    System.out.println("Renamed " + oldName + " to " + newName);
                } else {
                    System.out.println("Failed to rename " + oldName);
                }
                count++;
            }
        }
    }
}
