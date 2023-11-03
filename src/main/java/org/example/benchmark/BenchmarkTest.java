package org.example.benchmark;

import org.example.StringOrderedLinkedList;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Separate it and benchmark as blackbox.
 */
@State(Scope.Thread)
public class BenchmarkTest {

    public StringOrderedLinkedList stringOrderedLinkedList = new StringOrderedLinkedList();

    static ArrayList<String> generateArrayString(int n) {
        byte[] array = new byte[256];
        String randomString = new String(array, Charset.forName("UTF-8"));

        ArrayList<String> chars = new ArrayList();
        for (int k = 0; k < randomString.length(); k++) {
            char ch = randomString.charAt(k);
            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                chars.add(String.valueOf(ch));
                n--;
            }
        }
        return chars;
    }

    @Setup
    public void setup() {
        generateArrayString(20)
                .forEach(chr -> stringOrderedLinkedList.add(chr));
    }

    @Fork(2)
    @Benchmark
    public void init() {
        stringOrderedLinkedList.add("T");
        stringOrderedLinkedList.remove("T");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                .warmupIterations(0)
                .measurementIterations(3)
                .build();

        new Runner(opt).run();
    }
}
