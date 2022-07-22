package src.src;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/*
    Task: Create benchmark tests for stringBuffer and stringBuilder.
    Results:            StringBuilder ====== StringBuffer
         append avgt  - 16828 ± 3978         43180 ± 11750
         insert avgt  - 60158 ± 70084        92867 ± 12493
         reverse avgt - 12.319 ± 0.69        28113 ± 58376
         replace avgt - 7089 ± 2356          53369 ± 6008
 */
public class Main {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void appendWithStringBuilder(Blackhole blackhole) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(i);
        }
        blackhole.consume(stringBuilder);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void appendWithStringBuffer(Blackhole blackhole) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(i);
        }
        blackhole.consume(stringBuffer);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void insertWithStringBuilder(Blackhole blackhole) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 1000; i++) {
            stringBuilder.insert(0, i);
        }
        blackhole.consume(stringBuilder);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void insertWithStringBuffer(Blackhole blackhole) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < 1000; i++) {
            stringBuffer.insert(0, i);
        }
        blackhole.consume(stringBuffer);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void reverseWithStringBuilder(Blackhole blackhole) {
        StringBuilder stringBuilder = new StringBuilder("abcd");
        for (int i = 0; i < 1000; i++) {
            stringBuilder.reverse();
        }
        blackhole.consume(stringBuilder);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void reverseWithStringBuffer(Blackhole blackhole) {
        StringBuffer stringBuffer = new StringBuffer("abcd");
        for (int i = 0; i < 1000; i++) {
            stringBuffer.reverse();
        }
        blackhole.consume(stringBuffer);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void replaceWithStringBuilder(Blackhole blackhole) {
        StringBuilder stringBuilder = new StringBuilder("abcd");
        for (int i = 0; i < 1000; i++) {
            stringBuilder.replace(i % 3, i % 3 + 1, "f");
        }
        blackhole.consume(stringBuilder);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void replaceWithStringBuffer(Blackhole blackhole) {
        StringBuffer stringBuffer = new StringBuffer("abcd");
        for (int i = 0; i < 1000; i++) {
            stringBuffer.replace(i % 3, i % 3 + 1, "f");
        }
        blackhole.consume(stringBuffer);
    }
}
