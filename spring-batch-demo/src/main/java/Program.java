import com.acedemand.batch.ParallelService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Pamir on 4/14/2015.
 */
public class Program {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ParallelService service = (ParallelService)context.getBean(ParallelService.class);
        ArrayList<Long> idList = new ArrayList<Long>();
        for(int i =0 ; i < 10; ++i){
            idList.add(new Long(i));
        }
        service.process(idList);

    }
}
