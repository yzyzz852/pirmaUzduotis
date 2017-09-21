import java.io.File;

public class SystemInfoClass {

    private String infoString;

    public void getSystemMemoryInfo(){

        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println("Diskas: " + root.getAbsolutePath());
            System.out.println("Bendra talpa (bytes): " + root.getTotalSpace());
            System.out.println("Laiva atmintis(bytes): " + root.getFreeSpace());
            System.out.println("Panaudota atmintis(bytes): " + root.getUsableSpace());
        }
    }

}
