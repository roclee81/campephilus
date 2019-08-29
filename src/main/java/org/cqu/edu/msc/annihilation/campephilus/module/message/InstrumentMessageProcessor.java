package org.cqu.edu.msc.annihilation.campephilus.module.message;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.InstrumentRequestProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author luoxin
 */
@Component
@EnableBinding(InstrumentMessage.class)
@Slf4j
public class InstrumentMessageProcessor {

    @Autowired
    private InstrumentRequestProcessService instrumentRequestProcessService;

    private static final int CORE_SIZE = 2;
    private static final int MAXIMUM_POOL_SIZE = 4;
    private static final int KEEP_ALIVE_TIME = 30;

    private static final ThreadPoolExecutor INSTANCE =
            new ThreadPoolExecutor(
                    CORE_SIZE,
                    MAXIMUM_POOL_SIZE,
                    KEEP_ALIVE_TIME,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(),
                    new InstrumentMessageProcessThreadFactory(),
                    new InstrumentMessageProcessRejectHandler());

    private static ThreadPoolExecutor getDataProcessThreadPoolInstance() {
        return INSTANCE;
    }

    private static class InstrumentMessageProcessRejectHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.info("====== DataProcessThreadPool Rejected ======");
        }
    }

    private static class InstrumentMessageProcessThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            String name = "InstrumentMessageProcessThreadPool-";
            return new Thread(null, r, name);
        }
    }

    @StreamListener(InstrumentMessage.INPUT)
    public void process(Object message) {
        getDataProcessThreadPoolInstance().execute(new ProcessInstrumentMessage((InstrumentForm) message));
    }

    private class ProcessInstrumentMessage implements Runnable {

        InstrumentForm instrumentForm;

        ProcessInstrumentMessage(InstrumentForm instrumentForm) {
            this.instrumentForm = instrumentForm;
        }

        @Override
        public void run() {
            instrumentRequestProcessService.processCode(instrumentForm);
            System.out.println(Thread.currentThread());
        }
    }
}
