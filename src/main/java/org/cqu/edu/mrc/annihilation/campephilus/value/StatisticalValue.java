package org.cqu.edu.mrc.annihilation.campephilus.value;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/1 20:13
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * total代表所有数据
 */
@Data
@Component
public class StatisticalValue {

    /**
     * 参与医院的代号
     */
    private HashSet<String> hospitalNumber;

    /**
     * 参与仪器的SN码
     */
    private HashSet<String> deviceNumber;

    /**
     * 每天手术顺序号
     */
    private List<Integer> operationNumberList;

    /**
     * 手术次数的统计，总的数量
     */
    private Integer operationTotal;

    /**
     * 每天采集器上传数量
     */
    private List<Integer> collectorUploadList;

    /**
     * 采集器上传数量统计，总的数量
     */
    private Long collectorUploadTotal;

    public StatisticalValue() {
        this.hospitalNumber = new HashSet<>();
        this.deviceNumber = new HashSet<>();
        this.operationNumberList = new ArrayList<>();
        this.operationTotal = 0;
        this.collectorUploadList = new ArrayList<>();
        this.collectorUploadTotal = 0L;
    }
}
