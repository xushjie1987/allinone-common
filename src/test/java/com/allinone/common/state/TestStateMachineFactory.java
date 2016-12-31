/**
 * Project Name:allinone-common
 * File Name:TestStateMachineFactory.java
 * Package Name:com.allinone.common.state
 * Date:2016年12月31日下午9:34:18
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.state;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import org.junit.Test;

/**
 * ClassName:TestStateMachineFactory <br/>
 * Function: <br/>
 * Date: 2016年12月31日 下午9:34:18 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class TestStateMachineFactory {
    
    /**
     * ClassName: EventType <br/>
     * Function: <br/>
     * date: 2016年12月31日 下午10:42:52 <br/>
     *
     * @author shengjie
     * @version TestStateMachineFactory
     * @since JDK 1.8
     */
    public static enum EventType {
        INIT,
        START,
        RUN,
        STOP;
    }
    
    /**
     * ClassName: State <br/>
     * Function: <br/>
     * date: 2016年12月31日 下午10:42:54 <br/>
     *
     * @author shengjie
     * @version TestStateMachineFactory
     * @since JDK 1.8
     */
    public static enum State {
        ZERO,
        INITED,
        STARTED,
        RUNNING,
        FAILED,
        END;
    }
    
    /**
     * ClassName: Event <br/>
     * Function: <br/>
     * date: 2016年12月31日 下午10:42:57 <br/>
     *
     * @author shengjie
     * @version TestStateMachineFactory
     * @since JDK 1.8
     */
    public static class Event {
        public Integer id;
        public String  msg;
        
        public Event(Integer id,
                     String msg) {
            this.id = id;
            this.msg = msg;
        }
        
        @Override
        public String toString() {
            return "Event [id=" + id + ", msg=" + msg + "]";
        }
    }
    
    /**
     * ClassName: Operand <br/>
     * Function: <br/>
     * date: 2016年12月31日 下午10:43:00 <br/>
     *
     * @author shengjie
     * @version TestStateMachineFactory
     * @since JDK 1.8
     */
    public static class Operand {
        
        public void toStart(Event event) {
            System.out.println(Objects.toString(event));
        }
        
        public void toRun(Event event) {
            System.out.println(Objects.toString(event));
        }
        
        public State toState(Event event) {
            System.out.println(Objects.toString(event));
            if (System.currentTimeMillis() % 2 == 0) {
                return State.END;
            } else {
                return State.FAILED;
            }
        }
        
    }
    
    /**
     * test1: <br/>
     * 
     * @author shengjie
     * @since JDK 1.8
     */
    @Test
    public void test1() {
        Operand operand = new Operand();
        StateMachine<State, EventType, Event> machine = new StateMachineFactory<Operand, State, EventType, Event>(State.ZERO).addTransition(State.ZERO,
                                                                                                                                            State.INITED,
                                                                                                                                            EventType.INIT)
                                                                                                                             .addTransition(State.INITED,
                                                                                                                                            State.STARTED,
                                                                                                                                            EventType.START,
                                                                                                                                            Operand::toStart)
                                                                                                                             .addTransition(State.STARTED,
                                                                                                                                            State.RUNNING,
                                                                                                                                            EventType.RUN,
                                                                                                                                            Operand::toRun)
                                                                                                                             .addTransition(State.RUNNING,
                                                                                                                                            new HashSet<State>(Arrays.asList(State.FAILED,
                                                                                                                                                                             State.END)),
                                                                                                                                            EventType.STOP,
                                                                                                                                            Operand::toState)
                                                                                                                             .installTopology()
                                                                                                                             .make(operand);
        machine.doTransition(EventType.INIT,
                             new Event(0,
                                       "initting"));
        System.out.println("当前状态机状态：" + machine.getCurrentState());
        machine.doTransition(EventType.START,
                             new Event(1,
                                       "startting"));
        System.out.println("当前状态机状态：" + machine.getCurrentState());
        machine.doTransition(EventType.RUN,
                             new Event(2,
                                       "running"));
        System.out.println("当前状态机状态：" + machine.getCurrentState());
        machine.doTransition(EventType.STOP,
                             new Event(3,
                                       "stopping"));
        System.out.println("当前状态机状态：" + machine.getCurrentState());
    }
}
