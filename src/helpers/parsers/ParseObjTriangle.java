package src.helpers.parsers;

import src.helpers.objects.triangle;
import src.helpers.objects.vector3;
import src.interfaces.helperInterfaces.TriangleParser;
import src.interfaces.helperInterfaces.VertexParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseObjTriangle implements TriangleParser {

    VertexParser vertexParser;
    public ParseObjTriangle(VertexParser vertexParser) {
        this.vertexParser = vertexParser;
    }

    @Override
    public void ParseTriangleList(BufferedReader reader, ArrayList<triangle> outputlistName) throws IOException {
        ArrayList<vector3> vertexList = new ArrayList<vector3>();
        vertexParser.ParseVertexList(reader, vertexList);

    //todo get vertexes from vertexparser and parse the triangles while putting them in the outputlist
    }
}
