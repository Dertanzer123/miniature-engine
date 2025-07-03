package src.interfaces;

import src.helpers.objects.triangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface TriangleParser {
    void ParseTriangleList(BufferedReader reader, ArrayList<triangle> outputlistName) throws IOException;
}
