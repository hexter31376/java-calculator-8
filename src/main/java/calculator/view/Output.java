package calculator.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Output {
    public void print (String string) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write("결과 : " + string);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
