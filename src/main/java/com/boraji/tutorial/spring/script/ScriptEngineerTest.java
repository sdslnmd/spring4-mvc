package com.boraji.tutorial.spring.script;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineerTest {

  private static ScriptEngine engine = null;

  static {
    ScriptEngineManager factory = new ScriptEngineManager();
    engine = factory.getEngineByName("nashorn");
  }

  private static void call() {
    try {

      String js;
      js = "var arr=[]\n;";
      js += "var map = Array.prototype.map \n";
      js += "var names = [\"john\", \"jerry\", \"bob\"]\n";
      js += "var a = map.call(names, function(name) { return name.length() })\n";
      js += "arr.push(a)";

      engine.eval(js);


    //engine.eval(new FileReader("script.js"));


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {

    Stopwatch started = Stopwatch.createStarted();

    for (int i = 0; i < 1000; i++) {

      ScriptEngineerTest.call();
    }


    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));

  }

}
