package src.interfaces;

import src.helpers.objects.vector3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface VertexParser {
    void ParseVertexList(BufferedReader reader, ArrayList<vector3> outputlistName) throws IOException;
}
