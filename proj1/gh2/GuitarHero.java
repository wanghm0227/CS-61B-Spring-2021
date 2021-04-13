package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_A = 440.0;

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString string = new GuitarString(CONCERT_A);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index > -1) {
                    string = new GuitarString(CONCERT_A * Math.pow(2, (index - 24) / 12.0));
                    string.pluck();
                }
            }

            double sample = string.sample();
            StdAudio.play(sample);
            string.tic();
        }

    }
}
