import java.io.*;
import java.util.Scanner;

public class FileOrganizer {
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String path = args[0];
        System.out.println("Please wait a few seconds until the process complete");
        try {
            organizeFiles(path);
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong :");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong :");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something went wrong :");
            e.printStackTrace();
        }
    }
    public static void organizeFiles(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Incorrect Path, Please Retry !");
            System.exit(0);
        }
        File[] files = file.listFiles();
        for (var f : files) {
            organizeFile(f);
        }
    }

    private static void organizeFile(File file) throws IOException {
        String filename = file.getName();
        String filepath = file.getAbsolutePath();
        String home = System.getProperty("user.home");
        if (filename.contains(".jpg") || filename.contains(".png")
                || filename.contains("jpeg") || filename.contains(".gif")
        ) {
            String picPath = home + "/Pictures";
            File f = new File(picPath);
            if (!f.exists()) {
                f.mkdir();
            }
            moveFile(filepath, picPath + "/" + filename);
        } else if (filename.contains(".mp4") || filename.contains(".mov")
                || filename.contains(".mkv")) {
            String vidPath = home + "/Videos";
            File f = new File(vidPath);
            if (!f.exists()) {
                f.mkdir();
            }
            moveFile(filepath, vidPath + "/" + filename);
        } else if (filename.contains(".mp3") || filename.contains(".wav")
                || filename.contains(".flac")
        ) {
            String musicPath = home + "/Music";
            File f = new File(musicPath);
            if (!f.exists()) {
                f.mkdir();
            }
            moveFile(filepath, musicPath + "/" + filename);
        } else if (filename.contains(".pdf") ||
                filename.contains(".txt") || filename.contains(".docx")
        ) {
            String docsPath = home + "/Documents";
            File f = new File(docsPath);
            if (!f.exists()) {
                f.mkdir();
            }
            moveFile(filepath, docsPath + "/" + filename);
        } else if (filename.contains(".zip") ||
                filename.contains(".rar") || filename.contains(".7z") ||
                filename.contains(".xz") || filename.contains(".gz")
        ) {
            String archivePath = home + "/Archives";
            File f = new File(archivePath);
            if (!f.exists()) {
                f.mkdir();
            }
            moveFile(filepath, archivePath + "/" + filename);
        }
    }

    private static void moveFile(String source, String des) throws IOException {
        if (source.equals(des)) return;
        File sourceFile = new File(source);
        File destFile = new File(des);
        FileInputStream input = new FileInputStream(sourceFile);
        FileOutputStream output = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        input.close();
        output.close();
        if (sourceFile.exists() && ! (sourceFile.equals(destFile))) {
            sourceFile.delete();
        }
    }
}
