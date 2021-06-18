package elpayload;

import com.google.common.io.Resources;
import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import org.junit.jupiter.api.Test;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ElPayloadTest {
  @Test
  void basicTest() throws IOException {
    ExpressionFactory factory = new ExpressionFactoryImpl();
    ELContext context = new SimpleContext();
    String expressionString = Resources.toString(ElPayloadTest.class.getResource("/expression-read-url.el"), StandardCharsets.UTF_8);
    expressionString = Arrays.stream(expressionString.split("\n"))
        .map(line -> line.replaceAll("^\\s+", ""))
        .collect(Collectors.joining());
    expressionString = String.format("${%s}", expressionString);
    System.out.println(expressionString);
    ValueExpression expression = factory.createValueExpression(context, expressionString, Object.class);
    System.out.println(expression.getValue(context));
  }
}
