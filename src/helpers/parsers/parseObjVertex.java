package src.helpers.parsers;

import src.helpers.objects.vector3;
import src.interfaces.helperInterfaces.VertexParser;

import java.io.BufferedReader;
import java.util.ArrayList;

public class parseObjVertex implements VertexParser {

    public parseObjVertex() {}

    @Override
    public void ParseVertexList(BufferedReader reader, ArrayList<vector3> outputlistName) {
    //todo parse the vertexes from the file and put them in the outputlist
    }
}
