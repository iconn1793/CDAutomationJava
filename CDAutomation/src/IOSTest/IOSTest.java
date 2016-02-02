package IOSTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import elements.IOSDrivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IOSTest extends IOSDrivers {
       @Test
   public void test01_a() throws Exception {
       log("Running Test01");
       Thread.sleep(2000);
   }
       @Test
   public void test02_b() throws Exception {
       log("Running Test02");
       Thread.sleep(2000);
   }
       @Test
   public void test03_c() throws Exception {
       log("Running Test03");
       Thread.sleep(2000);
   }
}