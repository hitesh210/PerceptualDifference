package FileProcessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import juice.driverClass;
import SiteContext.siteContext;

import com.google.inject.Inject;

public class FileProcessing {
    private siteContext context;

    @Inject
    public FileProcessing(driverClass d, siteContext context) {

        super();

        this.context = context;
    }

    public void generateReport(
            String scenarioName) {
        /*
         * File file = new File("target\\ExecutionReport.html"); boolean f = false; try { if (file.exists()) f =
         * file.delete(); Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
         */

        File folder = new File("target\\screenshots");
        File[] listOfFiles = folder.listFiles();
        List<String> results = new ArrayList<String>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("html")) {
                // results.add(listOfFiles[i].getAbsolutePath());
                results.add(listOfFiles[i].getName());
            }
        }
        String text =
                "<html><title>Report</title><body></br/></br/></br/><h2><center>Test Execution Report</center></h2><center><table border=1><tr><td><b>Scenario Name</b></td><td><b>Percent Difference</b></td><td><b>Link</b></td></tr>";

        for (String filename : results) {
            String[] splitName = filename.split("_");
            String percentDiff = splitName[splitName.length - 1].replaceAll(".html", "");
            text =
                    text + "<tr><td>" + scenarioName + "</td><td>" + percentDiff + "</td><td><a href=screenshots/"
                            + filename + ">Report</a></td><td></tr>";
        }
        text = text + "</table></center><br/><br/></body></html>";
        generateExecutionReport(text);
    }

    public void generateExecutionReport(
            String text) {
        File file = new File("target\\ExecutionReport.html");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(file, text);
    }

    public void writeFile(
            File file, String text) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(text);
            bw.close();
            // System.out.println("Script Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanReports() {
        createDirectory();
        File folder = new File("target\\screenshots");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                listOfFiles[i].delete();
            }
        }

        File file = new File("target\\ExecutionReport.html");
        if (file.exists())
            file.delete();

    }

    public void generateHtml(
            String productType, double diffPercent) {

        /*
         * String fileName1 = "D:/workspace/Perceptual.Difference/target/screenshots/" + productType + "1.png"; String
         * fileName2 = "D:/workspace/Perceptual.Difference/target/screenshots/" + productType + "2.png"; String
         * fileName3 = "D:/workspace/Perceptual.Difference/target/screenshots/diff_" + productType + ".png"; String
         * fileName4 = "D:/workspace/Perceptual.Difference/target/screenshots/combined_" + productType + ".png";
         */
        String fileName1 = productType + "1.png";
        String fileName2 = productType + "2.png";
        String fileName3 = "diff_" + productType + ".png";
        String fileName4 = "combined_" + productType + ".png";

        String screen1 = "<a href=\"" + fileName1 + "\">screenshot1</a>";
        String screen2 = "<a href=\"" + fileName2 + "\">screenshot2</a>";
        String diff = "<a href=\"" + fileName3 + "\">difference</a>";
        String combined = "<a href=\"" + fileName4 + "\">combined image</a>";

        String text =
                "<html><title>Report</title><body></br/></br/><h2><center>Test Execution Report</h2></center><center><table border=1><tr><td><b>Product Type</b></td><td><b>Env 1 screenshot</b></td><td><b>Env 2 screenshot</b></td><td><b>Difference screenshot</b></td><td><b>Combined Image</b></td><td><b>Percent difference</b></td></tr>";
        text =
                text + "<tr><td>" + productType + "</td><td>" + screen1 + "</td><td>" + screen2 + "</td><td>" + diff
                        + "</td><td>" + combined + "</td><td>" + diffPercent + "</td></tr>";
        text = text + "</table></center><br/><br/></body></html>";
        generateProductReport(text, productType, ((float) diffPercent));
    }

    public void generateProductReport(
            String text, String productType, float diffPercent) {
        String fileName = "target\\screenshots\\" + productType + "_" + diffPercent + ".html";
        File file = new File(fileName);
        writeFile(file, text);
    }

    public void createDirectory() {
        File file = new File("target\\screenshots");
        if (!file.exists()) {
            if (file.mkdir()) {
            } else
                System.out.println("Failed to create directory!");
        }
    }
}
