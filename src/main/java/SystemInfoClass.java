import java.io.File;

public class SystemInfoClass {

    private String infoString;

    public void getSystemMemoryInfo(){

        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.println("Total space (bytes): " + root.getTotalSpace());
            System.out.println("Free space (bytes): " + root.getFreeSpace());
            System.out.println("Usable space (bytes): " + root.getUsableSpace());
        }
    }

}
