package src.modules;

import src.helpers.objects.triangle;
import src.interfaces.helperInterfaces.TriangleParser;
import src.interfaces.moduleInterfaces.parsermodule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserModule implements parsermodule {
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
