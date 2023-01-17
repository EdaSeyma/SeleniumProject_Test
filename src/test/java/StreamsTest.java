import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
        @Test
        public void regular() {
            List<String> names = new ArrayList<>();
            names.add("Abhijeet");
            names.add("Don");
            names.add("Alex");
            names.add("Eda");
            int count = 0;
            for (int i = 0; i < names.size(); i++) {
                String actual = names.get(i);
                if (actual.startsWith("A")) {
                    count++;
                }

            }
            System.out.println(count);
        }
        @Test
        public void streamFilter() {
            List<String> names = new ArrayList<>();
            names.add("Abhijeet");
            names.add("Don");
            names.add("Alex");
            names.add("Eda");
            names.add("Donald");
            Long c=names.stream().filter(str->str.startsWith("A")).count();
            System.out.println(c);
            Long d=Stream.of("Abhijeet","Don","Alex","Eda").filter(s->s.startsWith("A") ).count();
            System.out.println(d);
            names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
            names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s));
            names.stream().filter(s->s.contains("Don")).forEach(s-> System.out.println(s));
        }
        @Test
        public  void streamMap() {
            ArrayList<String> names = new ArrayList<String>();
            names.add("Abhijeet");
            names.add("Don");
            names.add("Alex");
            names.add("Eda");
            names.add("Donald");
            Stream.of("Eda","Seyma","Seda","Cem","Senem").filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
            List<String> names1= Arrays.asList("Ali","Ayşe");
            Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
            //newStream.sorted().forEach(s-> System.out.println(s));

            boolean flag =newStream.anyMatch(s->s.equalsIgnoreCase("Eda"));
            System.out.println(flag);
            Assert.assertTrue(flag);
        }
        @Test
        public void streamCollect(){
            List<String> ls = Stream.of("Eda","Seyma","Tolga").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
            System.out.println(ls.get(0));
        }
    }