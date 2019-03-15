package hu.ivgraai.yoti.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.ivgraai.yoti.dao.PayloadRepository;
import hu.ivgraai.yoti.model.Payload;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Gergo Ivan
 */
@Aspect
@Component
public class Logger {

    @Autowired
    private PayloadRepository repo;
    @Autowired
    private ObjectMapper mapper;

    @Around("execution(* hu.ivgraai.yoti.service.HooveringService.navigate(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long millis = System.currentTimeMillis();
        Object retval = joinPoint.proceed();
        try {
            millis = System.currentTimeMillis() - millis;
            Payload entity = new Payload();
            entity.setRequest(mapper.writeValueAsString(joinPoint.getArgs()[0]));
            entity.setResponse(mapper.writeValueAsString(retval));
            entity.setElapsedTime(millis);
            repo.save(entity);
        } catch (Exception e) {
            org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
            logger.warn("Error occurred during logging", e);
        }
        return retval;
    }

}
