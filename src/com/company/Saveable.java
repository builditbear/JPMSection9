package com.company;

import java.util.List;

public interface Saveable {
    // Returns a list of the values that are being "written" to an imaginary file. It only returns a list of String
    // values so that we can see feedback showing that the method did indeed process the expected values.
    List<String> write();
    // Reads values from a "file", simulated by a List, to populate the fields of the calling object.
    void read(List<String> file);
}
