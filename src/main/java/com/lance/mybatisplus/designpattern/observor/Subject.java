package com.lance.mybatisplus.designpattern.observor;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatisplus  Subject
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:19
 **/

@Data
public abstract class Subject {
    private List<Observor> observors = new ArrayList<>();

    private Integer state;

    public abstract void changeState(Integer state);

    public void registerObservor(Observor observor) {
        observors.add(observor);
    }

    public void removeeObservor(Observor observor) {
        observors.remove(observor);
    }

    public void notifiAllObservors() {
        for (Observor o : observors) {
            o.update();
        }
    }
}
