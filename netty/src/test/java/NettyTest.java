
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/19 10:28]
 */
public class NettyTest {

    @Test
    public void testTimeWheel() {
        watchDog();
    }

    public void watchDog() {
        HashedWheelTimer wheelTimer = new HashedWheelTimer();
        wheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("我是看门狗,每隔3s 执行一次！:" + new Date());
                watchDog();
            }
        }, 3, TimeUnit.SECONDS);
    }

}