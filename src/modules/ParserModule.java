package src.modules;

import src.helpers.objects.triangle;
import src.interfaces.TriangleParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserModule {
    public TriangleParser triangleParser;

    public ParserModule() {    }
    public void parseFile(String inputFileName, ArrayList<triangle> outputlistName)
    {
        File inputfile = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputfile))) {
            triangleParser.ParseTriangleList(reader, outputlistName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
