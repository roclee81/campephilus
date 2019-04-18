package org.cqu.edu.msc.annihilation.campephilus.module.statistical.process;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInformationService;
import org.cqu.edu.msc.annihilation.campephilus.module.statistical.service.StatisticalService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/3 19:17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@Component
public class Processor {


    private final CollectorInformationService collectorInformationService;
    private final OperationInformationService operationInformationService;
    private final StatisticalService statisticalService;

    @Autowired
    public Processor(CollectorInformationService collectorInformationService, OperationInformationService operationInformationService, StatisticalService statisticalService) {
        this.collectorInformationService = collectorInformationService;
        this.operationInformationService = operationInformationService;
        this.statisticalService = statisticalService;
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("campephilus"),
            key = "saveOperationInformationDO",
            value = @Queue("statistical")
    ))
    public void processSaveOperationInformationDO(ParseDataDTO parseDataDTO) {
        statisticalService.updateStatisticalDOOperationInformationWhenUpdateSuccess(parseDataDTO);
    }

        @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("campephilus"),
            key = "request",
            value= @Queue("statistical")
    ))
    public void processInst(ParseDataDTO parseDataDTO) {
            collectorInformationService.updateCollectorInformationDOWhenUpdateSuccess(parseDataDTO);
    }

//    StatisticalRequestCache.secondRequest++;


}
