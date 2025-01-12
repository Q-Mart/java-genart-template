package org.example;

import org.apache.commons.cli.*;
import processing.core.PApplet;

import java.util.Random;

public class Main extends PApplet {
    private long randomSeed = System.currentTimeMillis() / 1000;

    private Random r = new Random(randomSeed);

    public void settings() {
        Options options = new Options();

        Option randomSeedOpt = new Option(
                "r",
                "random_seed",
                true,
                "The random seed to use when running this program"
        );

        options.addOption(randomSeedOpt);
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("r")) {
                randomSeed = Long.parseLong(cmd.getOptionValue("r"));
            }

            noiseSeed(randomSeed);
            size(1024, 768);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
    }

    public void setup() {
        // Change to HSB colours
        colorMode(HSB, 360, 100, 100);

        // Only draw once
        noLoop();

        // Don't leave an outline when creating shapes
        noStroke();
    }

    public void draw(){
        background(64);
        ellipse(250, 250, 20, 20);

        // Save output
        save("../outputs/"+randomSeed+".tiff");
    }

    public static void main(String[] args) {
        PApplet.main("org.example.Main", args);
    }
}