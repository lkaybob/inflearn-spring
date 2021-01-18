package me.lkaybob.appeventlistener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgumentListener {
    public ArgumentListener(ApplicationArguments arguments) {
        // java -jar target/*.jar -Dfoo --bar 하면은?
        System.out.println("foo: " + arguments.containsOption("foo")); // false (VM option)
        System.out.println("bar: " + arguments.containsOption("bar")); // true (CLI argument)
    }
}
