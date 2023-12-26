package org.example.entity;

import lombok.Data;

@Data
public class Result {
    //    id
    private Integer id;
    //   配置信息
    private ConfigData config_data;
    //   输入数据
    private InputData input_data;
    //   输出数据汇总
    private Summary summary;

    public Result(ConfigData config_data, InputData input_data, Summary summary) {
        this.config_data = config_data;
        this.input_data = input_data;
        this.summary = summary;
    }
}
