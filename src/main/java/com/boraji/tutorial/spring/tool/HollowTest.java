package com.boraji.tutorial.spring.tool;

import com.boraji.tutorial.spring.pojo.Movie;
import com.netflix.hollow.api.producer.HollowProducer;
import com.netflix.hollow.api.producer.HollowProducer.Populator;
import com.netflix.hollow.api.producer.HollowProducer.WriteState;
import com.netflix.hollow.api.producer.fs.HollowFilesystemAnnouncer;
import com.netflix.hollow.api.producer.fs.HollowFilesystemPublisher;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class HollowTest {


  public static void publishAndAnnouncerTestDemo() {

    List<Movie> movies = Arrays
        .asList(new Movie(1, "The Matrix", 1999), new Movie(2, "Beasts of No Nation", 2015), new Movie(3, "Pulp Fiction", 1994));

    File localPublishDir = new File("/Users/sunluning/Downloads/tmp");

    HollowFilesystemPublisher publisher = new HollowFilesystemPublisher(localPublishDir);
    HollowFilesystemAnnouncer announcer = new HollowFilesystemAnnouncer(localPublishDir);

    HollowProducer producer = HollowProducer.withPublisher(publisher).withAnnouncer(announcer).build();

    producer.runCycle(new Populator() {
      @Override
      public void populate(WriteState writeState) throws Exception {
        for (Movie movie : movies) {
          writeState.add(movie);
        }
      }
    });

  }


  public static void main(String[] args) {
    HollowTest.publishAndAnnouncerTestDemo();
  }

}
