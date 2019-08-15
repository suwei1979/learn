/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.batch;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Batch {
    @Setter(AccessLevel.NONE)
    private String batchId;
    private String batchDate;
    private String productCode;
    private int batchStatus;
    private State state;
    public Batch(String batchId, String productCode) {
        this.batchId = batchId;
        this.productCode = productCode;
        this.batchStatus = 0;
        this.state = State.INIT;
    }

    public void start() {
        this.state = state.start();
    }

    public void finish() {
        this.state = state.finish();

    }

    public void book() {
        this.state = state.finish();
    }

    public enum State {
        INIT("I", "初始化") {
            public State book() {
                return BOOKED;
            }
        }, BOOKED("B", "已入库") {
            public State start() {
                return RUNNING;
            }
        }, RUNNING("S", "执行中") {
            public State finish() {
                return FINISHED;
            }

        }, FINISHED("F", "已完成");

        String value, desc;

        State(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        String value() {
            return value;
        }

        String desc() {
            return desc;
        }

        public State start() {
            throw new UnsupportedOperationException("Unsupported state transformation under state: " + desc());
        }

        public State book() {
            throw new UnsupportedOperationException("Unsupported state transformation under state: " + desc());
        }

        public State finish() {
            throw new UnsupportedOperationException("Unsupported state transformation under state: " + desc());
        }
    }

}
