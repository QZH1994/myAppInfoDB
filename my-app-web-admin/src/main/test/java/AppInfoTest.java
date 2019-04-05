import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

/**
 * @author Mr.Bug
 * @version 1.0
 * @date 2019/4/5 18:18
 * @since 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context*.xml")
public class AppInfoTest {
    @Test
    public void test() {
        System.out.println(DigestUtils.md5DigestAsHex("12345".getBytes()));
    }
}
