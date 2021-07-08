package icu.shishc.kafka.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Data
public class Message<T> implements Serializable {

    private String id;
    private T content;

}
