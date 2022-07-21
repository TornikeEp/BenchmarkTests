package src;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/*
    Task: Create benchmark tests for stringBuffer and stringBuilder.
    Results:            StringBuilder ====== StringBuffer
         append agvt  - 16828 ± 3978         43180 ± 11750
         insert avgt  - 60158 ± 70084        92867 ± 12493
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
}
