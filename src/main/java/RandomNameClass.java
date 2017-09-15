import org.kohsuke.randname.RandomNameGenerator;

import java.util.Random;

public class RandomNameClass {
    String randomName;
    Random random = new Random();

    public String gettRandomName() {
        int ribos;
        ribos = random.nextInt(10);
        RandomNameGenerator randomNameGenerator = new RandomNameGenerator(ribos);
        randomName = randomNameGenerator.next();
        return randomName;
    }

}
